package com.yiwa.reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 16:29
 * @Version 1.0
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        Class<?> stu=Class.forName(getValue("className"));
        Method methodName = stu.getMethod(getValue("methodName"));
        methodName.invoke(stu.getConstructor().newInstance(),null);


    }

    public static String getValue(String key) throws IOException {
        Properties properties=new Properties();
        FileReader in = new FileReader("D:\\spring\\java\\JavaReflection\\src\\com\\yiwa\\reflection\\pro.txt");
        properties.load(in);
        in.close();
        return properties.getProperty(key);
    }
}
