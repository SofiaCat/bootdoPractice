package com.bootdo.common.excel.header;

import com.bootdo.common.excel.HeaderData;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 学生数据表头
 *
 * @author HF
 * @date 2018-07-18
 */
public class StudentDataHeader implements HeaderData {



    @Override
    public Map<String, Object> getHeaders() {
        Map<String, Object> result = new LinkedHashMap<>(16);

        Map<String, String> mapOne = new LinkedHashMap<>(16);
        mapOne.put("项目部", "项目部");
        result.put(" ", mapOne);
        Map<String, String> mapTwo = new LinkedHashMap<>(16);
        mapTwo.put("关联课程数", "关联课程数");
        result.put("",mapTwo);

        return result;
    }

    @Override
    public int headType() {
        return 2;
    }
}
