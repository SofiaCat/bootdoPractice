package com.bootdo.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.book.dao.BookChapterDao;
import com.bootdo.book.domain.BookChapterDO;
import com.bootdo.book.service.BookChapterService;



@Service
public class BookChapterServiceImpl implements BookChapterService {
	@Autowired
	private BookChapterDao bookChapterDao;
	
	@Override
	public BookChapterDO get(String chapterId){
		return bookChapterDao.get(chapterId);
	}
	
	@Override
	public List<BookChapterDO> list(Map<String, Object> map){
		return bookChapterDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bookChapterDao.count(map);
	}
	
	@Override
	public int save(BookChapterDO bookChapter){
		return bookChapterDao.save(bookChapter);
	}
	
	@Override
	public int update(BookChapterDO bookChapter){
		return bookChapterDao.update(bookChapter);
	}
	
	@Override
	public int remove(String chapterId){
		return bookChapterDao.remove(chapterId);
	}
	
	@Override
	public int batchRemove(String[] chapterIds){
		return bookChapterDao.batchRemove(chapterIds);
	}
	
}
