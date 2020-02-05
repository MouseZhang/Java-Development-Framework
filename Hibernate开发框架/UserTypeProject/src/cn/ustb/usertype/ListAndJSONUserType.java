package cn.ustb.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

// 这个工具类用于实现List集合与String间的互相转换
public class ListAndJSONUserType implements UserType {

	/**
	 * 反序列化操作，当用户进行数据保存的时候，需要将List集合变为JSON数据
	 */
	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		StringBuffer buf = new StringBuffer();
		List<String> all = (List<String>) owner; // 将传入的集合进行接收
		Iterator<String> iter = all.iterator();
		while (iter.hasNext()) {
			array.add(iter.next());
		}
		obj.put("emails", array);
		return obj.toString();
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null) { // 有内容
			List<String> oldList = (List<String>) value;
			List<String> newList = new ArrayList<String>();
			newList.addAll(oldList); // 整体增加
			return newList;
		}
		return null;
	}

	/**
	 * 序列化操作，将返回的JSON变为List集合
	 * 在数据读取完成之后，POJO类里面应该用的List集合
	 */
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		List<String> all = new ArrayList<String>();
		JSONObject obj = JSONObject.fromObject(value);
		JSONArray array = obj.getJSONArray("emails");
		for (int i = 0; i < array.size(); i++) {
			all.add(array.getString(i));
		}
		return (Serializable) all;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x.equals(y); // 交由每个POJO类的equals()比较完成
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		// 当取得数据之后，需要将数据变为List集合
		return this.disassemble(rs.getString(names[0]));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.NULL);
		} else {
			st.setString(index, this.assemble(session, value).toString());
		}
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Class returnedClass() {
		return List.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

}
