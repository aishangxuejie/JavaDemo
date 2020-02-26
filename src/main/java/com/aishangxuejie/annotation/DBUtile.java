package com.aishangxuejie.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

@JDBCConfig(ip="192.168.123.115", database = "lwjs", password = "lwjs", username = "654321")
public class DBUtile {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public Connection testCon() {
		Connection con = null;// 创建一个数据库连接
		JDBCConfig jc = DBUtile.class.getAnnotation(JDBCConfig.class);
		System.out.println(jc.ip());
		String  url = "jdbc:mysql://192.168.123.115:3306/lwjs";
		try {
			con = DriverManager.getConnection(url, jc.username(), jc.password());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
