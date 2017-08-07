package cn.tedu.tsms.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.tsms.classes.entity.ClassEntity;
import cn.tedu.tsms.common.web.PageObject;
import cn.tedu.tsms.student.entity.Student;

public interface StudentDao {
	
	/**
	 * 查找班级
	 * @return
	 */
	List<ClassEntity> findAllClasses();
	/**
	 * 
	 * @param student学生类
	 * @param className班级名
	 * @param empStatus就业状态
	 * @return 查询出的学生
	 */
	List<Student> findAllStudents(@Param("student")Student student,@Param("empStatus")String empStatus,@Param("pageObject")PageObject pageObject);
	/**
	 * 
	 * @param student student学生类
	 * @param className className班级名
	 * @param empStatus empStatus就业状态
	 * @return 查询出的学生人数
	 */
	int getRowCount(@Param("student")Student student,@Param("empStatus")String empStatus);
	/**
	 * 修改模块
	 * 根据学员ID返回学员信息
	 * @param id 学员ID
	 */
	Student selectStudentMessageById(String id);
	/**
	 * 修改模块
	 * 根据班级ID查询班级名称
	 * @param classId 班级ID
	 */
	String selectClassNameById(String classId);
}
