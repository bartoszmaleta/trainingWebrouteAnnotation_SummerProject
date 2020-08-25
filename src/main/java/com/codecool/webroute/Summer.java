package com.codecool.webroute;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Summer {
    final Map<String, Method> handlerMethods;

    private Field pathString;

    public Summer() {
        handlerMethods = new HashMap<>();
    }

    /**
     * Accepts any number of handlers and extracts all methods annotated with {@link WebRoute}.
     *
     * @param handlerClasses classes with methods annotated with {@link WebRoute}.
     */
    public void registerHandlers(Class<?>... handlerClasses) {
        try {
            for (Class<?> singleClass : handlerClasses) {
                for (Method method : singleClass.getMethods()) {
                    if (method.isAnnotationPresent(WebRoute.class)) {
                        WebRoute annotation = method.getAnnotation(WebRoute.class);
                        this.handlerMethods.put(annotation.path(), method);
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts HTTP server, waits for HTTP requests and redirects them to one of registered handler methods.
     */
    public void run() {
        // TODO
    }
}
