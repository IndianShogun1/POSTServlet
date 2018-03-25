package org.shreyansh.osgiDemo.services;

import java.util.ArrayList;
import org.apache.sling.scripting.sightly.pojo.Use;
import java.util.Iterator;
import java.util.List;

import javax.script.Bindings;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
//import org.shreyansh.osgiDemo.services.ClassConfigurationService.ClassConfiguration;

@Component(service = SomeOtherService.class, immediate = true)
public class StudentClassService implements SomeOtherService {

	List<Student> students;
	
	@Reference
	SomeService someService;
	
	@Activate
	public void activate(ClassConfiguration configuration) {
//		System.out.println("Calling Activate Method from Student");
		students = new ArrayList<>();
		Student student1 = new Student(1, "student1", 65, 15);
		Student student2 = new Student(2, "student2", 30, 14);
//		Student student3 = new Student(3, "student3", 80, 16);
//		Student student4 = new Student(4, "student4", 25, 15);
//		Student student5 = new Student(5, "student5", 75, 17);
		this.addStudent(student1);
		this.addStudent(student2);
//		this.addStudent(student3);
//		this.addStudent(student4);
//		this.addStudent(student5);
		System.out.println(this.isStudentPassed(1));
		if(this.students != null) {
			System.out.println("not null");
		} else {
			System.out.println("null");
		}
//		System.out.println("In activate");
//		System.out.println(this.students.size());
//		this.getStudentList();
	}
	
	
	@Override
	public boolean addStudent(Student values) {
		if(someService.isClassLimitReached(students)) {
			System.out.println("List is full.");
			return false;
		} else {
			this.students.add(values);
			return true;
		}
	}

	@Override
	public void deleteStudent(int id) {
		
		for(int i = 0; i <= this.students.size(); i++) {
			Student student = this.students.get(i);
			if(student.getId() == id) {
				students.remove(i);
				break;
			}
		}
	}

	@Override
	public boolean isStudentPassed(int id) {
		
		Iterator it = this.students.iterator();
		boolean flag = false;
		while(it.hasNext()) {
			Student student = (Student) it.next();
			if(student.getId() == id) {
				if(student.getMarksObtained() >= someService.getPassingMarks()) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public Student getStudent(int id) {
		Iterator it = this.students.iterator();
		Student student = null;
		while(it.hasNext()) {
			student = (Student) it.next();
			if(student.getId() == id) {
				break;
			}
		}
		return student;
	}

	public List getStudentList() {
//		Iterator it = this.students.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		return students;
	}


	
}
