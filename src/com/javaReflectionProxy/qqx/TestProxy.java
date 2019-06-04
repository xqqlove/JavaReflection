package com.javaReflectionProxy.qqx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Proxy;

//静态代理
interface Flyable{
    void fly();
}

class Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("bird is flying.....");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//通过继承来计算飞行时间，如果需要在计算时间前后打印日志，那么将导致继承的无限延展。
class Bird2 extends Bird{
    @Override
    public  void fly(){
        long start=System.currentTimeMillis();
        super.fly();
        long end=System.currentTimeMillis();
        System.out.println("Fly time="+(end-start));
    }
}

//使用静态代理,代理方法运行时间
class BirdTimeProxy implements Flyable{
 private Flyable flyable;

 public BirdTimeProxy(Flyable flyable){
     this.flyable=flyable;
 }
    @Override
    public void fly() {
        long start=System.currentTimeMillis();
        flyable.fly();
        long end=System.currentTimeMillis();
        System.out.println("Fly time="+(end-start));
    }
}
//使用静态代理，实现方法运行日志打印
class  BirdLogProxy implements Flyable{
    private Flyable flyable;
    public BirdLogProxy(Flyable flyable){
        this.flyable=flyable;
    }
    @Override
    public void fly() {
        System.out.println("flying start....");
        flyable.fly();
        System.out.println("flying end.....");
    }
}

/**
 * 如果接口中有大量的方法都得计算运行时间和打印日志，那么会出现大量重复的代码，静态代理的局限性可见一斑
 *    --如果同时代理多个类，导致类无限延展
 *    --如果类中存在大量方法，同样逻辑需要反复实现
 */


//动态代理
//class BirdProxy implements InvocationHandler{
//      Object obj;
//
//    public Object getBirdProxy(Object obj){
//        this.obj=obj;
//        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.get)
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("---------------begin----------------");
//        Object invoke=method.invoke(obj,args);
//        System.out.println("----------------end---------------------");
//        return null;
//
//    }
//}

public class TestProxy {
    public static void main(String[] args) {
        //使用继承
        Bird2 bird2=new Bird2();
        bird2.fly();
        System.out.println("=========================================================");

        //使用静态代理
        Bird bird=new Bird();
        BirdTimeProxy birdTimeProxy=new BirdTimeProxy(bird);
        BirdLogProxy birdLogProxy=new BirdLogProxy(bird);
        birdTimeProxy.fly();
        System.out.println("*****************************************************************");
        birdLogProxy.fly();

        //动态代理
//        System.out.println("============================动态代理===============================");
//        Bird bird1=new Bird();
////        InvocationHandler birdProxy=new BirdProxy(bird1);
//        Flyable proxyInstance= (Flyable) java.lang.reflect.Proxy.newProxyInstance(birdProxy.getClass().getClassLoader(),birdProxy.getClass().getInterfaces(),birdProxy);
//        proxyInstance.fly();

    }
}
