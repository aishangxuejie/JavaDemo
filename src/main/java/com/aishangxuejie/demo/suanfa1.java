package com.aishangxuejie.demo;

import java.util.Arrays;

public class suanfa1 {
	//��дһ������ϲ��б�Ԫ�صĺ��������磺�����������б�Ϊ[a��B��C]��[1��2��3]����������[a��1��B��2��C��3]��
	public static void main(String[] args) {
		
		String[] arr1 = { "A", "B", "C", "D", "E" };
		String[] arr2 = { "!", "@", "#", "$", "%" };       
		String[] arr = getCrossMergeList(arr1, arr2);
		System.out.println(Arrays.toString(arr));
	}
	private static String[] getCrossMergeList(String[] arr1, String[] arr2) {
	    int i;
	    int j;
	    // ��Ȼ�Ǻϲ���������ȷ�� newArr[] �ĳ���,��Ȼ�ǽ����Ǳ�Ȼ���Ҫ��ż�ֿ�
	    String[] newArr = new String[arr1.length + arr2.length];//newArr[0,1,2,3,4,5....]
	    for (i = 0, j = 0; i < arr1.length; i++) {
	        j = 2 * i;//ż��λ--arr1
	        if (j > 2 * arr2.length)
	            j = arr2.length + i;
	        newArr[j] = arr1[i];//newArr[0,2,4....]
	    }
	    for (i = 0, j = 0; i < arr2.length; i++) {
	        j = 2 * i + 1;//����λ--arr2
	        if (j > 2 * arr1.length)
	            j = arr1.length + i;
	        newArr[j] = arr2[i];//newArr[1,3,5....]
	    }
	    return newArr;
	}

}
