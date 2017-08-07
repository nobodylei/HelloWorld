package cn.tedu.tsms.common.web;

/**
 * ͨ辅助类
 * @author Administrator
 *
 */
public class JsonResult {
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	
	/**
	 *状态
	 */
	private int state;
	/**
	 * 信息
	 */
	private String message;
	
	/**
	 * 数据
	 */
	private Object data;
	
	public JsonResult(){
		this.state = SUCCESS;
		this.message = "ok";
	}
	public JsonResult(Object data){
		this();
		this.data = data;
	}
	public JsonResult(Throwable e){
		this.state = ERROR;
		this.message = e.getMessage();
	}
	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
}
