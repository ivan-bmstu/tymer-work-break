package com.ivan.res;

import java.net.URI;
import java.net.URISyntaxException;

public class ResourcesHandler {
    public URI getURIFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URI resource;
        try {
            resource = classLoader.getResource(fileName).toURI();
        } catch (NullPointerException nullException){
            nullException.printStackTrace();
            throw new IllegalArgumentException("file not found! " + fileName);
        }
            return resource;
    }
}
