package com.yiwa.reflection;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 17:53
 * @Version 1.0
 */
public class TestString {
    public static void main(String[] args) {
        String str=new String("  567   ");
        String trim = str.trim();
        System.out.println(trim);
        System.out.println(str);
        System.out.println(str==trim);
        String replace = str.replace("6", "8");
        System.out.println(str);
        System.out.println(replace);
        String intern = str.intern();
        String s="  567   ";
        System.out.println(intern==s);
        System.out.println(intern==str);

    }
}
