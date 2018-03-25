package org.shreyansh.osgiDemo.htl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UseImpl implements Use {

    Iterator<Resource> children;

    Map<String,Integer> map;

    @Override
    public void init(Bindings bindings) {

        Resource resource = (Resource) bindings.get("resource");

        children = resource.listChildren();

    }

    public Iterator<Resource> getChildren() {
        return children;
    }

    public Map<String, Integer> getMap() {
        map = new HashMap<>();
        map.put("key1",1);
        map.put("key2",2);
        map.put("key3",3);
        return map;
    }
}
