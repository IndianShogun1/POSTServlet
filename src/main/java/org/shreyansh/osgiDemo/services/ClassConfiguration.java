package org.shreyansh.osgiDemo.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Class Configuration", description= "Class Configuration")
public @interface ClassConfiguration {
	@AttributeDefinition(name = "No of Students", description = "Number of students allowed in a class.",
			type = AttributeType.INTEGER)
	int no_of_students();
	
	@AttributeDefinition(name = "Passing Marks", description = "Marks required to pass the class.",
			type = AttributeType.INTEGER)
	int passing_marks();
	
}
