package com.bootdo.common.excel;

import java.util.Map;

/**
 * 表头信息接口
 *
 * @author HF
 * @date 2018-06-25
 */
public interface HeaderData {

    /**
     * 获取表头map
     *
     * @return 表头map
     */
    Map<String,Object> getHeaders();

    /**
     * 返回表头有几行
     *
     * @return 表头行书
     */
    int headType();

}
