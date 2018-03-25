package org.shreyansh.osgiDemo.htl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.osgi.service.component.annotations.Reference;


import javax.script.Bindings;
import java.util.Iterator;
import java.util.List;

public class ListChildren  implements Use{

    List<Resource> children = null;

    String path;

    @Override
    public void init(Bindings bindings) {
        SlingHttpServletRequest request = (SlingHttpServletRequest) bindings.get("request");
        path = request.getParameter("path");
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        SomeService someService = slingScriptHelper.getService(SomeService.class);
        children = someService.listChildren(path);
    }

    public List<Resource> getChildren() {
        return children;
    }
}
