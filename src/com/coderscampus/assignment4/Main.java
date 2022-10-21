package com.coderscampus.assignment4;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		StudentService studentService = new StudentService();
		studentService.loadStudents("student-master-list.csv");

		studentService.saveStudentsToFile(studentService.getCompSciStudents(), "course1.csv");
		studentService.saveStudentsToFile(studentService.getStatStudents(), "course2.csv");
		studentService.saveStudentsToFile(studentService.getApmthStudents(), "course3.csv");

	}

}
