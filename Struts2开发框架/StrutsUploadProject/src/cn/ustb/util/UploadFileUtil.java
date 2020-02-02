package cn.ustb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class UploadFileUtil {
	private File uploadFile; // 保存上传文件的内容
	private String contentType; // 保存上传文件的类型
	private String fileName; // 保存生成文件的名称
	/**
	 * 构造进行操作的文件内容以及文件类型
	 * @param uploadFile 包含上传文件的信息
	 * @param contentType 上传文件的类型
	 */
	public UploadFileUtil(File uploadFile, String contentType) {
		this.uploadFile = uploadFile;
		this.contentType = contentType;
	}
	/**
	 * 取得文件名称，根据uuid生成
	 * @return 返回一个不会重复的文件名称
	 */
	public String getFileName() { // 取得文件名称
		if (this.fileName == null || "".equals(this.fileName)) { // 没有文件名称
			String fileExt = null; // 保存文件的扩展类型
			if ("image/bmp".equalsIgnoreCase(this.contentType)) {
				fileExt = "bmp";
			} else if ("image/gif".equalsIgnoreCase(this.contentType)) {
				fileExt = "gif";
			} else if ("image/jpeg".equalsIgnoreCase(this.contentType)) {
				fileExt = "jpg";
			} else if ("image/png".equalsIgnoreCase(this.contentType)) {
				fileExt = "png";
			}
			this.fileName = UUID.randomUUID() + "." + fileExt;
		}
		return this.fileName;
	}
	
	public boolean saveFile(String outFilePath) throws IOException { // 文件的保存操作
		File file = new File(outFilePath);
		OutputStream out = null;
		InputStream in = null;
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			out = new FileOutputStream(file);
			in = new FileInputStream(this.uploadFile);
			byte[] data = new byte[2048]; // 每次读取的内容
			int len = 0;
			while ((len = in.read(data)) != -1) {
				out.write(data, 0, len);
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}
	
	// 此时的保存操作会与Struts框架绑定在一起，有耦合问题
	public boolean saveFile() throws IOException { // 文件的保存操作
		File file = new File(ServletActionContext.getServletContext().getRealPath("/upload/") + this.getFileName());
		OutputStream out = null;
		InputStream in = null;
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			out = new FileOutputStream(file);
			in = new FileInputStream(this.uploadFile);
			byte[] data = new byte[2048]; // 每次读取的内容
			int len = 0;
			while ((len = in.read(data)) != -1) {
				out.write(data, 0, len);
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}
	
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}
	
}
