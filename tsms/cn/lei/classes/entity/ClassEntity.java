package cn.tedu.tsms.classes.entity;

import java.util.Date;
/**
 * 班级实体类
 * @author Administrator
 *
 */
public class ClassEntity {
	/**班级表id*/
	private String id;
	/**班级类型*/
	private String course_id;
	/**班级编号*/
	private String class_number;
	/**教室表id*/
	private String room_id;
	/**课程进度id*/
	private String course_state_id;
	/**开课时间*/
	private Date class_start_time;
	/**结课时间*/
	private Date class_end_time;
	/**学员表id*/
	private String student_id;
	/**班主任*/
	private String class_teacher;
	/**项目经理*/
	private String class_project_manager;
	/**备注*/
	private String class_comment;
	/**班级名称*/
	private String class_name;
	
	//多加入3条信息
	/**教室*/
	private String room_name;
	/**课程进度*/
	private String course_schedule;
	/**学员人数*/
	private String student_number;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getClass_number() {
		return class_number;
	}
	public void setClass_number(String class_number) {
		this.class_number = class_number;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getCourse_state_id() {
		return course_state_id;
	}
	public void setCourse_state_id(String course_state_id) {
		this.course_state_id = course_state_id;
	}
	public Date getClass_start_time() {
		return class_start_time;
	}
	public void setClass_start_time(Date class_start_time) {
		this.class_start_time = class_start_time;
	}
	public Date getClass_end_time() {
		return class_end_time;
	}
	public void setClass_end_time(Date class_end_time) {
		this.class_end_time = class_end_time;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getClass_teacher() {
		return class_teacher;
	}
	public void setClass_teacher(String class_teacher) {
		this.class_teacher = class_teacher;
	}
	public String getClass_project_manager() {
		return class_project_manager;
	}
	public void setClass_project_manager(String class_project_manager) {
		this.class_project_manager = class_project_manager;
	}
	public String getClass_comment() {
		return class_comment;
	}
	public void setClass_comment(String class_comment) {
		this.class_comment = class_comment;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getCourse_schedule() {
		return course_schedule;
	}
	public void setCourse_schedule(String course_schedule) {
		this.course_schedule = course_schedule;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	@Override
	public String toString() {
		return "ClassEntity [id=" + id + ", course_id=" + course_id + ", class_number=" + class_number + ", room_id="
				+ room_id + ", course_state_id=" + course_state_id + ", class_start_time=" + class_start_time
				+ ", class_end_time=" + class_end_time + ", student_id=" + student_id + ", class_teacher="
				+ class_teacher + ", class_project_manager=" + class_project_manager + ", class_comment="
				+ class_comment + ", class_name=" + class_name + ", room_name=" + room_name + ", course_schedule="
				+ course_schedule + ", student_number=" + student_number + "]";
	}
	


	
	
}

