package cn.ustb.dao;

import cn.ustb.vo.News;

public interface INewsDAO {
	public boolean doCreate(News vo) throws Exception;
}
