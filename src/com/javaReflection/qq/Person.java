package com.javaReflection.qq;

public class Person extends Object {
    public String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public Person(){
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我是一个人！！！");
    }
    public void display(String nation){
        System.out.println("我的国籍是："+nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
