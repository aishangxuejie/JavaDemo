package com.aishangxuejie.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ��oracle�ı�ṹͬ����mysql
 * @author ZhangQiang
 * @date ����һ�������ʮ���� 12:27:58
 */
public class OracleToMysql {
	
	

	public static void main(String args[]) throws Exception {
		createTableMS("AA26");
	}

	/**
	 * ��oracle�ı��Ƶ�MySQL��
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public static void createTableMS(String tableName) throws Exception {
		Connection conn =null;
		//Connection conn = MysqlDB.getConn();
		PreparedStatement ps = null;

		// ��ѯȫ������Ϣ
		List<ColumnData> list = getColList(tableName);
		StringBuffer sb = new StringBuffer();

		sb.append("CREATE TABLE ").append(tableName.toUpperCase()).append("(");

		for (int i = 0; i < list.size(); i++) {
			ColumnData col = list.get(i);
			String type = getMySQLType(col);
			if ("ID".equalsIgnoreCase(col.getColumnName())) {
				sb.append(col.getColumnName() + " ").append(type + " not null PRIMARY KEY AUTO_INCREMENT,");
			} else {
				sb.append(col.getColumnName() + " ").append(type + " ");
				if(col.getComment() == null || col.getComment().equals("") || col.getComment().equals("null")){
					sb.append("COMMENT '�����ע��',");
				}else{
					sb.append("COMMENT '"+col.getComment()+"',");
				}
			}
		}
		sb = sb.deleteCharAt(sb.length() - 1);
		sb.append(") engine=innodb default charset=utf8 auto_increment=1 ");

		System.out.println(sb.toString());

		try {
			ps = conn.prepareStatement(sb.toString());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	/**
	 * ��Oracle��Typeת��Oracle��Type
	 */
	private static String getMySQLType(ColumnData c) {
		if (c == null) {
			return null;
		}
		String type = c.getColumnType();
		if ("BLOB".equalsIgnoreCase(type)) {
			return "longtext";
		} else if ("DATE".equalsIgnoreCase(type)) {
			return "datetime";
		} else if ("VARCHAR2".equalsIgnoreCase(type)) {
			if (c.getColumnSize() >= 4000) {
				return "text";
			} else {
				return "varchar(" + c.getColumnSize() + ")";
			}
		} else if ("NUMBER".equalsIgnoreCase(type)) {
			if (c.getColScale() > 0) {
				int n = c.getColumnSize() - c.getColScale();// ����λ
				int s = c.getColScale(); // С��λ
				return "decimal(" + n + "," + s + ")";
			} else {
				return "int";
			}
		}

		return c.getColumnType();
	}

	/**
	 * ��ȡoracle����Ϣ
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public static List<ColumnData> getColList(String tableName) throws Exception {
		Connection conn = null;
		//Connection conn = OracleDB.getConn();
		PreparedStatement ps = null;
		ResultSet res = null;
		ArrayList<ColumnData> list = new ArrayList<ColumnData>();

		String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE ROWNUM = 1";
		String comment = "SELECT t1.COLUMN_NAME,t2.COMMENTS FROM user_tab_columns t1, user_col_comments t2 "
				+ "WHERE t1.TABLE_NAME='"+tableName+"' AND t1.TABLE_NAME  =t2.TABLE_NAME AND t1.COLUMN_NAME =t2.COLUMN_NAME";
		Map<String,String> map = new HashMap<String,String>();
		try{
			ps = conn.prepareStatement(comment);
			res = ps.executeQuery();
			while(res.next()){
				map.put(res.getString("COLUMN_NAME"), res.getString("COMMENTS"));
			}
		}catch(Exception e){
			
		}
		
		try {
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			ResultSetMetaData metaData = res.getMetaData();

			for (int i = 1, size = metaData.getColumnCount(); i <= size; i++) {
				ColumnData cd = new ColumnData(metaData.getColumnName(i), metaData.getColumnTypeName(i),
						metaData.getColumnDisplaySize(i), metaData.getScale(i),map.get(metaData.getColumnName(i)));
				list.add(cd);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (res != null) {
					res.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}