package com.yu.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yu.dubbo.entity.Student;
import com.yu.dubbo.service.StudentService;

@Service
@org.springframework.stereotype.Service
public class StudentServiceImpl implements StudentService{

	@Override
	public Student getStudent(String id) {
		Student student = new Student();
		student.setId("xxx");
		student.setName("student");
		return student;
	}

}
