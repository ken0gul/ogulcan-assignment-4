package com.coderscampus.assignment4;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader("student-master-list.csv"))) {
			String currentLine = null;

			List<Student> compSciStudents = new ArrayList<Student>();
			List<Student> statStudents = new ArrayList<Student>();
			List<Student> apmthStudents = new ArrayList<Student>();

		
		
			
			// Seperate CSV Data into different arrayLists
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.contains("COMPSCI")) {
					int id = Integer.parseInt(currentLine.split(",")[0]);
					String name = currentLine.split(",")[1];
					String course = currentLine.split(",")[2];
					int grade = Integer.parseInt(currentLine.split(",")[3]);
					compSciStudents.add(new Student(id, name, course, grade));
					Collections.sort(compSciStudents, new Student(id, name, course, grade));

				}

				if (currentLine.contains("STAT")) {
					int id = Integer.parseInt(currentLine.split(",")[0]);
					String name = currentLine.split(",")[1];
					String course = currentLine.split(",")[2];
					int grade = Integer.parseInt(currentLine.split(",")[3]);
					statStudents.add(new Student(id, name, course, grade));
					Collections.sort(statStudents, new Student(id, name, course, grade));
				}

				if (currentLine.contains("APMTH")) {
					int id = Integer.parseInt(currentLine.split(",")[0]);
					String name = currentLine.split(",")[1];
					String course = currentLine.split(",")[2];
					int grade = Integer.parseInt(currentLine.split(",")[3]);
					apmthStudents.add(new Student(id, name, course, grade));
					Collections.sort(apmthStudents, new Student(id, name, course, grade));
				}
			}
			
			
			// Create FileWriter for each ArrayList
			// We create fileWriter before the loop becuase otherwise it overwrite FileWriter in every iteration

			try (FileWriter writer = new FileWriter("course1.csv")) {
				writer.write("Student ID,Student Name,Course,Grade \n");

				for (int i = 0; i < compSciStudents.size(); i++) {
					writer.write(getOutput(compSciStudents.get(i)));
				}
			}

			try (FileWriter writer = new FileWriter("course2.csv")) {
				writer.write("Student ID,Student Name,Course,Grade \n");
				for (int i = 0; i < statStudents.size(); i++) {
					writer.write(getOutput(statStudents.get(i)));
				}
			}

			try (FileWriter writer = new FileWriter("course3.csv")) {
				writer.write("Student ID,Student Name,Course,Grade \n");
				for (int i = 0; i < apmthStudents.size(); i++) {
					writer.write(getOutput(apmthStudents.get(i)));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
	
	
	// Return the desired output when this method is called

	public static String getOutput(Student student) throws IOException {

		String output = student.getStudentId() + "," + student.getStudentName() + "," + student.getCourseName() + ","
				+ student.getGrade() + "\n";
		return output;
	}

}
