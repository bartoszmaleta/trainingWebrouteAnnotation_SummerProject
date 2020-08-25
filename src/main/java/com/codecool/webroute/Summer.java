package com.codecool.webroute;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Summer {
    final Map<String, Method> handlerMethods;

    private String pathString;

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
                Field field = singleClass.getDeclaredField("pathString");
                for (Method method : singleClass.getMethods()) {
                    if (method.isAnnotationPresent(webRoute.class)) {
                        webRoute annotations = field.getAnnotation(webRoute.class);
                        this.handlerMethods.put(annotations.path(), method);
                    }
                }
            }
        } catch (SecurityException | NoSuchFieldException e) {
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
