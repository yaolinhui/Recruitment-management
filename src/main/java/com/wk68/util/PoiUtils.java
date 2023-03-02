package com.wk68.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 创建解析Excel 对POI技术的封装 该工具类的扩展功能请参考 @PoiHandler 注解
 * 支持Excel2007和2010,并且兼容Java任意对象类型
 * 
 * @Description: POI操作工具类
 * @author Mashuai
 * @Date 2018-5-28 上午12:51:07
 * @Email 1119616605@qq.com
 *
 */
public class PoiUtils {

	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 创建Excel
	// 返回Excel文件^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	/**
	 * 实体类需要使用@PoiHandler注解excel表头 把List集合转为Excel文件,并输出字节输出流
	 * 
	 * @note headers excel表头值取注解的中的值
	 * @param list     对象集合
	 * @param clazz    集合中的对象类型 例如：User.class
	 * @param filePath Excel文件输出路径
	 * @throws IOException
	 */
	public void createExcel(List<?> list, Class<?> clazz, File filePath) throws IOException {
		// 获取Excel表头,excelHeader()
		String[] headers = getHeaders(clazz);
		createExcel(list, clazz, filePath, headers);
	}

	/**
	 * 把List集合转为Excel文件,并输出字节输出流
	 * 
	 * @param list     对象集合
	 * @param clazz    集合中的对象类型 例如：User.class
	 * @param filePath Excel文件输出路径
	 * @param headers  excel表头值
	 * @throws IOException
	 */
	public void createExcel(List<?> list, Class clazz, File filePath, String... headers) throws IOException {
		// 判断集合为空则不创建Excel表格
		if (isEmpty(list))
			return;
		// 判断文件输出路径是否存在
		if (!filePath.exists()) {
			filePath.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(filePath);
		// 创建Excel表格
		Workbook workbook = createWorkbook(list, clazz, headers);
		workbook.write(out);
	}

	/**
	 * 实体类需要使用@PoiHandler注解excel表头 把List集合转为Excel文件,并输出字节输出流
	 * 
	 * @note headers excel表头值取注解的中的值
	 * @param list         对象集合
	 * @param clazz        集合中的对象类型 例如：User.class
	 * @param outputStream 字节输出流
	 * @throws IOException
	 */
	public void createExcel(List<?> list, Class clazz, OutputStream outputStream) throws IOException {
		// 获取Excel表头,excelHeader()
		String[] headers = getHeaders(clazz);
		createExcel(list, clazz, outputStream, headers);

	}

	/**
	 * 把List集合转为Excel文件,并输出字节输出流
	 * 
	 * @param list         对象集合
	 * @param clazz        集合中的对象类型 例如：User.class
	 * @param outputStream 字节输出流
	 * @param headers      excel表头值
	 * @throws IOException
	 */
	public void createExcel(List<?> list, Class clazz, OutputStream outputStream, String... headers)
			throws IOException {
		// 判断集合为空则不创建Excel表格
		// if(isEmpty(list))return;
		// 创建Excel表格
		Workbook workbook = createWorkbook(list, clazz, headers);
		workbook.write(outputStream);

	}

	/**
	 * 判断集合为空
	 * 
	 * @param list
	 * @return
	 */
	private Boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			System.err.println("需要转换的集合不能为空！！！");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 创建 WorkBook
	 * 
	 * @param list
	 * @param clazz
	 * @param headers
	 * @return
	 */
	private Workbook createWorkbook(List<?> list, Class clazz, String[] headers) {
		Workbook workbook = null;
		// 创建一个Excel文件
		try {
			workbook = new HSSFWorkbook();// 构造一个xls后缀的EXCEL文件对象,2007
		} catch (Exception e) {
			e.printStackTrace();
			workbook = new XSSFWorkbook();// 构造一个xlsx后缀的EXCEL文件对象,2010
		}
		Sheet sheet = workbook.createSheet(clazz.getSimpleName());// 创建一个sheet表,并设置Sheet表名称,默认使用简类名
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth(10);
		// 创建表头字段
		Row row = sheet.createRow(0);// 创建第一行表头,创建索引为0的Row对象
		row.setHeightInPoints((short) 18);// 设置表头行高度
//		headers = {"姓名","性别","年龄","出生日期","住址"};
		int head_length = headers.length;
		Cell[] cells = new HSSFCell[head_length];
		// 填入表头的值
		for (int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);// 创建一个单元格对象
			cells[i].setCellType(CellType.STRING);// 设置单元格类型为文本
			cells[i].setCellStyle(defaultHeaderCellStyle(workbook));// 设置表头默认样式
//			cells[i].setCellValue(headers[i]);//设置表头单元格的值,默认列宽可能文本显示不全
			setCellValue(row, i, headers[i], sheet);// 设置单元格的值,并自适应列宽
			// 设置表格自适应列宽
//			sheet.autoSizeColumn(i);//不起作用
		}

		// 创建每一个数据行
		for (int i = 0; i < list.size(); i++) {
			row = this.createRowData(sheet, i + 1, list.get(i), clazz, head_length, workbook);
		}
		return workbook;
	}

	/**
	 * 创建Sheet表中的第i行数据
	 * 
	 * @param sheet       Excel文件中的Sheet表格
	 * @param rowNumber   Excel文件中的Sheet表格的第i行数据
	 * @param obj         要设置的数据对象
	 * @param clazz       数据对象的Java类型
	 * @param head_length 表头长度
	 * @return
	 */
	private Row createRowData(Sheet sheet, int rowNumber, Object obj, Class clazz, int head_length, Workbook workbook) {
		Row row = sheet.createRow(rowNumber);// 创建第rowNumber行对象
		Field[] fields = clazz.getDeclaredFields();// 类的所有属性
		int field_length = fields.length;
		String cellValue = "";
		// 设计cell的格式
		for (int c = 0, f = 0; c < head_length && f < field_length; c++, f++) {// c代表第rowNumber行的第c列单元格;f代表类的第f个字段
			System.out.println("c=>" + c + "|f=>" + f);
			try {
				if (excelIgnore(fields[f])) {// 如果该字段f不需要导出excel
					c--;
					continue;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			row.createCell(c);// 创建一个单元格对象
			row.getCell(c).setCellType(CellType.STRING);// 设置单元格类型为字符文本
			row.getCell(c).setCellStyle(defaultCellStyle(workbook));// 设置单元格默认样式
			try {
				fields[f].setAccessible(true);// 把private私有字段设置为允许访问
				cellValue = getFieldValue(fields[f], obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 设置单元格的值
//			row.getCell(c).setCellValue(cellValue);//设置第rowNumber行的第c列单元格的字符文本值,默认列宽可能文本显示不全
			setCellValue(row, c, cellValue, sheet);// 设置单元格的值,并自适应列宽

		}
		return row;// 第rowNumber行对象
	}

	/**
	 * 设置单元格的值,并自适应列宽
	 * 
	 * @param row   单元格所在的行
	 * @param c     单元格所在的列索引
	 * @param value 单元格的值
	 * @param sheet 单元格所在的表
	 */
	private void setCellValue(Row row, int c, String value, Sheet sheet) {
		System.out.println("{value:" + value + ",length:" + (value.getBytes().length * 256) + "}");
		if (value != null && !" ".equals(value)) {
			int beforeWidth = sheet.getColumnWidth(c);// 以前单元格宽度
			int nowWidth = value.getBytes().length * 256;// 现在要设置的值需要的单元格宽度
			System.out.println("{beforeWidth:" + beforeWidth + ",nowWidth:" + nowWidth + "}");
			/* if (nowWidth > beforeWidth) { */
				//sheet.setColumnWidth(c, nowWidth);// 如果宽度不足以显示现在的值,则设置为需要的宽度
			row.getCell(c).setCellValue(value);// 设置第rowNumber行的第c列单元格的字符文本值
			/* } */
		}

	}

	/**
	 * 根据字段和对象,获取该对象的字段文本值
	 * 
	 * @param field 字段
	 * @param obj   对象
	 * @return 该对象的字段文本值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private String getFieldValue(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
//		String fieldValue = "";
		Class<?> ft = null;// 字段类型
		ft = field.getType();
		System.out.println(field.getName() + " : " + ft);

		field.setAccessible(true);// 设置对象属性允许访问，以便设置值
		if (ft == String.class) {
			return String.valueOf(field.get(obj));
		} else if (ft == Date.class) {
			PoiHandler poi = field.getAnnotation(PoiHandler.class);
			return new SimpleDateFormat(poi == null ? "yyyy-MM-dd HH:mm:ss" : poi.dateTimePattern()).format(field.get(obj));
		} else if (ft == Timestamp.class) {
			String timeStr = "";
			try {
				PoiHandler poi = field.getAnnotation(PoiHandler.class);
				timeStr = new SimpleDateFormat(poi == null ? "yyyy-MM-dd HH:mm:ss" : poi.timestampPattern())
						.format(field.get(obj));
			} catch (Exception e) {
				e.printStackTrace();
				timeStr = String.valueOf(field.get(obj));
			}
			return timeStr;
		} else if (ft == Boolean.class || ft == boolean.class) {
			return (Boolean) field.get(obj) ? "是" : "否";
		} else if (ft == String[].class) {// 字符串数组
			return Arrays.asList(field.get(obj)).toString();
		} else {
			return String.valueOf(field.get(obj));
		}
	}

	/**
	 * 是否忽略该字段:Excel表格中不生成该字段列
	 * 
	 * @param field
	 * @return
	 */
	private boolean excelIgnore(Field field) {
		PoiHandler poi = field.getAnnotation(PoiHandler.class);
		if (poi == null)
			return false;// 不忽略
		return poi.excelIgnore();
	}

	/**
	 * 是否忽略该字段:Excel表格中不生成该字段列
	 * 
	 * @param field
	 * @return
	 */
	private String excelHeader(Field field) {
		PoiHandler poi = field.getAnnotation(PoiHandler.class);
		if (poi == null) {
			System.err.println("POI工具异常!!!用法错误!!! 请传入Excel表头或者在实体类上写入表头注解,例如:@PoiHandler(excelHeader=\"学生姓名\")");
		}
		return poi.excelHeader();
	}

	/**
	 * 获取表头
	 * 
	 * @param clazz
	 * @return
	 */
	private String[] getHeaders(Class<?> clazz) {
		List<Field> fields = Arrays.asList(clazz.getDeclaredFields());// 类的所有属性
		// 收集excel表头
		List<String> headerList = new ArrayList<String>();
		// 去掉要忽略的excel字段
		for (Field f : fields) {
			if (!excelIgnore(f))
				headerList.add(excelHeader(f));// 不忽略的字段才取出表头值
		}
		String[] headers = new String[headerList.size()];
		return headerList.toArray(headers);
	}

	/**
	 * 单元格默认样式 文本剧中显示
	 * 
	 * @param workbook
	 * @return
	 */
	private CellStyle defaultCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();// 创建一个单元格样式
		// 设置单元格填充样式
		style.setAlignment(HorizontalAlignment.CENTER);// 水平剧中显示
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直剧中显示
		return style;
	}

	/**
	 * 默认表头单元格样式
	 * 
	 * @param workbook
	 * @return
	 */
	/**
	 * @param workbook
	 * @return
	 */
	private CellStyle defaultHeaderCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();// 创建一个单元格样式
		// 设置单元格填充样式
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);// 可以填充单元格样式
		// style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);//填充背景色
		// style.setFillForegroundColor(HSSFColor.GOLD);
		// style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE);
		// style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		// style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setAlignment(HorizontalAlignment.CENTER);// 水平剧中显示
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直剧中显示
		style.setBorderBottom(BorderStyle.SLANTED_DASH_DOT);// 双实线下边框
		// 设置单元格字体样式
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 10);// 字体大小
		font.setFontName("华文中宋");// 字体
		font.setBold(true);// 粗体
		// font.setColor(HSSFColor.BLACK.index);//字体颜色
		style.setFont(font);// 设置单元格字体样式
		return style;
	}

	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 解析Excel
	// 返回实体类集合^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

	/**
	 * 把 Excel 文件解析为实体集合
	 * 
	 * @param clazz       需要解析出的实体类型
	 * @param inputStream Excel文件的字节输入流
	 * @return
	 */
	public <T> T parseExcel(Class<T> clazz, File filePath, String originalFilename) {
		InputStream inputStream = null;// 文件字节输入流
		try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (inputStream == null) {// 如果文件路径中没有Excel文件
			System.err.println("请检查文件路径是否包含一个Excel文件!!!");
			return null;
		}
		return (T) parseExcel(clazz, inputStream, originalFilename);
	}

	/**
	 * 把 Excel 文件解析为实体集合
	 * 
	 * @param clazz       需要解析出的实体类型
	 * @param inputStream Excel文件的字节输入流
	 * @return
	 */
	public <T> T parseExcel(Class<T> clazz, InputStream inputStream, String originalFilename) {
		Workbook workbook = null;// 一个EXCEL文件对象
		Sheet sheet = null;// EXCEL文件的sheet表
		List<T> list = null;
		// 从字节输入流中解析出 Workbook
		workbook = getWorkbook(inputStream, originalFilename);
		// 解析 Workbook 的 Sheet 表
		sheet = workbook.getSheetAt(0);// 获取Excel文件的第一个Sheet表
		// 解析 Sheet 表头
		String[] headerArr = this.getSheetHeader(sheet);
		System.out.println("表头是=>" + Arrays.asList(headerArr));// 把数组转为集合输出,测试 解析数据是否异常
		// 把 Sheet表格中的数据转为实体类 对应的 对象集合
		list = (List<T>) parseSheet(sheet, clazz);

		return (T) list;
	}

	/**
	 * 从字节输入流中解析出 Workbook
	 * 
	 * @param inputStream      Excel文件的字节输入流
	 * @param originalFilename Excel文件的名称
	 * @return Workbook
	 * @throws IOException
	 */
	private Workbook getWorkbook(InputStream inputStream, String originalFilename) {
		Workbook workbook = null;// 一个EXCEL文件对象
		try {
			// 判断文件是否以xls后缀
			if (originalFilename.toLowerCase().endsWith("xls"))
				workbook = new HSSFWorkbook(inputStream);// 构造一个HSSFWorkbook实例
			// 判断文件是否以xlsx后缀
			if (originalFilename.toLowerCase().endsWith("xlsx"))
				workbook = new XSSFWorkbook(inputStream);// 构造一个XSSFWorkbook实例
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 解析 Sheet 表头
	 * 
	 * @param sheet
	 * @return
	 */
	private String[] getSheetHeader(Sheet sheet) {
		List<String> headerList = new ArrayList<String>();
		Row firstrow = sheet.getRow(0);// 获取第一个sheet表的第一行Row
		// --------测试代码开始----------------------测试EXCEL表格中是否有数据
		Iterator<Cell> cIterator = firstrow.iterator();// 调用Row对象的迭代器方法
		while (cIterator.hasNext()) {
			headerList.add(cIterator.next().getStringCellValue());// 把表头添加到集合中
		}
		String[] headerArr = new String[headerList.size()];// 创建一个和集合长度一样的数组
//		System.out.println("表头是=>"+Arrays.asList(headerArr));//把数组转为集合输出
		return headerList.toArray(headerArr);// 把集合转为数组返回
	}

	/**
	 * 把 Sheet表格中的数据转为实体类 对应的 对象集合
	 * 
	 * @param sheet Excel表格
	 * @param clazz 实体类类型
	 * @return 实体类 对应的 对象集合
	 */
	private <T> T parseSheet(Sheet sheet, Class<T> clazz) {
		List<T> list = new ArrayList<T>();// 对象集合
		Object object = null;// Sheet表中每一行对应的一个数据对象
		Row row = null;// Sheet表中每一行
		// 获取当前对象的所有属性
		Field[] fields = clazz.getDeclaredFields();

		int rowNum = sheet.getLastRowNum();// 得到EXCEL表中数据的行数,索引从0开始,得到3其实是指共有4行数据
		System.out.println("Sheet表中行数	LastRowNum=> " + rowNum);
		row = sheet.getRow(1);// 得到EXCEL表中的第2行,第一行是表头
		int celNum = row.getLastCellNum();// 得到一行中单元格的数量,索引从1开始
		System.out.println("Sheet表中列数 celNum=> " + celNum);

		// Sheet表格中 r行 c列 ;clazz 对象 中第f个字段
//		for (int r=1,c=0,f = 0; r < rowNum && c < celNum && f < field_length; r++,c++,f++) {//c代表第r行的第c列单元格;f代表类的第f个字段
		for (int r = 1; r <= rowNum; r++) {
			row = sheet.getRow(r);
			if (row == null) {
				break;
			} // 如果取到没有数据的row就不再解析
			for (int j = 0; j < row.getLastCellNum(); j++) {
				row.getCell(j).setCellType(CellType.STRING);// 1代表文本类型,把所有的单元格设置为文本类型
			}
			// 把Excel中一个数据行 row 解析成为一个 clazz对象
			Object obj = parseRow(row, clazz, celNum, fields);
			list.add((T) obj);// 解析出每一行数据对象放入集合
		}
		return (T) list;

	}

	/**
	 * 把Excel中一个数据行 row 解析成为一个 clazz对象
	 * 
	 * @param row   数据行
	 * @param clazz 需要解析成的对象类型
	 * @return 一个clazz类型对象
	 */
	private <T> T parseRow(Row row, Class<T> clazz, int celNum, Field[] fields) {
		Object object = null;
		String fieldValue = "";
		int field_length = fields.length;// clazz 对象字段总数
		// 创建一个对象
		try {
			object = clazz.newInstance();// 构造一个对象实例
		} catch (InstantiationException e) {
			// TODO 此处省略记录日志
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 此处省略记录日志
			e.printStackTrace();
		}
		// Sheet表格中 r行 c列 ;clazz 对象 中第f个字段
		for (int c = 0, f = 0; c < celNum && f < field_length; c++, f++) {// c代表第r行的第c列单元格;f代表类的第f个字段

			System.out.println("解析Excel取出单元格的值给字段  c=>" + c + "|f=>" + f);
			try {
				if (excelIgnore(fields[f])) {// 如果该字段f不需要导出excel,也不需要解析出来该字段
					c--;
					continue;
				}
			} catch (ArrayIndexOutOfBoundsException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 获取每一个单元格的字符串文本值
			fieldValue = row.getCell(c).getStringCellValue();
			// 设置字段的值
			try {
				setFieldValue(fieldValue, fields[f], object);// 设置字段的值
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (T) object;
	}

	/**
	 * 设置字段的值
	 * 
	 * @param fieldValue 设置的值
	 * @param field      设置字段
	 * @param obj        设置字段值的对象
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private void setFieldValue(String fieldValue, Field field, Object object)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> ft = field.getType();// 字段类型
		field.setAccessible(true);// 设置对象属性允许访问，以便设置值
		// 开始设置值
		if (fieldValue != null && !"".equals(fieldValue) && !fieldValue.equals("null")) {// 值不为空
			if (ft == String.class) {
				field.set(object, fieldValue);// 给对象的该字段设置对应的值
			} else if (ft == Integer.class || ft == int.class) {
				field.set(object, Integer.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == BigDecimal.class) {
				field.set(object, new BigDecimal(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Date.class) {
				PoiHandler poi = field.getAnnotation(PoiHandler.class);
				Date dateValue = str2Date(fieldValue, poi == null ? null : poi.dateTimePattern());
				field.set(object, dateValue);// 给对象的该字段设置对应的值
			} else if (ft == Timestamp.class) {
				PoiHandler poi = field.getAnnotation(PoiHandler.class);
				Date dateValue = str2Date(fieldValue, poi == null ? null : poi.timestampPattern());
				Timestamp timestamp = new Timestamp(dateValue.getTime());
				field.set(object, timestamp);// 给对象的该字段设置对应的值
			} else if (ft == Boolean.class || ft == boolean.class) {
				field.set(object, Boolean.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Float.class || ft == float.class) {
				field.set(object, Float.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Double.class || ft == double.class) {
				field.set(object, Double.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Long.class || ft == long.class) {
				field.set(object, Long.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Short.class || ft == short.class) {
				field.set(object, Short.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else if (ft == Byte.class || ft == byte.class) {
				field.set(object, Byte.valueOf(fieldValue));// 给对象的该字段设置对应的值
			} else {
				System.err.println(field.getName() + "XXXXXXXXXXX该单元格值{" + fieldValue + "} 对应的字段类型是=>{" + ft + "}");
				field.set(object, fieldValue);// 给对象的该字段设置对应的值
			}
		}
	}

	/**
	 * 尝试把日期字符串java.lang.String转为java.util.Date
	 * 
	 * @param value
	 * @return
	 */
	private Date str2Date(String value, String dateTimePattern) {
//		System.out.println("开始 日期转换 {value:"+value+",dateTimePattern:"+dateTimePattern+"}");
		Date date = null;
		SimpleDateFormat formatDateTime = null;
		SimpleDateFormat formatDate = null;
		if (value != null && !"".equals(value) && !"null".equals(value)) {// 单元格中的文本值不为空

			if (dateTimePattern != null && !"".equals(dateTimePattern) && !"null".equals(value)) {
				formatDateTime = new SimpleDateFormat(dateTimePattern);
			} else {
				formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				formatDate = new SimpleDateFormat("yyyy-MM-dd");
			}
			// 把单元格中的文本值转为日期类型
			try {
				date = formatDateTime.parse(value);
			} catch (ParseException e) {
				try {
					date = formatDate.parse(value);
				} catch (ParseException e2) {
					e2.printStackTrace();
					System.err.println("XXXXXXX请检查你Excel表格中日期的格式是否正确~~~");
				}
			}
		}

		return date;
	}

}
