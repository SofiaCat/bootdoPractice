package com.bootdo.book.service.impl;

import com.bootdo.common.utils.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.book.dao.BookDao;
import com.bootdo.book.domain.BookDO;
import com.bootdo.book.service.BookService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


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
		String id = KeyGenerator.nextKey();
		book.setStuBookId(id);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Long userId = (Long) request.getSession().getAttribute("user_id");
		book.setUserId(userId);
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
