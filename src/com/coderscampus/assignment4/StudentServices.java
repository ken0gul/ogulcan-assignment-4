package com.coderscampus.assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentServices {
	
	private List<Student> compSciStudents;
	private List<Student> statStudents;
	private List<Student> apmthStudents;
	public StudentServices() {
		super();
		this.compSciStudents = new ArrayList<Student>();
		this.statStudents = new ArrayList<Student>();
		this.apmthStudents = new ArrayList<Student>();
	}
	
	
	public void parseCSV(String courseName, String currentLine, List<Student> studentArray) {
		if (currentLine.contains(courseName)) {
			int id = Integer.parseInt(currentLine.split(",")[0]);
			String name = currentLine.split(",")[1];
			String course = currentLine.split(",")[2];
			int grade = Integer.parseInt(currentLine.split(",")[3]);
			studentArray.add(new Student(id, name, course, grade));
			Collections.sort(studentArray, new Student(id, name, course, grade));
		}
	}
	
	
	public void writeFiles(List<Student> students,String fileName) throws IOException {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write("Student ID,Student Name,Course,Grade \n");

			for (int i = 0; i < students.size(); i++) {
				writer.write(getOutput(students.get(i)));
			}
		}
	}
	
	
	// Return the desired output when this method is called

	public static String getOutput(Student student) throws IOException {

		String output = student.getStudentId() + "," + student.getStudentName() + "," + student.getCourseName() + ","
				+ student.getGrade() + "\n";
		return output;
	}


	public List<Student> getCompSciStudents() {
		return compSciStudents;
	}


	public List<Student> getStatStudents() {
		return statStudents;
	}


	public List<Student> getApmthStudents() {
		return apmthStudents;
	}
	
	
	
}
