package com.yu.dubbo.service;

import java.util.List;

import com.yu.dubbo.entity.Student;

public interface StudentService {
	public Student getStudent(String id);
	
	public String insertStudents(List<String> ids);
}
