package com.bootdo.book.service;

import com.bootdo.book.domain.BookChapterDO;

import java.util.List;
import java.util.Map;

/**
 * 书和章节
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:18
 */
public interface BookChapterService {
	
	BookChapterDO get(String chapterId);
	
	List<BookChapterDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookChapterDO bookChapter);
	
	int update(BookChapterDO bookChapter);
	
	int remove(String chapterId);
	
	int batchRemove(String[] chapterIds);
}
