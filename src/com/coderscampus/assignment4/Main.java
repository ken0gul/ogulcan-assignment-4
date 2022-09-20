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
		StudentServices studentService = new StudentServices();
		try (BufferedReader reader = new BufferedReader(new FileReader("student-master-list.csv"))) {
			String currentLine = null;

			// Crate Lists for each class
			List<Student> compSciStudents = studentService.getCompSciStudents();
			List<Student> statStudents = studentService.getStatStudents();
			List<Student> apmThStudents = studentService.getApmthStudents();
			// Seperate CSV Data into different arrayLists
			while ((currentLine = reader.readLine()) != null) {
				studentService.parseCSV("COMPSCI", currentLine, compSciStudents);
				studentService.parseCSV("STAT", currentLine, statStudents);
				studentService.parseCSV("APMTH", currentLine, apmThStudents);

			}

			studentService.writeFiles(compSciStudents, "course1.csv");
			studentService.writeFiles(statStudents, "course2.csv");
			studentService.writeFiles(apmThStudents, "course3.csv");

		}

	}

}
