package cn.ustb.util;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MySession {
	private String dir = "/Users/MouseZhang/Desktop/"; // 文件操作路径
	private Object pojoObject; // 保存要操作的对象
	private String tableName; // 保存要操作的表名称
	private Map<String, String> fieldColumnMap = new HashMap<String, String>(); // 保存类中的属性与列的对应关系
	private Map<String, String> fieldTypeMap = new HashMap<String, String>(); // 保存每一个属性名称以及与对应类型的关系
	private String idColumn; // 保存id列
	private String idName; // 保存id的成员名称
	private String generator; // 保存主键生成方式
	private Map<Integer, FieldNameAndValue> indexValueMap = new HashMap<Integer, FieldNameAndValue>(); // 保存生成SQL语句的占位符索引与POJO类值的对应关系
	public void save(Object obj) {
		this.pojoObject = obj; // 将要操作的对象保存好，通过对象读取内容
		String fileName = this.pojoObject.getClass().getSimpleName() + ".hbm.xml"; // 映射文件名称
		try {
			this.parseHBM(fileName);
			this.saveDatabase(); // 使用JDBC保存数据
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveDatabase() throws Exception { // 进行数据的保存处理
		String sql = this.createInsertSQL(); // 取得要执行的SQL
		System.out.println(sql);
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdb", "root", "root123");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int foot = 1; // 操作的索引内容
		for (int i = 0; i < this.indexValueMap.size(); i++) {
			FieldNameAndValue fnv = this.indexValueMap.get(foot);
			if ("java.lang.String".equals(this.fieldTypeMap.get(fnv.fieldName))) {
				String value = (String) fnv.fieldValue;
				pstmt.setString(foot, value);
			} else if ("java.lang.Integer".equals(this.fieldTypeMap.get(fnv.fieldName))) {
				Integer value = (Integer) fnv.fieldValue;
				pstmt.setInt(foot, value);
			} else if ("java.lang.Double".equals(this.fieldTypeMap.get(fnv.fieldName))) {
				Double value = (Double) fnv.fieldValue;
				pstmt.setDouble(foot, value);
			} else if ("java.util.Date".equals(this.fieldTypeMap.get(fnv.fieldName))) {
				Date value = (Date) fnv.fieldValue;
				pstmt.setDate(foot, new java.sql.Date(value.getTime()));
			}
			foot ++;
		}
		System.out.println("【数据更新】：" + pstmt.executeUpdate());
		conn.close();
	}
	
	private class FieldNameAndValue { // 内部类，存放内容及成员关系
		private String fieldName;
		private Object fieldValue;
		public FieldNameAndValue(String fieldName, Object fieldValue) {
			this.fieldName = fieldName;
			this.fieldValue = fieldValue;
		}
		@Override
		public String toString() {
			return "FieldNameAndValue [fieldName=" + fieldName + ", fieldValue=" + fieldValue + "]";
		}
	}
	
	private String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public Object getFieldValue(String fieldName) { // 取得成员的内容
		try {
			Method met = this.pojoObject.getClass().getMethod("get" + initcap(fieldName));
			return met.invoke(this.pojoObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String createInsertSQL() { // 创建SQL语句
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ").append(this.tableName).append(" ( ");
		StringBuffer columnBuf = new StringBuffer(); // 负责处理列信息保存
		StringBuffer valueBuf = new StringBuffer(); // 负责处理值(?)保存
		int foot = 1; // 表示索引的操作序号
		if ("assigned".equals(this.generator)) { // 必须知道主键的操作类型
			columnBuf.append(this.idColumn).append(",");
			valueBuf.append("?").append(",");
			FieldNameAndValue fnv = new FieldNameAndValue(this.idName, this.getFieldValue(this.idName));
			this.indexValueMap.put(foot, fnv);
			foot ++; // 索引值加1
		} else if ("native".equals(this.generator)) { // 不需要设置id字段
			
		}
		// 通过迭代fieldColumnMap集合取出列的名称
		Iterator<Map.Entry<String, String>> iter = this.fieldColumnMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> me = iter.next();
			columnBuf.append(me.getValue()).append(",");
			valueBuf.append("?").append(",");
			FieldNameAndValue fnv = new FieldNameAndValue(me.getKey(), this.getFieldValue(me.getValue()));
			this.indexValueMap.put(foot, fnv);
			foot ++;
		}
		columnBuf.delete(columnBuf.length() - 1, columnBuf.length());
		valueBuf.delete(valueBuf.length() - 1, valueBuf.length());
		sql.append(columnBuf).append(")").append(" VALUES ").append("( ").append(valueBuf).append(" )");
		return sql.toString();
	}
	
	public void parseHBM(String fileName) throws Exception { // 负责解析Member.hbm.xml文件
		File file = new File(this.dir + fileName);
		SAXReader sax = new SAXReader(); // 定义SAX解析器
		Document document = sax.read(file); // 设置要读取的文件内容
		Element hmRoot = document.getRootElement(); // 读取根元素(<hibernate-mapping>节点)
		Element classElement = hmRoot.element("class"); // 读取class节点(<class>)
		String className = classElement.attributeValue("name");
		// 判断当前的解析文件是否为指定类型对应的映射文件
		if (className.equals(this.pojoObject.getClass().getName())) {
			this.tableName = classElement.attributeValue("table"); // 表名称
			// 接下来应该继续读取class的子节点，包括：<id>、<property>
			Element idElement = classElement.element("id"); // 取得<id>节点
			this.idName = idElement.attributeValue("name"); // 取得name属性
			String typeName = idElement.attributeValue("type"); // 取得type属性
			this.fieldTypeMap.put(idName, typeName); // 保存属性用于生成SQL操作
			Element idColumnElement = idElement.element("column"); // 取得<column>节点
			this.idColumn = idColumnElement.attributeValue("name"); // 取得主键列名称
			Element generatorElement = idElement.element("generator"); // 取得<generator>节点
			this.generator = generatorElement.attributeValue("class"); // 读取生成方式
			// 在整个hbm.xml文件中只有一个<id>元素，但是会有多个<property>元素，就需要使用循环处理
			Iterator<Element> allProperty = classElement.elements("property").iterator();
			while (allProperty.hasNext()) {
				Element property = allProperty.next();
				String propertyName = property.attributeValue("name");
				String propertyType = property.attributeValue("type");
				String columnName = property.element("column").attributeValue("name");
				this.fieldColumnMap.put(propertyName, columnName); // 保存成员与数据列的关系
				this.fieldTypeMap.put(propertyName, propertyType); // 保存成员与数据类型的关系
			}
		} else {
			System.out.println("【出现异常】映射文件没有找到！");
		}
	}
}
