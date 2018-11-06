package com.bootdo.common.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 导出excel
 *
 * @author HF
 * @date 2018-06-25
 */
public class ExportExcel {

    private static Logger LOGGER = LoggerFactory.getLogger(ExportExcel.class);

    private static final String HORIZONTAL = "-";

    private static final Integer NUM_1 = 1;

    private static final Integer NUM_2 = 2;

    /**
     * 将数据导出excel
     *
     * @param headers  数据标题
     * @param dataMap  数据实体
     * @param fileName 文件名称
     * @param response 响应
     */
    public static void exportExcelDownload(HeaderData headers, List<Map<String, Object>> dataMap, String fileName, HttpServletResponse response) {
        XSSFWorkbook workbook = createExcel(headers, dataMap, fileName);

        try {
            getExportedFile(workbook, fileName, response);
        } catch (Exception e) {
            LOGGER.error("导出excel失败：" + e);
        }
    }

    /**
     * 方法说明: 指定路径下生成EXCEL文件
     */
    private static void getExportedFile(XSSFWorkbook workbook, String name, HttpServletResponse response) throws Exception {
        BufferedOutputStream fos = null;
        try {
            String fileName = name + ".xlsx";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
            fos = new BufferedOutputStream(response.getOutputStream());
            workbook.write(fos);
        } catch (Exception e) {
            LOGGER.error("下载失败：" + e);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 生成一个excel
     *
     * @param headers  excel头
     * @param dataMap  数据
     * @param fileName 名称
     * @return excel数据
     */
    public static XSSFWorkbook createExcel(HeaderData headers, List<Map<String, Object>> dataMap, String fileName) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        addOneSheet(workbook, headers, dataMap, fileName);
        return workbook;
    }

    public static void addOneSheet(XSSFWorkbook workbook, HeaderData headers,
                                   List<Map<String, Object>> dataMap, String sheetName) {

        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 产生表格标题行
        Map<String, Object> head = headers.getHeaders();

        List<String> headerList = new ArrayList<>();


        int dataIndex = 0;
        // 设置头信息
        if (headers.headType() == NUM_1) {
            createOneColsHeader(sheet,head,headerList);

        } else if (headers.headType() == NUM_2) {
            createTowColsHeader(sheet, head, headerList);
            dataIndex = 1;
        }

        // 填充数据
        if (!CollectionUtils.isEmpty(dataMap)) {
            for (Map m : dataMap) {
                int len = headerList.size();
                dataIndex++;
                XSSFRow row = sheet.createRow(dataIndex);
                for (int i = 0; i < len; i++) {
                    XSSFCell cell = row.createCell(i);
                    Object ob = m.get(headerList.get(i));
                    if (ob != null) {
                        String val = String.valueOf(ob);
                        cell.setCellValue(val);
                    } else {
                        cell.setCellValue(HORIZONTAL);
                    }
                }
            }
        }
    }

    /**
     *
     *
     * @param sheet excel sheet
     * @param headerMap 表头
     * @param headerList 头列表
     */
    private static void createTowColsHeader(XSSFSheet sheet, Map<String, Object> headerMap, List<String> headerList) {

        Integer columns = 0;
        XSSFRow rowsOne = sheet.createRow(0);
        XSSFRow rowsTwo = sheet.createRow(1);
        for (String str : headerMap.keySet()) {
            Object ob = headerMap.get(str);
            XSSFCell rowCell = rowsOne.createCell(columns);
            rowCell.setCellValue(str);
            Map<String, Object> second = (Map<String, Object>) ob;
            columns = setColumns(rowsTwo,second,headerList,columns);
        }
    }

    private static void createOneColsHeader(XSSFSheet sheet, Map<String, Object> headerMap,
                                            List<String> headerList) {
        int columns = 0;
        XSSFRow rowsOne = sheet.createRow(0);
        setColumns(rowsOne,headerMap,headerList,columns);

    }

    private static Integer setColumns(XSSFRow rows,Map<String, Object> headerMap,List<String> headerList,int columns){
        for (String str : headerMap.keySet()) {
            XSSFCell cell = rows.createCell(columns);
            String val = (String) headerMap.get(str);
            cell.setCellValue(val);
            headerList.add(str);
            columns++;
        }
        return columns;

    }
}

