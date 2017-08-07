package cn.tedu.tsms.student.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.tsms.classes.entity.ClassEntity;
import cn.tedu.tsms.common.web.PageObject;
import cn.tedu.tsms.student.entity.ClassChange;
import cn.tedu.tsms.student.entity.Student;
import cn.tedu.tsms.student.service.StudentService;

@Controller
@RequestMapping("/student/")
public class StudentController {

	@Resource
	private StudentService studentService;

	@RequestMapping("studentList")
	public String studentsList(){
		return "student/students";
	}

	/*
	@RequestMapping("/toChangeClass")
	public String toChangeClass(){
		System.out.println("1464");
		return "student/change";
	}
	@RequestMapping("/toChangeVIP")
	public String toChangeVIP(){
		System.out.println(1644);
		return "student/vip";
	}
	@RequestMapping("/toListChange")
	public String toListChange(Model model){
		System.out.println(16);
		List<ClassChange> list= studentService.showChangeList();
		model.addAttribute("list",list);
		return "student/listchange";
	}
  */

	@RequestMapping("findAllClasses")
	@ResponseBody
	public List<ClassEntity> findAllClasses() {
		return studentService.findAllClasses();
	}

	@RequestMapping("findAllStudents")
	@ResponseBody
	public Map<String,Object> findAllStudents(Student student,String empStatus,PageObject pageObject){
		return studentService.findAllStudents(student,empStatus,pageObject);
	}
}
