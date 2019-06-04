package com.javaReflectionProxy.qq;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
interface Subject{
    void action();
}

//被代理类
class RealSubject implements Subject{
    @Override
    public void action() {
        System.out.println("我是被代理类！！！！");
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object object;//实现接口的被代理类的对象声明
    //1.给被代理类实例化
    //2.返回一个代理类对象
    public Object bind(Object obj){
        this.object=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    //
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal=method.invoke(object,args);
        return returnVal;
    }
}
public class TestProxy {
    public static void main(String[] args) {
//        1.被代理类的对象
         RealSubject real=new RealSubject();
//         2.创建一个实现IncocationHandler接口的类对象
         MyInvocationHandler handler=new MyInvocationHandler();
//         3.调用bind（）方法，动态返回一个同样实现real所在类实现的接口Subject的代理类对象
        Object obj=handler.bind(real);
        Subject sub= (Subject) obj;//此时的sub就是代理类的对象
        sub.action();//转到InvocationHandler接口的实现类的invoke()方法调用


        NikeClothFactory nike=new NikeClothFactory();
        ClothFactory proxyCloth= (ClothFactory) handler.bind(nike);
        proxyCloth.productCloth();
    }


}
