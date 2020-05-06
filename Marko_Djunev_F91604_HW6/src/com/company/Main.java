package com.company;

public class Main {

    public static void main(String[] args) {
        var text = "OOP";
        var headline = "Definition of OOP Concepts in Java " +
                "(https://stackify.com/oops-concepts-in-java/)";
        var content = "OOP concepts in Java are the main ideas behind Java’s Object Oriented " +
                "Programming. They are an abstraction, encapsulation, inheritance, and polymorphism. " +
                "Grasping them is key to understanding how Java works. Basically, Java OOP concepts let " +
                "us create working methods and variables, then reuse all or part of them without " +
                "compromising security.";
        var post1 = new Post(headline, content);

        var isTextAvailable = post1.isTextInHeadline(text);

        System.out.println("Is the text " + text + " in the headline? " + post1.isTextInHeadline(text));
        System.out.println("The text " + text + " is used "+ post1.isTextInContext(text) + " times in the context!");

        var blog = new Blog();
        blog.addPost(post1);

        headline = "What is object oriented programming (OOP)? " +
                "(https://www.nextacademy.com/blog/object-oriented-programming-oop/)";
        content = "Object Oriented Programming (OOP) is the foundation of mastering most of the " +
                "widely used programming languages such as Java, Python, Ruby and, of course, Swift. It " +
                "helps you in the process of designing your app because an app without any proper " +
                "planning will make you go crazy (trust me, been there, done that).";
        var post2 = new Post(headline, content);

        System.out.println("Is the text " + text + " in the headline? " + post2.isTextInHeadline(text));
        System.out.println("The text " + text + " is used "+ post2.isTextInContext(text) + " times in the context!");

        blog.addPost(post2);
        blog.isTextContainedInPostsContext("OOP");
        blog.isTextContainedInPostsContext("mastering");

        System.out.println(blog.toString());
    }
}
