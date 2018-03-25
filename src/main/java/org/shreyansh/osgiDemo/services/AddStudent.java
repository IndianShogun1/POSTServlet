package org.shreyansh.osgiDemo.services;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.ArrayList;
import java.util.List;

public class AddStudent implements Use{

    SomeOtherService someOtherService;
    SlingHttpServletRequest request = null;
    List<String> students = null;
    boolean message = false;
    int id;
    String name;
    int age;
    int marks;

    @Override
    public void init(Bindings bindings) {
        request = (SlingHttpServletRequest) bindings.get("request");
        id = Integer.valueOf(request.getParameter("id"));
        name = request.getParameter("name");
        age = Integer.valueOf(request.getParameter("age"));
        marks = Integer.valueOf(request.getParameter("marks"));
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        someOtherService = slingScriptHelper.getService(SomeOtherService.class);
    }

    public List<String> getStudents() {
        Student student = new Student(id, name, marks, age);
        message = someOtherService.addStudent(student);


        List<Student> it = new ArrayList<>();
        it = someOtherService.getStudentList();
        students = new ArrayList<>();

        if(message == false) {
            students.add("Class is full");
            return students;
        }
        for (Student i: it) {
            System.out.println(i);
            String s = i.getName();
            System.out.println(s);
            students.add(i.toString());
        }
        System.out.println("After loop");
        return students;
    }
}
