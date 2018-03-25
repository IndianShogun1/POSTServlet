package org.shreyansh.osgiDemo.services;

import java.util.List;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(ocd = ClassConfiguration.class)
@Component(service = SomeService.class, immediate = true)
public class ClassConfigurationService implements SomeService{

	private ClassConfiguration config;
	
	private int noOfStudents;
	
	private int passingMarks;
	
	@Activate
	public void activate(ClassConfiguration configuration) {
//		System.out.println("Calling Activate Method from Class");
		this.config = configuration;
		this.noOfStudents = config.no_of_students();
		this.passingMarks = config.passing_marks();
//		System.out.println("No of students = " + noOfStudents + " passing marks = " + passingMarks);
	}

	@Override
	public boolean isClassLimitReached(List list) {
		
		if(list.size() >= noOfStudents) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getPassingMarks() {
		
		return passingMarks;
	}
	
	
}
