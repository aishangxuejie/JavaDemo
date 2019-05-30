package com.aishangxuejie.demo;

/**
 * @author: Cuigm
 * @ClassName:  strSplitObject
 * @Description: TODO
 * @date: 2019年5月29日下午3:47:37
 */
public class strSplitObject {
	public static void main(String[] args) {
		
		String param = "18;5;11";//随机组合字符串
		boolean boo = false;//定义初始审核状态可以是true 可以是false
		if(!boo&&param.contains("18")) {
			//代表查询审核结果 通过 不通过
			boolean boo18 =false;
			if(boo18) {
				boo =true;
				System.out.println("18审核成功");
			}
		}
		if (!boo&&param.contains("13")) {
			boolean boo13 =true;
			if(boo13) {
				boo =true;
				System.out.println("13审核成功");
			}
		}
		if (!boo&&param.contains("5")) {
			boolean boo5 =true;
			if(boo5) {
				boo =true;
				System.out.println("5审核成功");
			}
		}
		if (!boo&&param.contains("11")) {
			boolean boo11 =true;
			if(boo11) {
				boo =true;
				System.out.println("11审核成功");
			}
		}
		
		
	}

}
