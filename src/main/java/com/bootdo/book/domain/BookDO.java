package com.bootdo.book.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户和书
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:12
 */
public class BookDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private String stuBookId;
	//用户id
	private Long userId;
	//书名
	private String bookName;

	/**
	 * 设置：ID
	 */
	public void setStuBookId(String stuBookId) {
		this.stuBookId = stuBookId;
	}
	/**
	 * 获取：ID
	 */
	public String getStuBookId() {
		return stuBookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置：书名
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * 获取：书名
	 */
	public String getBookName() {
		return bookName;
	}
}
