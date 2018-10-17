package com.bootdo.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.book.dao.BookDao;
import com.bootdo.book.domain.BookDO;
import com.bootdo.book.service.BookService;



@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	@Override
	public BookDO get(String stuBookId){
		return bookDao.get(stuBookId);
	}
	
	@Override
	public List<BookDO> list(Map<String, Object> map){
		return bookDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bookDao.count(map);
	}
	
	@Override
	public int save(BookDO book){
		return bookDao.save(book);
	}
	
	@Override
	public int update(BookDO book){
		return bookDao.update(book);
	}
	
	@Override
	public int remove(String stuBookId){
		return bookDao.remove(stuBookId);
	}
	
	@Override
	public int batchRemove(String[] stuBookIds){
		return bookDao.batchRemove(stuBookIds);
	}
	
}
