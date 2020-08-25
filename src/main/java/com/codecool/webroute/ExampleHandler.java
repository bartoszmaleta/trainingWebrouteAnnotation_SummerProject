package com.codecool.webroute;

public class ExampleHandler {

    public static String getHello() {
        return "Hello World!";
    }

    public static String getLoremIpsum() {
        return "<h1>What is Lorem Ipsum?</h1></br>" +
               "<p><i>Lorem Ipsum</i> is simply dummy text of the printing and typesetting industry.</p>" +
               "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged." +
               "</br>It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    }

    public static String methodThatShouldNotBeAnValidEndpoint() {
        return "Imagine that this is just a helper method :)";
    }
}
