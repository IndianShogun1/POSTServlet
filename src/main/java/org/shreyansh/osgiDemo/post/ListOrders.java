package org.shreyansh.osgiDemo.post;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.shreyansh.osgiDemo.htl.SomeService;

import javax.script.Bindings;
import java.util.List;

public class ListOrders implements Use{

    List<Resource> children = null;

    @Override
    public void init(Bindings bindings) {
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        SomeService someService = slingScriptHelper.getService(SomeService.class);
        children = someService.listChildren("/content/pending-orders");
    }

    public List<Resource> getChildren() {
        return children;
    }
}


