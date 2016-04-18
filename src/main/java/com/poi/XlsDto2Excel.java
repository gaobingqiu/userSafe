package com.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class XlsDto2Excel {

    /**
     * 输出xls文件
     * @param xls
     * @throws Exception
     */
    public static void xlsDto2Excel(List<XlsDto> xls) throws Exception { 
        // 获取总列数 
        int CountColumnNum = xls.size(); 
        // 创建Excel文档 
        HSSFWorkbook hwb = new HSSFWorkbook(); 
        XlsDto xlsDto = null; 
        // sheet 对应一个工作页 
        HSSFSheet sheet = hwb.createSheet("poiOut"); 
        HSSFRow firstrow = sheet.createRow(0); // 下标为0的行开始 
        HSSFCell[] firstcell = new HSSFCell[CountColumnNum]; 
        String[] names = new String[CountColumnNum]; 
        names[0] = "学号"; 
        names[1] = "姓名"; 
        names[2] = "学院"; 
        names[3] = "课程名"; 
        names[4] = "成绩"; 
        for (int j = 0; j < CountColumnNum; j++) { 
            firstcell[j] = firstrow.createCell(j); 
            firstcell[j].setCellValue(new HSSFRichTextString(names[j])); 
        } 
        for (int i = 0; i < xls.size(); i++) { 
            // 创建一行 
            HSSFRow row = sheet.createRow(i + 1); 
            // 得到要插入的每一条记录 
            xlsDto = xls.get(i); 
            for (int colu = 0; colu <= 4; colu++) { 
                // 在一行内循环 
                HSSFCell xh = row.createCell(0); 
                xh.setCellValue(xlsDto.getXh()); 
                HSSFCell xm = row.createCell(1); 
                xm.setCellValue(xlsDto.getXm()); 
                HSSFCell yxsmc = row.createCell(2); 
                yxsmc.setCellValue(xlsDto.getYxsmc()); 
                HSSFCell kcm = row.createCell(3); 
                kcm.setCellValue(xlsDto.getKcm()); 
                HSSFCell cj = row.createCell(4); 
                cj.setCellValue(xlsDto.getCj()); 
                //xlsDto.getMessage(); 
            } 
        } 
        // 创建文件输出流，准备输出电子表格 
        OutputStream out = new FileOutputStream("F:/design/poi/poiOut.xls"); 
        hwb.write(out); 
        out.close(); 
        System.out.println("数据库导出成功"); 
    }
}
