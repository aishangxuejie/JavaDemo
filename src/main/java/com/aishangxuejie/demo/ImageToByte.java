package com.aishangxuejie.demo;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

/**
 * @author CuiGM
 * @date 2018年6月20日 下午4:29:12
 * @param name
 * @param pathName
 */
public class ImageToByte {
	static String imgString = "";
	public static void getImage(String path) {
		// 字符串由复杂到简单  
//		final String base = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ";
		String base ="MNHQ$OC?7>i!:-. ";
        try {  
            final BufferedImage image = ImageIO.read(new File(path));  
            StringBuffer sb = new StringBuffer(); 
            for (int y = 0; y < image.getHeight(); y += 2) {  
                for (int x = 0; x < image.getWidth(); x++) {  
                    final int pixel = image.getRGB(x, y);  
                    final int r = (pixel & 0xff0000) >> 16;
                	final int g = (pixel & 0xff00) >> 8;
                	final int b = pixel & 0xff;  
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;  
                    final int index = Math.round(gray * (base.length() + 1) / 255);  
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                    sb.append(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }  
                System.out.println();  
            } 
            imgString=sb.toString();
            saveAsTxt(image.getPropertyNames()+".txt");
        } catch (final IOException e) {  
            e.printStackTrace();  
        }  
    }

    public static void main(String[] args) {
    	String realpath = System.getProperty("user.dir");
    	String path = realpath + "/src/com/cuigm/resources/zss.png";
    	getImage(path);//读取图像资源
    }
    /*将字符串保存为.txt文件*/  
    public static void saveAsTxt(String fileName){  
        try{  
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));  
            for(int i = 0;i<imgString.length();i++){  
                out.print(imgString.charAt(i));  
            }  
            out.close();  
              
        }catch(IOException ex){  
            ex.printStackTrace();  
        }  
    }  
}
