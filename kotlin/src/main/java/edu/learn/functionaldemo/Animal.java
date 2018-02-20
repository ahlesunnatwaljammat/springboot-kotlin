package edu.learn.functionaldemo;

@FunctionalInterface
public interface Animal {
    String walk();
    String toString();
    boolean equals(Object o);

    default void doSomeWork(){
        System.out.println("Doing some work in interface impl...");
    }
}