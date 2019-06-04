/***
 * 深入理解SpringAOP的思想，小型Spring框架
 */


package com.AOP.qq;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    void info();

    void fly();
}
//被代理类
class SuperMan implements Human{

    @Override
    public void info() {
        System.out.println("我是超人，我怕谁");
    }

    @Override
    public void fly() {
        System.out.println("I believe I can fly!!!");
    }
}
//切面日志方法类
class HumanUtil{
    public void method1(){
        System.out.println("==========method1==========");
    }
    public void method2(){
        System.out.println("==============method2==============");
    }
}
//代理类
class MyInvocationHandler implements InvocationHandler{
    Object obj;
    public void setObject(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil h=new HumanUtil();
        h.method1();//代理类中的方法中加入切面方法
        Object returnVal=method.invoke(obj,args);
        h.method2();//代理类中的方法中加入切面方法
        return returnVal;
    }
}

//动态创建一个代理类的对象
class MyProxy{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.setObject(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

public class TestAOP {

    public static void main(String[] args) {
        SuperMan man=new SuperMan();
        Object obj=MyProxy.getProxyInstance(man);
        Human human= (Human) obj;
        human.info();
        System.out.println();
        human.fly();
    }
}
