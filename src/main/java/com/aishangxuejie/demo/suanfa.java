package com.aishangxuejie.demo;

//ʹ��forѭ����whileѭ���͵ݹ�д��3������������������е��ܺ͡�
public class suanfa {
	public static void whileMethod(int[] array) {
	    if (array == null || array.length < 1) {
	        return;
	    }

	    int sum = 0;
	    int i = 0;

	    while ( i < array.length) {
	        sum += array[i];
	        i++;
	    }

	    System.out.println("while:"+sum);

	}

	public static void forMethod(int[] array) {
	    if (array == null || array.length < 1) {
	        return;
	    }

	    int sum = 0;
	    for (int num : array) {
	        sum += num;
	    }

	    System.out.println("for:"+sum);

	}

	public static int recursiveMethod(int[] array,int i) {
	    if (array == null || array.length < 1) {
	        return 0;
	    }

	    if (i < array.length ) {
	        return array[i] + recursiveMethod(array, i+1);
	    }

	    return 0;

	}

	public static void main(String[] args) {

	    int[] array = {1,3,4,5,7};

	    whileMethod(array);

	    forMethod(array);

	    System.out.println("recursive:"+recursiveMethod(array, 0));

	}
}
