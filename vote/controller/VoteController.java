package cn.tedu.vote.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.vote.entity.Options;
import cn.tedu.vote.entity.Vote;
import cn.tedu.vote.service.VoteService;

@Controller
public class VoteController {
	@Resource
	private VoteService voteService;
	
	@RequestMapping("indexUI.do")
	public String index() {
		return "index";
	}
	
	@RequestMapping("doVote.do")
	@ResponseBody
	public void doVote(int id){
		voteService.doVote(id);
	}
	
	@RequestMapping("findVotes.do")
	@ResponseBody
	public List<Vote> findObjects() {
		return voteService.findObjects();
	}
	
	@RequestMapping("findOptions.do")
	@ResponseBody
	public List<Options> findOptions(int id){
		return voteService.findById(id);
	}
	@RequestMapping("save.do")
	@ResponseBody
	public String insertObject(Vote vote) {
		return voteService.insertObject(vote)+"";
	}
	@RequestMapping("saveOption.do")
	@ResponseBody
	public String doSave(Options option) {
		return voteService.insertOption(option)+"";
	}
	
	@RequestMapping("newWin.do")
	public String newWin() {
		return "newWin";
	}
	
	@RequestMapping("deleteVote.do")
	@ResponseBody
	public void deleteVote(int id){
		voteService.deleteObjectById(id);
	}
}
