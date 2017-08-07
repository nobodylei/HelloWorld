package cn.tedu.tsms.student.entity;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7092368640108841751L;
	
	private String id;
	private String studentname;
	private String age;
	private String gender;
	private String address;
	private String tel;
	private String qq;
	private String email;
	private String study_type;
	private String education;
	private String school;
	private String profession;
	private String study_begin;
	private String emergency_name;
	private String emergency_name_tel;
	private String birth;
	private String remark;
	private String class_id;
	
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudy_type() {
		return study_type;
	}
	public void setStudy_type(String studtType) {
		this.study_type = studtType;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getstudy_begin() {
		return study_begin;
	}
	public void setstudy_begin(String study_begin) {
		this.study_begin = study_begin;
	}
	public String getemergency_name() {
		return emergency_name;
	}
	public void setemergency_name(String emergency_name) {
		this.emergency_name = emergency_name;
	}
	public String getemergency_name_tel() {
		return emergency_name_tel;
	}
	public void setemergency_name_tel(String emergency_name_tel) {
		this.emergency_name_tel = emergency_name_tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", tel=" + tel + ", qq=" + qq + ", email=" + email + ", studt_type=" + study_type + ", education="
				+ education + ", school=" + school + ", profession=" + profession + ", study_begin=" + study_begin
				+ ", emergency_name=" + emergency_name + ", emergency_name_tel=" + emergency_name_tel + ", birth=" + birth
				+ ", remark=" + remark + ", class_id=" + class_id + "]";
	}
	
}
