package com.coderscampus.assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
	
	private List<Student> compSciStudents;
	private List<Student> statStudents;
	private List<Student> apmthStudents;
	private FileService fileService;
	public StudentService() {
		super();
		this.compSciStudents = new ArrayList<Student>();
		this.statStudents = new ArrayList<Student>();
		this.apmthStudents = new ArrayList<Student>();
		this.fileService = new FileService();
	}
	
	
	public void loadStudents(String filename) {
		List<Student> allStudents = fileService.readStudentsFromFile(filename);
		
		// sort students once
		Collections.sort(allStudents, new Student());
		
		
		for(int i = 0; i < allStudents.size(); i++) {
			if(allStudents.get(i).getCourseName().contains("COMPSCI")) {
				this.compSciStudents.add(allStudents.get(i));
			} else if(allStudents.get(i).getCourseName().contains("STAT")) {
				this.statStudents.add(allStudents.get(i));
			} else if(allStudents.get(i).getCourseName().contains("APMTH")) {
				this.apmthStudents.add(allStudents.get(i));
			}
		}
	}
	
	
	
	public void saveStudentsToFile(List<Student> students,String fileName) throws IOException {
		try {
			this.fileService.writeFiles(students, fileName);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
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
