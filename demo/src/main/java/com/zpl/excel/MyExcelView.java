package com.zpl.excel;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.zpl.demo.login.pojo.Role;
@Component("myExcelView")
public class MyExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = "下载列表.xls";  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/ms-excel");// 文件下载  
        response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes(), "iso8859-1"));  
        OutputStream outputStream = response.getOutputStream();  
  
        HSSFWorkbook book = (HSSFWorkbook) workbook;  
        HSSFSheet sheet = book.createSheet();  
  
        HSSFRow row = sheet.createRow(0);  
        String[] headers = new String[] { "编号", "姓名", "年龄" };  
        for (int i = 0; i < headers.length; i++) {  
            row.createCell(i).setCellValue(headers[i]);  
        }  
  
        List<Role> stuList = (List<Role>) model.get("roles");  
        for (int i = 0; i < stuList.size(); i++) {  
            Role stu = stuList.get(i);  
  
            row = sheet.createRow(i + 1);  
            row.createCell(0).setCellValue(stu.getRoleid());  
            row.createCell(1).setCellValue(stu.getRolecode());  
            row.createCell(2).setCellValue(stu.getRolename());  
        }  
  
        book.write(outputStream);  
        outputStream.flush();  
        outputStream.close();  
	}

}
