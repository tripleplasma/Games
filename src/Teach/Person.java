package Teach;

import java.util.Arrays;

public class Person {

    String hairColor;
    String eyeColor;
    String name;
    int age;
    int height;
    int grade;

    public Person(String name, int age, String hairColor){
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
        grade = age-5;
    }

    public boolean isOlder(Person p){
        if(age > p.age) return true;
        return false;
    }

    public String info(){
        return name+" is "+age;
    }

}
