package com.aishangxuejie.demo;

/**
 * Oracle�ֶ���Ϣʵ����
 * @author Cetrin Wang
 *
 */
public class ColumnData {
    private String columnName;//����
    private String columnType;//����
    private int columnSize;   //����
    private int colScale;     //С��λ
    private String comment; //ע��
    

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ColumnData(){
    }

    public ColumnData(String columnName,String columnType,int columnSize,int colScale,String comment){
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnSize = columnSize;
        this.colScale = colScale;
        this.comment = comment;
    }


    public int getColScale() {
        return colScale;
    }

    public void setColScale(int colScale) {
        this.colScale = colScale;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnType() {
        return columnType;
    }
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public int getColumnSize() {
        return columnSize;
    }
    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    @Override
    public String toString(){
        return "����:"+getColumnName()+",�ֶ�����:"+getColumnType()+",����:"+getColumnSize()+",С��λ:"+getColScale();

    }
}