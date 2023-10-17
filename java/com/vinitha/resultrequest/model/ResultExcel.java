package com.vinitha.resultrequest.model;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.vinitha.requestgeneration.Excel;

public class ResultExcel {
	private Excel excel=null;
	
    public ResultExcel(){
		super();
		excel=new Excel();
	}
	public void basicInformation(ResultModel result) throws EncryptedDocumentException, IOException {
    	excel.openWorkBook("ResultSheet");
    	XSSFSheet markSheet=excel.getsheeet(0);
    
    Cell cell = null;
    
    markSheet.getRow(1).getCell(0). setCellValue(result.getCourseName().toUpperCase()+" - "
                                                 +result.getCourseCode().toUpperCase());
    if(result.getExamHeldIn()!=null) {
    	cell= markSheet.getRow(2).getCell(0);
        cell.setCellValue(cell.getStringCellValue()+" "+result.getExamHeldIn().toUpperCase());
    }
    int r=7;
    int serialNo=1;
    for (StudentMarkModel mark : result.getStudentList()) {
    	StudentResult studentResult= new StudentResult(mark);
    	
    	markSheet.shiftRows(r, markSheet.getLastRowNum(), 1, true,true);
    	XSSFRow row=markSheet.createRow(r);
    	
    	excel.createMyCell(row, 0).setCellValue(serialNo);;
    	serialNo++;
    	
    	excel.createMyCell(row, 1).setCellValue(mark.getStudentId().toUpperCase());
    	excel.createMyCell(row, 2).setCellValue(mark.getStudentName().toUpperCase());
    	excel.createMyCell(row, 3).setCellValue(mark.getTheoryMark());
    	excel.createMyCell(row, 4).setCellValue(mark.getPracticalMark());
    	excel.createMyCell(row, 5).setCellValue(studentResult.totalMark());
    	excel.createMyCell(row, 6).setCellValue(studentResult.result());
    	
        r++;
    
    }
    
    int i=7+result.getStudentList().size()+4;
    excel.createMyBoldCell(markSheet.getRow(i),2).setCellValue(result.getEnteredBy());
	excel.createMyBoldCell( markSheet.getRow(i+3),2).setCellValue(result.getVerifiedBy());
    excel.output();
    }  
    public void resultSheet(ResultModel result) throws EncryptedDocumentException, IOException {
    	
    	XSSFSheet markSheet=excel.getsheeet(1);
    	Cell cell = null;
    	markSheet.getRow(1).getCell(0)
    	 .setCellValue(result.getCourseName().toUpperCase()+" - "
    	               +result.getCourseCode().toUpperCase());
    	 if(result.getExamHeldIn()!=null) {
    	    	cell= markSheet.getRow(2).getCell(0);
    	        cell.setCellValue(cell.getStringCellValue()+" "+result.getExamHeldIn().toUpperCase());
    	    }
    	int r=7;
    	int serialNo=1;
    	for (StudentMarkModel mark : result.getStudentList()) {
    	    	StudentResult studentResult= new StudentResult(mark);
    	    	
    	    	markSheet.shiftRows(r, markSheet.getLastRowNum(), 1, true,true);
    	    	XSSFRow row=markSheet.createRow(r);
    	    	
    	    	excel.createMyCell(row, 0).setCellValue(serialNo);
    	    	serialNo++;
    	    	excel.createMyCell(row, 1).setCellValue(mark.getStudentId().toUpperCase());
    	    	excel.createMyCell(row, 2).setCellValue(mark.getStudentName().toUpperCase());
    	    	excel.createMyCell(row, 3).setCellValue(studentResult.totalMark());
    	    	cell=excel.createMyCell(row, 4);
    	        CellStyle style= cell.getCellStyle();
    	    	style.setDataFormat(excel.getWorkbook().createDataFormat()
    	    			.getFormat(BuiltinFormats.getBuiltinFormat(9)));
    	    	cell.setCellValue(studentResult.totalMark()/100.0f);
    	    	excel.createMyCell(row, 5).setCellValue(studentResult.grade());
    	        r++;   
    	 }
    	 
    	int i=7+result.getStudentList().size()+4;
    	excel.createMyBoldCell(markSheet.getRow(i),2).setCellValue(result.getEnteredBy());
    	excel.createMyBoldCell( markSheet.getRow(i+3),2).setCellValue(result.getVerifiedBy());
    	excel.output();
    	    
    }
	public Excel getExcel() {
		return excel;
	}
	public void setExcel(Excel excel) {
		this.excel = excel;
	}
    
    

}
