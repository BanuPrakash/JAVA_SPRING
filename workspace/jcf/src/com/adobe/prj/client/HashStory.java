package com.adobe.prj.client;

public class HashStory {
    public static void main(String[] args) {
        String s1 = new String("Aa");
        String s2 = new String("BB");

        String s3 = new String("Hello");
        String s4 = new String("Hello");

        //If two objects are equal according to the equals() method,
        // their hashCode() values must be equal.
        System.out.println(s3.hashCode()); // 69609650
        System.out.println(s4.hashCode()); // 69609650
        System.out.println(s3.equals(s4)); // true

        //unequal objects can have the same hash code (a collision)
        System.out.println(s1.hashCode()); // 2112
        System.out.println(s2.hashCode()); // 2112
        System.out.println(s1.equals(s2)); // false
    }
}
