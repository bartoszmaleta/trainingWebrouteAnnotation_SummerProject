package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Map;

public class HttpRequestHandler {
    final Map<String, Method> handlerMethods;

    public HttpRequestHandler(Map<String, Method> handlerMethods) {
        this.handlerMethods = handlerMethods;
    }

    /**
     * Invokes proper method handling proper endpoint and sends HTTP Response back.
     * @param httpExchange Encapsulated HTTP request.
     */
    public void handle(HttpExchange httpExchange) {
        // TODO
        sendResponse(httpExchange, 500, "Not Implemented");
    }

    private void sendResponse(HttpExchange httpExchange, int httpStatusCode, String message) {
        // TODO
    }

}
