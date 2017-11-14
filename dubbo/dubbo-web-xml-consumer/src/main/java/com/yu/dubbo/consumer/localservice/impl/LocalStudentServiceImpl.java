package com.yu.dubbo.consumer.localservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yu.dubbo.consumer.localservice.LocalStudentService;
import com.yu.dubbo.entity.Student;
import com.yu.dubbo.service.StudentService;

@Service
public class LocalStudentServiceImpl implements LocalStudentService{
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public Student getStudent(String id) {
		return studentService.getStudent(id);
	}
}
