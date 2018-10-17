package com.bootdo.book.service;

import com.bootdo.book.domain.BookDO;

import java.util.List;
import java.util.Map;

/**
 * 用户和书
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:12
 */
public interface BookService {
	
	BookDO get(String stuBookId);
	
	List<BookDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BookDO book);
	
	int update(BookDO book);
	
	int remove(String stuBookId);
	
	int batchRemove(String[] stuBookIds);
}
