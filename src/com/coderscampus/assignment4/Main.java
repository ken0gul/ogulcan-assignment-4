package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("student-master-list.csv"));

		String currentLine = null;
		Student student = null;

		List<Student> compSciStudents = new ArrayList<Student>();
		List<Student> statStudents = new ArrayList<Student>();
		List<Student> apmthStudents = new ArrayList<Student>();

		String studentGrade = null;
		String studentGrade2 = null;

		int i = 0;
		int j = 0;
		int k = 0;

		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.contains("COMPSCI")) {
				int id = Integer.parseInt(currentLine.split(",")[0]);
				String name = currentLine.split(",")[1];
				String course = currentLine.split(",")[2];
				int grade = Integer.parseInt(currentLine.split(",")[3]);
				compSciStudents.add(new Student(id, name, course, grade));
				Collections.sort(compSciStudents, new Student(id, name, course, grade));
				i++;

			}

			if (currentLine.contains("STAT")) {
				int id = Integer.parseInt(currentLine.split(",")[0]);
				String name = currentLine.split(",")[1];
				String course = currentLine.split(",")[2];
				int grade = Integer.parseInt(currentLine.split(",")[3]);
				statStudents.add(new Student(id, name, course, grade));
				Collections.sort(statStudents, new Student(id, name, course, grade));
				j++;
			}

			if (currentLine.contains("APMTH")) {
				int id = Integer.parseInt(currentLine.split(",")[0]);
				String name = currentLine.split(",")[1];
				String course = currentLine.split(",")[2];
				int grade = Integer.parseInt(currentLine.split(",")[3]);
				apmthStudents.add(new Student(id,name,course,grade));
				Collections.sort(apmthStudents, new Student(id,name,course,grade));
				k++;
			}
		}

		for (Student item : compSciStudents) {
			System.out.println(item);

		}

		for(Student item : statStudents) {
			System.out.println(item);
		}
		for(Student item : apmthStudents) {
			System.out.println(item);
		}

	}

}
