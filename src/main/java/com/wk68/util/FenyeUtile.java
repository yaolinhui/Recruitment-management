package com.wk68.util;

import java.util.List;

/**
 *分页工具类
 * @param <T> 需要执行分页操作的实体类即表明
 */
public class FenyeUtile<T> {
	private T t;//多条件分页查询的条件 封装成的对象
	private Integer page=1;//当前页码 默认
	private Integer limit=10;//每页显示的条数默认
	private Integer count;//总条数
	private List<T> data ;//查询的返回的数据集合
	private String msg="";//返回的消息
	private Integer code=0;//返回的状态码
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getPage() {
		return (page-1)*limit;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public T getT() {
		return t;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public void setT(T t) {
		this.t = t;
	}
	@Override
	public String toString() {
		return "FenyeUtile [page=" + page + ", limit=" + limit + ", count=" + count + ", data=" + data + ", msg=" + msg
				+ ", code=" + code + ", t=" + t + "]";
	}
}
