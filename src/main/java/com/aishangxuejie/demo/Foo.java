package com.aishangxuejie.demo;

public class Foo {
    static int i = 1024;
    static double k = 2048.0;
    int b = 1;
    public static void main(String[] args){
        Foo f = new Foo();
        //Ӧ���Ծ�̬��ʽ��������Foo�еľ�̬����setK(double) ����setK�Ͳ�Ҫ��̬������
        f.setK(2.0);//The static method setK(double) from the type Foo should be accessed in a static way
        System.out.println("k = " + k);
    }
    public void setI(int i){
    	Foo.i = i;
        this.i = i;//The static field Foo.i should be accessed in a static way�򵥷�����ǣ�Ӧ���� Foo.i������ʽ
    }
    //java ������ʽ��Ϊ��̬��ʼ�����߾�̬�����
    public static void setK(double k){
        Foo.k = k;
    }
    
//    public static void setB(int b){
//        Foo.b = b;//Cannot make a static reference to the non-static field Foo.b �ܿ����ɣ���������ѱ���b��ɾ�̬����
//        this.b = b;//Cannot use this in a static context 
//        b = 666;
//    }
    
    // ��󣬲����java����֪ʶ�㡣��ʼ��˳�򣺾�̬��������̬��ʼ����>��������ʼ����>������
    // ��ô���һ�����⣬����this�ؼ��������˽�����أ�
}
