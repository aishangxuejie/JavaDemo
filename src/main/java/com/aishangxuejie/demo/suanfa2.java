package com.aishangxuejie.demo;

//��дһ������ǰ100λ쳲��������ĺ��������ݶ��壬쳲��������е�ǰ��λ������0��1������ÿ��������ǰ�������ֵĺ͡�
//���磬ǰ10λ쳲�������Ϊ��0��1��1��2��3��5��8��13��21��34��
public class suanfa2 {
	
    public static void main(String[] args) {  
    	fibo1();
    	fiob2();
    	fiob3();
    }  
    
    private static void fibo1(){
    	long fibo[] = new long[30];
    	fibo[0] = 0;
    	fibo[1] = 1;
    	for( int i= 2 ;i < fibo.length; i++){
    		fibo[i] = fibo[i-1] + fibo[i-2];
    	}
    	System.out.println("����--쳲��������е�ǰ30��������ʾ��"); 
    	for (long fib : fibo) {
    		if(fib % 5 == 0){
    			System.out.println();
    		}
    		System.out.print(fib +"\t\t");
		}
    }
    
    private static void fiob2(){
    	System.out.println();
    	System.out.println("�ݹ�--쳲��������е�ǰ30��Ϊ��");  
      for (int j = 1; j <= 30; j++) {  
          System.out.print(getfibo(j) + "\t\t");  
          if (j % 5 == 0)  
              System.out.println();  
      } 
      System.out.println();
    }
    
    private static int getfibo(int i){
    	if(i==1){
    		return 0;
    	}
    	if(i==2){
    		return 1;
    	}
    	else{
    		return getfibo(i - 1) + getfibo(i - 2);
    	}
    }
    
    private static void fiob3(){
    	int a=0,b=1,c=0;
    	System.out.println("����--쳲���������ǰ30��Ϊ��");
    	for( int i = 0;i<28; i++){
    		if(c==0 ||c==1){
    			System.out.print(a  + "\t\t");
    		}
    		c= a+b;
    		a=b;
    		b=c;
    		if(c%5==0){
    			System.out.println();
    		}
    		System.out.print(c  + "\t\t");
    	}
    }
}
