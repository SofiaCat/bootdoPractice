package com.bootdo.common.excel.header;

import com.bootdo.book.domain.BookAndChapterDo;
import com.bootdo.common.excel.HeaderData;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 学生数据表头
 *
 * @author HF
 * @date 2018-07-18
 */
public class BookDataHeader implements HeaderData {
    private final BookAndChapterDo bookAndChapterDo;

    public BookDataHeader(BookAndChapterDo bookAndChapterDo) {
        this.bookAndChapterDo = bookAndChapterDo;
    }


    @Override
    public Map<String, Object> getHeaders() {
        Map<String, Object> result = new LinkedHashMap<>(16);

        Map<String, String> mapOne = new LinkedHashMap<>(16);
        mapOne.put("用户", "用户");
        mapOne.put("书名", "书名");
        result.put(" ", mapOne);

        return result;
    }

    @Override
    public int headType() {
        return 2;
    }
}
