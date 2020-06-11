package com.yiwa.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 14:58
 * @Version 1.0
 */
public class TestReflection {
    public static void main(String[] args) throws Exception{
//        Class<?> person = Class.forName("com.yiwa.reflection.Person");
//        Class<?> person=Person.class;
//        Person o = (Person) person.newInstance();
//        o.setAge("9");
//        o.setName("qiangqiang");
//        System.out.println(o);
//        Constructor<?> constructor = person.getConstructor();
//        System.out.println(constructor);
////        Constructor<?>[] constructors = person.getConstructors();
//        Constructor<?>[] constructors = person.getDeclaredConstructors();
//        for (Constructor c:constructors){
//            System.out.println(c);
//        }
//        Constructor<?> declaredConstructor = person.getDeclaredConstructor(String.class);
//        declaredConstructor.setAccessible(true);
//        Object qiangqiangqiang = declaredConstructor.newInstance("qiangqiangqiang");
//        System.out.println(qiangqiangqiang);


//        Class<?> person = Class.forName("com.yiwa.reflection.Person");
//        Field[] fields = person.getFields();
//        for (Field f:fields){
//            System.out.println(f);
//        }
//        Field[] declaredFields = person.getDeclaredFields();
//        for (Field f:declaredFields){
//            System.out.println(f);
//        }
//        Object o = person.getConstructor().newInstance();
//        Field f=person.getDeclaredField("name");
//        f.setAccessible(true);
//        f.set(o,"qiqi");
//        Person p= (Person) o;
//        System.out.println(p.tall);


        Class<?> person = Class.forName("com.yiwa.reflection.Person");
        Method[] declaredMethods = person.getDeclaredMethods();
        for (Method m:declaredMethods){
            System.out.println(m);
        }
        Method show = person.getDeclaredMethod("show", int.class, int.class);
        System.out.println(show);
        System.out.println("===================================");
        Object o = person.getConstructor().newInstance();
        show.setAccessible(true);
        show.invoke(o,1,2);
    }
}
