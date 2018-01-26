/*package com.zpl.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.zpl.demo.login.pojo.Role;

*//**
 * pdf实现类
 * 
 * @author zhangpengliang
 *
 *//*
@Component
public class PDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Content-Disposition属性告诉浏览器下载文件的名称
		// Content-Disposition属性有两种类型：inline 和 attachment
		// inline ：将文件内容直接显示在页面 attachment：弹出对话框让用户下载
		response.setHeader("Content-Disposition", "inline;filename=" + 
		new String("pdf演示".getBytes(), "iso8859-1"));
		List<Role> list=(List<Role>) model.get("roles");
		
		table.setBorder(1);
		table.setWidth(80);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);//垂直居中
		
		BaseFont baseFont=BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
		Font font=new Font(baseFont, 10, Font.NORMAL, Color.blue);
		table.addCell(buildCell("id", font));
		table.addCell(buildCell("code", font));
		table.addCell(buildCell("name", font));
		for(Role r:list){
			table.addCell(buildCell(r.getRoleid(), font));
			table.addCell(buildCell(r.getRolecode(), font));
			table.addCell(buildCell(r.getRolename(), font));
		}
		document.add(table);
		
	}
	
	private Cell buildCell(String content,Font font){
		Phrase phrase=new Phrase(content, font);
		try {
			return new Cell(phrase);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
*/