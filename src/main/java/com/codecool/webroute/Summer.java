package com.codecool.webroute;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Summer {
    final Map<String, Method> handlerMethods;

    public Summer() {
        handlerMethods = new HashMap<>();
    }

    /**
     * Accepts any number of handlers and extracts all methods annotated with {@link WebRoute}.
     * @param handlerClasses classes with methods annotated with {@link WebRoute}.
     */
    public void registerHandlers(Class<?>... handlerClasses) {
        // TODO
    }

    /**
     * Starts HTTP server, waits for HTTP requests and redirects them to one of registered handler methods.
     */
    public void run() {
        // TODO
    }
}
