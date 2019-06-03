
package com.javaReflection.qq;

import org.junit.Test;

import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestConstructor {

    @Test
    public void test() throws Exception{
        String className="com.javaReflection.qq.Person";
        Class clazz=Class.forName(className);
        //创建对应的运行时类对象

        Object obj=clazz.newInstance();
        Person p= (Person) obj;
        System.out.println(p);

    ///获取运行时类的构造器
        Constructor[] constructors=clazz.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c);

        }
    }


    @Test
    public void test1(){
        Class clazz=Person.class;
        //1.getFileds()能获取运行时类及父类中声明的所有public属性
        Field[] fields=clazz.getFields();
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i]);
        }
        //获取运行时类本身所有的属性
        Field[] fields1=clazz.getDeclaredFields();
        for(Field f:fields1){
            System.out.println(f);
        }
    }

    @Test
    public void test2(){
       Class clazz=Person.class;

        Field[] fields=clazz.getDeclaredFields();

        for(Field f:fields){
        //1.获取每个属性的权限修饰符
            System.out.println(Modifier.toString(f.getModifiers()));
         //2.获取属性变量类型
            System.out.println(f.getType().getName());
         //3.获取属性名
            System.out.println(f.getName());

        }
        Method[] methods=clazz.getMethods();
        Method[] methods1=clazz.getDeclaredMethods();
        //4获取方法
        for(Method m:methods){
            System.out.println(m);
        }
        for(Method m:methods1){
            System.out.println("==================================");
            System.out.println(m);
            System.out.println(m.getName());

        }

    }



    //调用运行时类中指定的属性
    @Test
    public void test6() throws Exception{
        Class clazz=Person.class;
        //获取指定的属性
        Field name=clazz.getField("name");
        System.out.println(name);
        //创建运行时类的对象
        Person person= (Person) clazz.newInstance();
        System.out.println(person);
        name.set(person,"qiangqiang");
        System.out.println(person);


        Method method=clazz.getMethod("show");
        Person p= (Person) clazz.newInstance();
        method.invoke(p);

        Method method1=clazz.getMethod("toString");
        System.out.println(method1.invoke(person));


        Method method2=clazz.getMethod("info");
        method2.invoke(Person.class);

        Method method3=clazz.getDeclaredMethod("display", String.class);
        method3.setAccessible(true);
        method3.invoke(p,"韩国");

        Constructor constructor=clazz.getDeclaredConstructor(String.class,String.class);
        Person pp= (Person) constructor.newInstance("你大爷","wodaye ");
        System.out.println(pp);
    }

}
