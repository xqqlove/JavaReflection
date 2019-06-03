package com.javaReflection.qq;


public class Person extends Creature<String> implements Comparable,MyInstance {
    public String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public Person(){
        System.out.println("啦啦啦啦");
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
    private void display(String nation){
        System.out.println("我的国籍是："+nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void info(){
        System.out.println("中国人");
    }
}
