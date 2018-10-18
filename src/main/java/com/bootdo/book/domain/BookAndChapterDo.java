package com.bootdo.book.domain;

import java.io.Serializable;

/**
 * 图书管理的包装类
 */
public class BookAndChapterDo implements Serializable {
    // 用户名
    private String username;
    //用户id
    private Long userId;
    //书名
    private String bookName;
    //ID
    private String chapterId;
    //图书 id
    private String stuBookId;
    //章节名
    private String chapterName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getStuBookId() {
        return stuBookId;
    }

    public void setStuBookId(String stuBookId) {
        this.stuBookId = stuBookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    //读书心得
    private String heart;
}
