package com.codecool.webroute;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Summer {
    final Map<String, Method> handlerMethods;

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
            System.out.println("value for key lorem = " + this.handlerMethods.get("/lorem"));
//                    System.out.println(this.handlerMethods.toString());
            System.out.println("\nkeySet = " + this.handlerMethods.keySet());
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts HTTP server, waits for HTTP requests and redirects them to one of registered handler methods.
     */
    public void run() throws IOException {

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpRequestHandler httpRequestHandler = new HttpRequestHandler(this.handlerMethods);

        httpServer.createContext("/", httpRequestHandler);
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("Server has started on port " + httpServer.getAddress().getPort());

    }
}
