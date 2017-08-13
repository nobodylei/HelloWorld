package cn.tedu.vote.service;

import java.util.List;

import cn.tedu.vote.entity.Options;
import cn.tedu.vote.entity.Vote;

public interface VoteService {
	int insertObject(Vote vote);
	
	int insertOption(Options option);
	
	List<Vote> findObjects();
	
	int deleteObjectById(int id);
	
	List<Options> findById(int id);
	
	int doVote(int id);
}
