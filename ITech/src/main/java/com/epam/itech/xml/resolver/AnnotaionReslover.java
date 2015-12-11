package com.epam.itech.xml.resolver;

import java.lang.annotation.Annotation;

public class AnnotaionReslover {

    public Class<?> resolve(String elementName, Class<?> classToResolve) {
        for(Annotation a : classToResolve.getAnnotations()) {

        }
        return null;
    }

}
