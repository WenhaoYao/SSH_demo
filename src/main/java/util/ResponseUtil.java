package util;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ResponseUtil {
	
	/**
	 * 
	 * @Title: write
	 * @Description: ajax异步响应界面
	 * @param response
	 * @param o
	 * @throws IOException
	 * @return: void
	 */
	public static void write(HttpServletResponse response, Object o) throws IOException {
		response.setContentType("application/x-www-form-urlencoded;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(o.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * 
	 * @Title: exportExcel
	 * @Description: ajax输出excel文件
	 * @param response
	 * @param workbook
	 * @param filename
	 * @throws Exception
	 * @return: void
	 */
	public static void exportExcel(HttpServletResponse response, Workbook workbook, String filename) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1"));
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
	}
}
