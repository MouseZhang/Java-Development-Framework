package cn.ustb.action;

import java.io.File;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.util.UploadFileUtil;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	private String name;
	private File photo;
	private String photoFileName;
	private String photoContentType;
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public void insert() {
		UploadFileUtil ufu = new UploadFileUtil(this.photo, this.photoContentType);
		String fileName = ufu.getFileName();
		System.out.println("新的文件名称：" + fileName);
		String filePath = ServletActionContext.getServletContext().getRealPath("/upload/") + fileName;
		try {
			System.out.println(ufu.saveFile(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
