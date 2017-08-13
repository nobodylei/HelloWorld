package cn.tedu.vote.dao;

import java.util.List;

import cn.tedu.vote.entity.Vote;

public interface VoteDao {
	int insertObject(Vote vote);
	
	List<Vote> findObjects();
	
	int deleteObjectById(int id);
}
