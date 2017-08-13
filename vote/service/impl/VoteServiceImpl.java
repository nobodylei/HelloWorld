package cn.tedu.vote.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.vote.dao.OptionDao;
import cn.tedu.vote.dao.VoteDao;
import cn.tedu.vote.entity.Options;
import cn.tedu.vote.entity.Vote;
import cn.tedu.vote.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService{
	@Resource
	private VoteDao voteDao;
	@Resource
	private OptionDao optionDao;
	
	
	@Override
	public int insertObject(Vote vote) {
		int result = voteDao.insertObject(vote);
		if (result == -1){
			throw new RuntimeException("创建失败");
		}
		return result;
	}


	@Override
	public List<Vote> findObjects() {
		return voteDao.findObjects();
	}


	@Override
	public int deleteObjectById(int id) {
		optionDao.deleteOptions(id);
		int rows = voteDao.deleteObjectById(id);
		if(rows == -1){
			throw new RuntimeException("删除失败");
		}
		return rows;
	}


	@Override
	public List<Options> findById(int id) {
		return optionDao.findById(id);
	}


	@Override
	public int insertOption(Options option) {
		int rows = optionDao.insertOption(option);
		return rows;
	}


	@Override
	public int doVote(int id) {
		int rows = optionDao.doVote(id);
		if(rows == -1){
			throw new RuntimeException("投票失败");
		}
		return rows;
	}

}
