package com.yu.dubbo.service.impl;

import java.util.List;

import com.yu.dubbo.entity.Student;
import com.yu.dubbo.service.StudentService;

public class StudentServiceImpl implements StudentService{

	public StudentServiceImpl(){
		System.out.println("fdfds");
	}
	
	@Override
	public Student getStudent(String id) {
		Student student = new Student();
		student.setId("xxx");
		student.setName("student");
		return student;
	}

	@Override
	public String insertStudents(List<String> ids) {
		System.out.println(ids);
		return "xxx";
	}

}
