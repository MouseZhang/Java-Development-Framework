package cn.ustb.util;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component(value="md5") // 用于在applicationContext.xml中引用使用
public class MD5Encoder implements PasswordEncoder {

	@Override
	public String encodePassword(String pwd, Object salt) {
		return new MD5Code().getMD5ofStr(pwd);
	}

	@Override
	public boolean isPasswordValid(String pwd, String orig, Object salt) {
		return pwd.equals(new MD5Code().getMD5ofStr(orig));
	}

}
