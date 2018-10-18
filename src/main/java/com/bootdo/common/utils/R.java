package com.bootdo.common.utils;

import java.util.HashMap;
import java.util.Map;



public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
		put("msg", "操作成功");
	}

	public static R error() {
		return error(1, "操作失败");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	/*
	 * 自己添加的返回结构 连接成功并且有数据
	 */
	public static R resultData(Object data) {
		R r = new R();
		r.put("code", 0);
		r.put("data", data);
		return r;
	}

	/*
	 * 自己添加的返回结构 连接成功并且有数据 data返回数据 msg 提示信息 total 返回数据的总条数
	 */
	public static R resultData(Object data, String msg, Long total) {
		R r = new R();
		r.put("code", 0);
		r.put("msg", msg);
		r.put("total", total);
		r.put("data", data);
		return r;
	}

	public static R resultData(Object data,Long total) {
		R r = new R();
		r.put("code", 0);
		r.put("msg", "请求成功");
		r.put("total", total);
		r.put("data", data);
		return r;
	}


	/*
	 * 自己添加的返回结构 连接成功并且有数据 data返回数据 msg 提示信息 total 返回数据的总条数 falg 是否加密的标识 true 加密
	 * false 不加密
	 */
	public static R resultData(Object data, String msg, Long total, boolean flag) {
		R r = new R();
		r.put("code", 0);
		r.put("msg", msg);
		r.put("total", total);
		if (flag == true) {
			try {
				//String jsonString = JSONArray.toJSONString(data);
				r.put("data",data);
			} catch (Exception e) {
			}
		}
		if (flag == false) {
			//String jsonString = JSONArray.toJSONString(data);
			r.put("data",data);
		}
		return r;
	}

	//直接返回数据
	public static R succse(Object data) {
		R r = new R();
		r.put("code", 0);
		r.put("msg", "操作成功");
		r.put("data",data);
		return r;
	}
	/*
	 * 自己添加的返回结构 连接成功没有有数据
	 */
	public static R resultNull() {
		R r = new R();
		r.put("code", 0);
		r.put("data", null);
		r.put("msg", "没有查询到相关数据!");
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
