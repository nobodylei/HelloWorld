package cn.tedu.tsms.common.web;

import java.io.Serializable;

/**
 * 设置分页信息
 * @author Administrator
 *
 */
public class PageObject implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private int pageCurrent = 1;
	/**
	 * 总记录数
	 */
	private int rowCount;
	/**
	 *总页数
	 */
	private int pageCount;
	/**
	 * 每页显示条数
	 */
	private int pageSize=5;
	/**
	 * 起始页位置
	 */
	private int startIndex;

	/**
	 * 计算起始页位置
	 * @return
	 */
	public int getStartIndex(){
		 this.startIndex = (pageCurrent-1)*pageSize;
		 return startIndex;
	}
	
	/**
	 * 计算总页数
	 * @return
	 */
	public int getPageCount(){
		this.pageCount = rowCount / pageSize;
		
		if(rowCount % pageSize != 0){
			this.pageCount += 1;
		}
		
		return pageCount;
		
	}

	public void setPageCount(int pageCount){
		this.pageCount = this.getPageCount();
	}
	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


}
