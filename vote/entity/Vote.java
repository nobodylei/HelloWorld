package cn.tedu.vote.entity;

import java.util.Date;


public class Vote {
	/**投票id*/
	private Integer id;
	/**投票主题*/
	private String theme;
	/**主题图片*/
	private String img;
	/**选择模式状态*/
	private String option_states;
	/**创建时间*/
	private Date createTime;
	/**截止时间*/
	private String endTime;
	/**投片隐私状态*/
	private String vote_states;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getOption_states() {
		return option_states;
	}
	public void setOption_states(String option_states) {
		this.option_states = option_states;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getVote_states() {
		return vote_states;
	}
	public void setVote_states(String vote_states) {
		this.vote_states = vote_states;
	}
	
	
}
