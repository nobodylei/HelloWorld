

package cn.tedu.vote.entity;

/**
 * 选项
 * @author Administrator
 *
 */
public class Options {
	/**选项id*/
	private Integer id;
	
	/**投票id*/
	private Integer voteId;
	
	/**选项*/
	private String option;
	/**票数*/
	private Integer num;
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}
