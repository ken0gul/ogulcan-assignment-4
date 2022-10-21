package com.coderscampus.assignment4;

import java.util.Comparator;

public class Student implements Comparator<Student> {

	private int studentId;
	private String studentName;
	private String courseName;
	private int grade;
	
	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String courseName, int grade) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseName = courseName;
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getGrade() {
		return grade;
	}
	
	
	public static Student getStudent(int studentId, String studentName, String courseName, int grade) {
		return new Student(studentId, studentName, courseName, grade);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", courseName=" + courseName
				+ ", grade=" + grade + "]";
	}



	@Override
	public int compare(Student o1, Student o2) {
		// Descending order
		if(o1.grade == o2.grade) {
			return 0;
		} else if(o1.grade > o2.grade) {
			return -1;
		} else {
			return 1;
		}
	}
	
	
	
	
	
	
	
}
