package com.yiwa.reflection;

/**
 * @Author qiangqiang
 * @Date 2020/6/11 17:02
 * @Version 1.0
 */
public class Test {
  final int  value[]=new int[]{1,2,3,4,5};
  public int[] show(){
      for (int i=0;i<value.length;i++){
          this.value[i]=i;
      }
      return value;
  }

    public static void main(String[] args) {
        final int[] a=new int[]{1,2,3,4,5};
        for (int i=0;i<a.length;i++){
            a[i]=i;
        }
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
