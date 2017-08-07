package cn.tedu.tsms.student.service;

import java.util.List;
import java.util.Map;

import cn.tedu.tsms.classes.entity.ClassEntity;
import cn.tedu.tsms.common.web.PageObject;
import cn.tedu.tsms.student.entity.Student;

public interface StudentService {
	/**
	 * 
	 * @param student学生类
	 * @param className班级名
	 * @param empStatus就业状态
	 * @return 查询出的学生
	 */
	Map<String,Object> findAllStudents(Student student,String empStatus,PageObject pageObject);
	/**
	 * 
	 * @param student student学生类
	 * @param className className班级名
	 * @param empStatus empStatus就业状态
	 * @return 查询出的学生人数
	 */
	int getRowCount(Student student,String empStatus);
	
	List<ClassEntity> findAllClasses();
}
