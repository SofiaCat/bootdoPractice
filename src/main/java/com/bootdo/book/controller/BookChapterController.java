package com.bootdo.book.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.book.domain.BookAndChapterDo;
import com.bootdo.book.service.BookService;
import com.bootdo.common.utils.JSONUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.book.domain.BookChapterDO;
import com.bootdo.book.service.BookChapterService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 书和章节
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:18
 */
 
@Controller
@RequestMapping("/book/bookChapter")
public class BookChapterController {
	@Autowired
	private BookChapterService bookChapterService;
	@Autowired
	private BookService bookService;
	@GetMapping()
	//@RequiresPermissions("book:bookChapter:bookChapter")
	String BookChapter(){
	    return "book/bookChapter/bookChapter";
	}
	
	@ResponseBody
	@GetMapping("/list")
	//@RequiresPermissions("book:bookChapter:bookChapter")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		//List<BookChapterDO> bookChapterList = bookChapterService.list(query);
		List<BookAndChapterDo> bookAndChapterDos = bookChapterService.listBooks(query);
		int total = bookChapterService.count(query);
		PageUtils pageUtils = new PageUtils(bookAndChapterDos, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("book:bookChapter:add")
	String add(){
	    return "book/bookChapter/add";
	}

	@GetMapping("/edit/{chapterId}")
	//@RequiresPermissions("book:bookChapter:edit")
	String edit(@PathVariable("chapterId") String chapterId,Model model){
		BookChapterDO bookChapter = bookChapterService.get(chapterId);
		model.addAttribute("bookChapter", bookChapter);
	    return "book/bookChapter/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("book:bookChapter:add")
	public R save( @RequestBody BookChapterDO bookChapter){
		if(bookChapterService.save(bookChapter)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	//@RequiresPermissions("book:bookChapter:edit")
	public R update(@RequestBody BookChapterDO bookChapter){
		int update = bookChapterService.update(bookChapter);
		if (update>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	//@RequiresPermissions("book:bookChapter:remove")
	public R remove( String chapterId){
		if(bookChapterService.remove(chapterId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	//@RequiresPermissions("book:bookChapter:batchRemove")
	public R remove(@RequestParam("ids[]") String[] chapterIds){
		bookChapterService.batchRemove(chapterIds);
		return R.ok();
	}

	@RequestMapping("/selectBook")
	@ResponseBody
	public R  selectBook(){
		Map<String,Object>map=new HashMap();
		HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Long userId = (Long) request.getSession().getAttribute("user_id");
		map.put("userId",userId);
		List<BookAndChapterDo> list = bookService.list(map);
		return R.succse(list);
	}
}
