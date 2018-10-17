package com.bootdo.book.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.book.domain.BookDO;
import com.bootdo.book.service.BookService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户和书
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-10-17 10:03:12
 */
 
@Controller
@RequestMapping("/book/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping()
	@RequiresPermissions("book:book:book")
	String Book(){
	    return "book/book/book";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("book:book:book")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BookDO> bookList = bookService.list(query);
		int total = bookService.count(query);
		PageUtils pageUtils = new PageUtils(bookList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("book:book:add")
	String add(){
	    return "book/book/add";
	}

	@GetMapping("/edit/{stuBookId}")
	@RequiresPermissions("book:book:edit")
	String edit(@PathVariable("stuBookId") String stuBookId,Model model){
		BookDO book = bookService.get(stuBookId);
		model.addAttribute("book", book);
	    return "book/book/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("book:book:add")
	public R save( BookDO book){
		if(bookService.save(book)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("book:book:edit")
	public R update( BookDO book){
		bookService.update(book);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("book:book:remove")
	public R remove( String stuBookId){
		if(bookService.remove(stuBookId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("book:book:batchRemove")
	public R remove(@RequestParam("ids[]") String[] stuBookIds){
		bookService.batchRemove(stuBookIds);
		return R.ok();
	}
	
}
