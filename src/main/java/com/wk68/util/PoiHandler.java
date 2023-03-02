package com.wk68.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建解析Excel的辅助注解 对PoiUtils的辅助注解 支持Excel2007和2010,并且兼容Java任意对象类型
 * 
 * @Description: POI操作工具类
 * @author Mashuai
 * @Date 2018-5-28 上午12:51:07
 * @Email 1119616605@qq.com
 *
 */
@Target({ ElementType.FIELD })
// 注解位置:字段
@Retention(RetentionPolicy.RUNTIME)
// 运行时可以读取.反射机制可读
@Documented
// 包含在生成的JavaDoc中
public @interface PoiHandler {

	/**
	 * Excel表格的表头 创建Excel表格的表头
	 */
	String excelHeader() default "";

	/**
	 * java.util.Date 格式化模型 默认 yyyy-MM-dd HH:mm:ss 创建或者解析Excel中日期时注明格式
	 */
	String dateTimePattern() default "yyyy-MM-dd HH:mm:ss";

	/**
	 * java.sql.Timestamp 格式化模型 默认 yyyy-MM-dd HH:mm:ss 创建或者解析Excel中日期时注明格式
	 */
	String timestampPattern() default "yyyy-MM-dd HH:mm:ss";

	/**
	 * 数字格式化模型 默认 ##.## 创建或者解析Excel中数值时注明格式
	 */
	String numberPattern() default "##.##";

	/**
	 * 是否忽略该字段 Excel表格中不生成该字段列 默认为false很重要,写了其它注解不一定是要不生成该字段
	 * 创建或者解析Excel时注明是否忽略该字段的创建和解析
	 */
	boolean excelIgnore() default false;

}
