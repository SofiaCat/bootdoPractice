package com.bootdo.book.service.impl;

import com.bootdo.book.domain.BookAndChapterDo;
import com.bootdo.book.domain.BookDO;
import com.bootdo.book.service.BookService;
import com.bootdo.common.utils.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bootdo.book.dao.BookChapterDao;
import com.bootdo.book.domain.BookChapterDO;
import com.bootdo.book.service.BookChapterService;



@Service
public class BookChapterServiceImpl implements BookChapterService {
	@Autowired
	private BookChapterDao bookChapterDao;
	@Autowired
	private BookService bookService;
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
		String stuBookId = bookChapter.getStuBookId();
		System.out.println("----------"+stuBookId);
		String key = KeyGenerator.nextKey();
		bookChapter.setChapterId(key);

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

	@Override
	public List<BookAndChapterDo> listBooks(Map<String, Object> map) {
		List<BookChapterDO> list = bookChapterDao.list(map);
		List<BookAndChapterDo> bookAndChapterDos=new ArrayList<>();
		for (BookChapterDO bookChapterDO : list) {
			BookAndChapterDo bookAndChapterDo=new BookAndChapterDo();
			String stuBookId = bookChapterDO.getStuBookId();
			String chapterId = bookChapterDO.getChapterId();
			String chapterName = bookChapterDO.getChapterName();
			String heart = bookChapterDO.getHeart();
			BookDO bookDO = bookService.get(stuBookId);
			String bookName = bookDO.getBookName();
			bookAndChapterDo.setBookName(bookName);
			bookAndChapterDo.setStuBookId(stuBookId);
			bookAndChapterDo.setChapterId(chapterId);
			bookAndChapterDo.setChapterName(chapterName);
			bookAndChapterDo.setHeart(heart);
			bookAndChapterDos.add(bookAndChapterDo);
		}
		return bookAndChapterDos;
	}

}
