package com.codecool.webroute.helpersAndTests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class GFG2 {

    // initialize field with
    // default value in annotation
    @annotations(path = "qwe")
    private String text;

    public static void main(String[] args)
            throws NoSuchFieldException {

        // create Field object
        Field field = GFG.class.getDeclaredField("text");

        // apply getAnnotation()
        annotations annotations = field.getAnnotation(annotations.class);

        // print results
        System.out.println(annotations);

//        this.getClass().getDeclaredField("")
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    private @interface annotations {
        String path();
    }
}