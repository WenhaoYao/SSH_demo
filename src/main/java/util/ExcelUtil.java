package util;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExcelUtil {
	
	/**
	 * 
	 * @Title: generateExcel
	 * @Description: 通过数据库查询的集合和设定的Excel头部生成Excel文件
	 * @param users 数据库查询的所有用户的集合
	 * @param head Excel文件的头部信息
	 * @return
	 * @throws Exception
	 * @return: Workbook
	 */
	public static <T> Workbook generateExcel(List<T> users, String[] head) throws Exception {
		int rownum = 0;
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(rownum++);
		for (int i = 0; i < head.length; i++) {
			row.createCell(i).setCellValue(head[i]);
		}
		for (T user : users) {
			row = sheet.createRow(rownum++);
			Object[] objects = ReflectUtil.getEntityValue(user);
			for (int i = 0; i < objects.length; i++) {
				row.createCell(i).setCellValue(objects[i].toString());
			}
		}
		return workbook;
	}
	
	/**
	 * 
	 * @Title: fomatCell
	 * @Description: 对Excel表格中的数据进行格式化
	 * @param cell
	 * @return
	 * @return: String
	 */
	public static String fomatCell(Cell cell) {
		HSSFDataFormatter formatter = null;
		Object cellValue = null;
		switch (cell.getCellTypeEnum()) {
		case NUMERIC:
			formatter = new HSSFDataFormatter();
			formatter.formatCellValue(cell);
			break;
		case BLANK:cellValue = "_blank";break;
		case BOOLEAN:cellValue = cell.getBooleanCellValue();break;
		case ERROR:cellValue = cell.getErrorCellValue();break;
		case FORMULA:break;
		case STRING:cellValue = cell.getRichStringCellValue();break;
		default:
			cellValue = "未知";
			break;
		}
		return String.valueOf(cellValue);
	}
	
	/**
	 * 
	 * @Title: getWorkBook
	 * @Description: 通过上传的文件判断后缀名的格式判断生成的workbook的类型
	 * @param input
	 * @param fileExtName
	 * @return
	 * @throws IOException
	 * @return: Workbook
	 */
	public static Workbook getWorkBook(InputStream input, String fileExtName) throws IOException {
		Workbook workbook;
		POIFSFileSystem fileSystem = null;
		if("xls".equals(fileExtName)) {
			try {
				fileSystem = new POIFSFileSystem(input);
				workbook = new HSSFWorkbook(fileSystem);
			} finally {
				fileSystem.close();
			}
		} else if("xlsx".equals(fileExtName)) {
			workbook = new XSSFWorkbook(input);
		} else {
			throw new RuntimeException("后缀名为空");
		}
		return workbook;
	}

	public static Workbook getWorkBook(String filedir) throws IOException {
		Workbook workbook = null;
		POIFSFileSystem fileSystem = null;
		InputStream inputStream = new FileInputStream(filedir);
//		得到路径的后缀名
		String fileExtName = filedir.substring(filedir.lastIndexOf(".") + 1);
		if ("xls".equals(fileExtName)) {
			fileSystem = new POIFSFileSystem(inputStream);
			workbook = new HSSFWorkbook(fileSystem);
		} else if ("xlsx".equals(fileExtName)) {
			workbook = new XSSFWorkbook(inputStream);
		} else {
			throw new RuntimeException("后缀名为空");
		}
		return workbook;
	}

}
