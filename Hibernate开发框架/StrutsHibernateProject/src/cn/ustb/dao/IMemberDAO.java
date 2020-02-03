package cn.ustb.dao;

import cn.ustb.pojo.Member;

public interface IMemberDAO {
	public boolean doCreate(Member vo) throws Exception;
}
