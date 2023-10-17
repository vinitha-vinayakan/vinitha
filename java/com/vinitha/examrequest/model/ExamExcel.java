package com.vinitha.examrequest.model;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.vinitha.requestgeneration.Excel;

public class ExamExcel {

	private Excel excel=null;
	private XSSFSheet examSheet=null;
	private int r=12;
	private int serialNo=1;
	
	public Excel getExcel() {
		return excel;
	}
	public void setExcel(Excel excel) {
		this.excel = excel;
	}
	public ExamExcel() {
		excel=new Excel();
	}
	public void createExamSheet(ExamRequestModel exam) throws EncryptedDocumentException, IOException {
		excel.openWorkBook("ExamRequest");
    	 examSheet=excel.getsheeet(0);
    	 XSSFCell cell=null;
    	 examSheet.getRow(3).getCell(12).setCellValue(exam.getDate());
    	 examSheet.getRow(4).getCell(12).setCellValue(exam.getExamRequisitionNo());
    	 examSheet.getRow(5).getCell(12).setCellValue(exam.getSemesterNo());
    	 examSheet.getRow(5).getCell(3).setCellValue(exam.getCourseName().toUpperCase());
    	 examSheet.getRow(6).getCell(3).setCellValue(exam.getCourseCode().toUpperCase());
    	 
    	 for (StudentInfoModel student : exam.getExamStudentList()) {
    		 writeStudent(student);
		}
    	int i=r+1;
    	XSSFRow row=examSheet.getRow(i);
    	cell= excel.createMyBoldCell(row, 3);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(exam.getProposedExamDate()); 
    	i=i+5;
    	row=examSheet.getRow(i);
    	excel.createMyBoldCell(row, 3).setCellValue(exam.getPreparedBy()); 
    	row= examSheet.getRow(i+1);
    	excel.createMyBoldCell(row, 3).setCellValue(exam.getVerifiedBy()); 
    	excel.output();
    	
	}
	private void writeStudent(StudentInfoModel studentInfo) {
		Student student=studentInfo.getStudent();
		Batch batch=student.getBatch();
		XSSFCell cell=null;
		examSheet.shiftRows(r, examSheet.getLastRowNum(), 1, true,true);
		XSSFRow row=examSheet.createRow(r);
		excel.createMyCell(row, 1).setCellValue(serialNo);;
    	serialNo++;
    	excel.createCenterCell(row,2).setCellValue(student.getNameOfStudent().toUpperCase());
    	excel.createCenterCell(row,3).setCellValue(student.getRollNo().toUpperCase());
    	excel.createCenterCell(row,4).setCellValue(batch.getBatchNumber().toUpperCase());
    	cell=excel.createCenterCell(row,5);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(batch.getStartDate());
    	cell=excel.createCenterCell(row,6);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(batch.getEndDate());
    	excel.createMyCell(row,7).setCellValue(batch.getStudentsInBatch());
    	excel.createMyCell(row,8).setCellValue(studentInfo.getStudentsForExam());
    	XSSFCell dbaCell=excel.createCenterCell(row,9);
    	XSSFCell amountCell=excel.createCenterCell(row,10);
    	for (PaymentModel payment : student.getPayments()) {
    		dbaCell.setCellValue(dbaCell.getStringCellValue()+"\n"+ payment.getDbaNumDate());
    		amountCell.setCellValue(amountCell.getStringCellValue()+"\n"+payment.getAmount());	
		}
    	excel.createCenterCell(row,11).setCellValue(studentInfo.getBalance());
    	excel.createCenterCell(row,12).setCellValue(studentInfo.getNoDueClearance());
    	excel.createCenterCell(row,13).setCellValue(studentInfo.getRemarks()); 
    	r++;
	}
}
