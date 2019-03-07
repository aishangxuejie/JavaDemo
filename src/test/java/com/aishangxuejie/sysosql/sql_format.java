package com.aishangxuejie.sysosql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import com.alibaba.druid.sql.SQLUtils;

import lombok.extern.java.Log;
import net.minidev.json.annotate.JsonSmartAnnotation;


/**
 * @author: Cuigm
 * @ClassName:  syso
 * @Description: TODO 一些复杂格式字符串，进行格式化输出
 * @date: 2019年1月10日下午2:32:38
 */
@SpringBootTest
public class sql_format {
	
	@Test
	public void bulidHSql() throws IOException {
		System.out.print("输入对象名：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sqlname = br.readLine();
		System.out.print("输入sql文件路径：");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String sqlpath = br1.readLine();
		
		StringBuffer bodyStr = new StringBuffer("");
		try (Stream<String> stream = Files.lines(Paths.get(sqlpath))) {
			stream.forEach(s -> {
				bodyStr.append(s.replaceAll("\\s{1,}", " "));
			});
		}
		String[] str = bodyStr.toString().replaceAll("\\s{1,}", " ").split(" ");
		String headerStr = "StringBuffer "+sqlname+"  = new StringBuffer()";
		System.out.println(headerStr);
		StringBuffer strout = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			String  sysosql = "";
			if((i + 1) == str.length) {
				sysosql = sqlname + ".append(\" "+strout.append(" " + str[i]).toString()+ " \");" + "\n";
				System.out.print(sysosql);
			}else {
				if ((i + 1) % 10 == 0) {
					sysosql = sqlname + ".append(\" " + strout.append(" " + str[i]).toString() + " \");" + "\n";
					strout.delete(0, strout.length());
				} else {
					sysosql = "";
					strout.append(" " + str[i]);
				}
				System.out.print(sysosql);
			}
		}
		
	}
}
