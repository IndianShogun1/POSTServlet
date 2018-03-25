package org.shreyansh.osgiDemo.htl;

import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;

import java.util.Iterator;
import java.util.List;

public interface SomeService {
//    public Iterator<Resource> listChildren(String path);
        public List<Resource> listChildren(String path);

}

