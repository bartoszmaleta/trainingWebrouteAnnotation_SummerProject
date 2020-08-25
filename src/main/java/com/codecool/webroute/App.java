package com.codecool.webroute;

public class App {

    public static void main(String[] args) {
        Summer summer = new Summer();
        summer.registerHandlers(ExampleHandler.class);
        summer.run();
    }
}
