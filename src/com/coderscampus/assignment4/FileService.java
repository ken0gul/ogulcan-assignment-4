package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public List<Student> readStudentsFromFile(String filename){
		List<Student> studentArray = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String currentLine = null;
			reader.readLine(); // ignore the 1st line
			while((currentLine = reader.readLine()) != null) {
				int id = Integer.parseInt(currentLine.split(",")[0]);
				String name = currentLine.split(",")[1];
				String course = currentLine.split(",")[2];
				int grade = Integer.parseInt(currentLine.split(",")[3]);
				studentArray.add(new Student(id,name,course,grade));
			}
		}
			catch(IOException e) {
				e.printStackTrace();
			}
		
		return studentArray;
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
}
