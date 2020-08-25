package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.Builder;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class HttpRequestHandler implements HttpHandler {
    final Map<String, Method> handlerMethods;

    public HttpRequestHandler(Map<String, Method> handlerMethods) {
        this.handlerMethods = handlerMethods;
    }

    /**
     * Invokes proper method handling proper endpoint and sends HTTP Response back.
     * @param httpExchange Encapsulated HTTP request.
     */
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        System.out.println("path = " + path);
        String[] pathElements = path.split("/");
        System.out.println(Arrays.toString(pathElements));
        int secondElementIndex = 1;
        String secondElement = pathElements[secondElementIndex];
        System.out.println("second element = " + secondElement);

        String message = "Wrong context";
        int statusCode = 418;

        System.out.println("keySet again = " + this.handlerMethods.keySet().toString());

        if (this.handlerMethods.get(path).getName().equals("")) {
            statusCode = 404;
        }

        Method method = this.handlerMethods.get(path);
        System.out.println("method name = " + method.getName());

        try {
//            String str = (String) method.invoke(new ExampleHandler());
            Object obj = method.invoke(new ExampleHandler());
            if (obj.getClass().equals(String.class)) {
                String str = (String) obj;
                System.out.println("str = " + str);
                message = str;
                statusCode = 200;
            } else {
                statusCode = 500;
                message = "Invalid method return type";
            }
        } catch (IllegalAccessException e) {
            statusCode = 500;
            message = "Method couldn't be invoked.";
            System.err.println("IAccessE");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("IArgumentE");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            statusCode = 500;
            message = "Exception thrown while executing method";
            System.err.println("ITE");
            e.printStackTrace();
        }

        System.out.println("message = " + message);

        sendResponse(httpExchange, statusCode, message);
    }

    private void sendResponse(HttpExchange httpExchange, int httpStatusCode, String message) throws IOException {
        System.out.println("status code = " + httpStatusCode);
        if (httpStatusCode == 200) {
            httpExchange.getResponseHeaders().put("Content-type", Collections.singletonList("application/json"));
            httpExchange.getResponseHeaders().put("Access-Control-Allow-Origin", Collections.singletonList("*"));
        }
        httpExchange.sendResponseHeaders(httpStatusCode, message.getBytes().length);
//        httpExchange.sendResponseHeaders(httpStatusCode, message.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(message.getBytes());
        os.close();
    }
}
