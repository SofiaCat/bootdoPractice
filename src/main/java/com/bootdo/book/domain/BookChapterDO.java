package com.bootdo.book.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 书和章节
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:18
 */
public class BookChapterDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private String chapterId;
	//图书 id 
	private String stuBookId;
	//章节名
	private String chapterName;
	//读书心得
	private String heart;

	/**
	 * 设置：ID
	 */
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	/**
	 * 获取：ID
	 */
	public String getChapterId() {
		return chapterId;
	}
	/**
	 * 设置：图书 id 
	 */
	public void setStuBookId(String stuBookId) {
		this.stuBookId = stuBookId;
	}
	/**
	 * 获取：图书 id 
	 */
	public String getStuBookId() {
		return stuBookId;
	}
	/**
	 * 设置：章节名
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	/**
	 * 获取：章节名
	 */
	public String getChapterName() {
		return chapterName;
	}
	/**
	 * 设置：读书心得
	 */
	public void setHeart(String heart) {
		this.heart = heart;
	}
	/**
	 * 获取：读书心得
	 */
	public String getHeart() {
		return heart;
	}
}
