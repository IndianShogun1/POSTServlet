package org.shreyansh.osgiDemo.services;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.ArrayList;
import java.util.List;

public class StudentStatus implements Use{

    SomeOtherService someOtherService;
    SlingHttpServletRequest request = null;
    String message = null;
    int id;

    @Override
    public void init(Bindings bindings) {
        request = (SlingHttpServletRequest) bindings.get("request");
        id = Integer.valueOf(request.getParameter("id"));
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        someOtherService = slingScriptHelper.getService(SomeOtherService.class);
    }

    public String getMessage() {
        if(someOtherService.isStudentPassed(id)) {
            message = "Student is passed.";
        } else {
            message = "Student is not passed";
        }
        return message;
    }

}
