package com.javaReflection.qq;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
    //如何获取Class的实例（3种）
    @Test
    public void test4(){

    }

    /**
     * java.lang.Class:是反射的源头   （每一个.class文件都是一个Class实例）
     * 我们创建了一个类，通过编译（javac.exe），生成对应的.class文件。之后我们使用java.exe加载（JVM的类加载器来完成的）次.class文件
     * 此.class文件加载到内存以后，就是一个运行时类，存放在缓存区。那么这个运行时类本身就是一个Class的实例！
     * 1.每一个运行时类只加载一次
     * 2.有了Class的实例以后，我们才可以进行如下操作：
     *    1）创建对应的运行时类对象
     *    2）获取对应的运行时类的完整结构（属性，方法，构造器，内部类，父类，所在的包，异常，注解。。。。）
     *    3）调用对应的运行时类指定的结构 （属性，方法，构造器）
     *    4）反射的引用，动态代理
     *
     */

    @Test
    public void test3(){
       Person p=new Person();
       Class clazz=p.getClass();//通过运行时类的对象，调用其getClass（），返回运行时类
        System.out.println(clazz);
    }





    //    有了反射可以通过反射创建一个类的对象，并调用其中的结构
    @Test
    public void test2() throws Exception {
        Class clazz=Person.class;//运行时编译后的.class文件充当了Class类的实例
//        1.创建clazz对应的运行时类Person类的对象
        Person person= (Person) clazz.newInstance();
        System.out.println(person);
//        2通过反射调用运行时类指定的属性
        Field f1=clazz.getField("name");
        f1.set(person,"LIUDEHUA");
        System.out.println(person);
        Field f2=clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(person,"20");
        System.out.println(person);
//        3.通过反射调用运行时类指定的方法
        Method m1=clazz.getMethod("show");
        m1.invoke(person);

        Method m2=clazz.getMethod("display", String.class);
        m2.invoke(person,"chiji");

    }
//    有反射以前，如何创建一个类的对象，碧昂调用其属性方法
    @Test
    public void test1(){
     Person p=new Person();
     p.setAge("10");
     p.setName("qiangqiang");
        System.out.println(p);
        p.show();
        p.display("china");
    }

}
