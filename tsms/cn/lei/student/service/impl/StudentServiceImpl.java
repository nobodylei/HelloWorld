package cn.tedu.tsms.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.tsms.classes.entity.ClassEntity;
import cn.tedu.tsms.common.web.PageObject;
import cn.tedu.tsms.student.dao.StudentDao;
import cn.tedu.tsms.student.entity.Student;
import cn.tedu.tsms.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;

	@Override
	public Map<String,Object> findAllStudents(Student student, String empStatus,PageObject pageObject) {

		List<Student> list = studentDao.findAllStudents(student, empStatus,pageObject);

		int num = studentDao.getRowCount(student, empStatus);
		pageObject.setRowCount(num);
		
		Map<String,Object> map = new HashMap<String,Object>();

		map.put("list",list);
		map.put("pageObject",pageObject);
		return map;
	}

	@Override
	public int getRowCount(Student student,String empStatus) {

		return studentDao.getRowCount(student, empStatus);
	}
	

	@Override
	public List<ClassEntity> findAllClasses() {
		return studentDao.findAllClasses();
	}

}
