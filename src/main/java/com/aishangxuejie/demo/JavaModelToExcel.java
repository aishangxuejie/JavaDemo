package com.aishangxuejie.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaModelToExcel {

	public static void main(String[] args) {
		String pattern = "private[\\s][A-Za-z]+[^((static).)]+[\\s].*;";
		String path = System.getProperty("user.dir");
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		System.out.println("输入实体类路:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			List<Modelexcel> ml = new ArrayList<>();
			str = br.readLine();
			// str =
			// "D:\\Eclipse_workspace\\gsbx\\src\\com\\easternie\\siis\\local\\business\\entity\\Lfc1.java";
			BufferedReader br1 = new BufferedReader(new FileReader(str));
			String contentLine;
			while ((contentLine = br1.readLine()) != null) {
				// 读取每一行，并输�?
				// 现在创建 matcher 对象
				if (null != contentLine && contentLine.length() != 0) {
					Matcher m = r.matcher(contentLine);
					while (m.find()) {
						String str1 = m.group().replace("private ", "").replace(";", "").replaceAll(" +", ",");
						System.out.println(str1);
						String[] s = str1.split(",");
						Modelexcel me = new Modelexcel();
						me.setClType(s[0].toString());
						me.setClName(s[1].toString());
						me.setClContent("");
						ml.add(me);
					}
				}
			}
			// 输出数组
			// System.out.println(arr1);
			XSSFWorkbook workbook = ExcelWriter.exportData(ml);
			// 以文件的形式输出工作簿对�?
			FileOutputStream fileOut = null;
			try {

				String exportFilePath = path + "/modelExcel.xlsx";
				File exportFile = new File(exportFilePath);
				if (!exportFile.exists()) {
					exportFile.createNewFile();
				}

				fileOut = new FileOutputStream(exportFilePath);
				workbook.write(fileOut);
				fileOut.flush();
				System.out.println("===> export over!!!\n" + exportFilePath);
			} catch (Exception e) {
				System.out.println("输出Excel时发生错误，错误原因�?" + e.getMessage());
			} finally {
				try {
					if (null != fileOut) {
						fileOut.close();
					}
					br1.close();
				} catch (IOException e) {
					System.out.println("关闭输出流时发生错误，错误原因：" + e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ExcelWriter {
	private static List<String> CELL_HEADS; // 列头
	static {
		// 类装载时就载入指定好的列头信息，如有�?要，可以考虑做成动�?�生成的列头
		CELL_HEADS = new ArrayList<>();
		CELL_HEADS.add("字段名称");
		CELL_HEADS.add("字段类型");
		CELL_HEADS.add("字段含义");

	}

	/**
	 * 生成Excel并写入数据信�?
	 * 
	 * @param dataList
	 *            数据列表
	 * @return 写入数据后的工作簿对�?
	 */
	public static XSSFWorkbook exportData(List<Modelexcel> dataList) {
		// 生成xlsx的Excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也�?更改为xls
		// Workbook workbook = new HSSFWorkbook();
		// 生成Sheet表，写入第一行的列头
		Sheet sheet = buildDataSheet(workbook);
		// 构建每行的数据内�?
		int rowNum = 1;
		for (Iterator<Modelexcel> it = dataList.iterator(); it.hasNext();) {
			Modelexcel data = it.next();
			if (data == null) {
				continue;
			}
			// 输出行数�?
			Row row = sheet.createRow(rowNum++);
			convertDataToRow(data, row);
		}
		return workbook;
	}

	/**
	 * 生成sheet表，并写入第�?行数据（列头�?
	 * 
	 * @param workbook
	 *            工作簿对�?
	 * @return 已经写入列头的Sheet
	 */
	private static Sheet buildDataSheet(XSSFWorkbook workbook) {
		Sheet sheet = workbook.createSheet();
		// 设置列头宽度
		for (int i = 0; i < CELL_HEADS.size(); i++) {
			sheet.setColumnWidth(i, 4000);
		}
		// 设置默认行高
		sheet.setDefaultRowHeight((short) 400);
		// 构建头单元格样式
		CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
		// 写入第一行各列的数据
		Row head = sheet.createRow(0);
		for (int i = 0; i < CELL_HEADS.size(); i++) {
			Cell cell = head.createCell(i);
			cell.setCellValue(CELL_HEADS.get(i));
			cell.setCellStyle(cellStyle);
		}
		return sheet;
	}

	/**
	 * 设置第一行列头的样式
	 * 
	 * @param workbook
	 *            工作簿对�?
	 * @return 单元格样式对�?
	 */
	private static CellStyle buildHeadCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		return style;
	}

	/**
	 * 将数据转换成�?
	 * 
	 * @param data
	 *            源数�?
	 * @param row
	 *            行对�?
	 * @return
	 */
	private static void convertDataToRow(Modelexcel data, Row row) {
		int cellNum = 0;
		Cell cell;
		// 列名
		cell = row.createCell(cellNum++);
		cell.setCellValue(null == data.getClName() ? "" : data.getClName());
		// 类型
		cell = row.createCell(cellNum++);
		cell.setCellValue(null == data.getClType() ? "" : data.getClType());
		// 说明
		cell = row.createCell(cellNum++);
		if (null != data.getClContent()) {
			cell.setCellValue(data.getClContent());
		} else {
			cell.setCellValue("");
		}
	}
}

class Modelexcel {
	private String clName;
	private String clType;
	private String clContent;

	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	public String getClType() {
		return clType;
	}

	public void setClType(String clType) {
		this.clType = clType;
	}

	public String getClContent() {
		return clContent;
	}

	public void setClContent(String clContent) {
		this.clContent = clContent;
	}

}
