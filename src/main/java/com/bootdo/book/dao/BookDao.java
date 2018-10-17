package com.bootdo.book.dao;

import com.bootdo.book.domain.BookDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户和书
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:12
 */
@Mapper
public interface BookDao {

	BookDO get(String stuBookId);
	
	List<BookDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookDO book);
	
	int update(BookDO book);
	
	int remove(String stu_book_id);
	
	int batchRemove(String[] stuBookIds);
}
