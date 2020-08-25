package com.codecool.webroute.helpersAndTests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class GFG {

    // initialize field with
    // default value in annotation
    @annotations(value = 3125462345.32155365326, path = "qwe")

    private double realNumbers;

    public static void main(String[] args)
            throws NoSuchFieldException {

        // create Field object
        Field field = GFG.class.getDeclaredField("realNumbers");

        // apply getAnnotation()
        annotations annotations = field.getAnnotation(annotations.class);

        // print results
        System.out.println(annotations.path());

//        this.getClass().getDeclaredField("")
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    private @interface annotations {
        double value() default 99.9;
        String path();
    }
}