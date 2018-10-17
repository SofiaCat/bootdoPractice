package com.bootdo.book.dao;

import com.bootdo.book.domain.BookChapterDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 书和章节
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:18
 */
@Mapper
public interface BookChapterDao {

	BookChapterDO get(String chapterId);
	
	List<BookChapterDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookChapterDO bookChapter);
	
	int update(BookChapterDO bookChapter);
	
	int remove(String chapter_id);
	
	int batchRemove(String[] chapterIds);
}
