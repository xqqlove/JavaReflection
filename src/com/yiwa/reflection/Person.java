package com.yiwa.reflection;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 15:42
 * @Version 1.0
 */
public class Person {
    public static int tall;
    private String name;
    private String age;
    public int number;
    public int sex;

    public Person() {
    }

    public Person(String name, String age, int number, int sex) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.sex = sex;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(int i){
        System.out.println("公有方法show："+i);
    }
    private void show(int j,int i){
        System.out.println("私有方法show："+j+" "+i);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", number=" + number +
                ", sex=" + sex +
                '}';
    }
}
