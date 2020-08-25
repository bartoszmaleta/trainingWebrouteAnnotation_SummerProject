package com.codecool.webroute;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {
        Summer summer = new Summer();
        summer.registerHandlers(ExampleHandler.class);
        summer.run();
    }
}
