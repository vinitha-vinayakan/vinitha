package com.vinitha.certificaterequest.model;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.vinitha.examrequest.model.Batch;
import com.vinitha.examrequest.model.PaymentModel;
import com.vinitha.examrequest.model.Student;
import com.vinitha.requestgeneration.Excel;

public class CertificateExcel {
 

	private Excel excel=null;
	private XSSFSheet certificateSheet=null;
	private int r=10;
	private int serialNo=1;
	
	public Excel getExcel() {
		return excel;
	}
	public void setExcel(Excel excel) {
		this.excel = excel;
	}
	public CertificateExcel() {
		excel=new Excel();
	}
	public void createCertificateSheet(CertificateRequestModel certificate) throws EncryptedDocumentException, IOException {
		excel.openWorkBook("certificateRequest");
		CellStyle style=excel.getWorkbook().createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
    	certificateSheet=excel.getsheeet(0);
    	XSSFCell cell=null;
    	cell= excel.createMyBoldCell(certificateSheet.getRow(4),15);
     	cell.setCellValue(certificate.getRequisitionNo()); // error may be come
    	cell= certificateSheet.getRow(5).getCell(3);
    	cell.setCellValue(cell.getStringCellValue()+ certificate.getCourseName());
    	certificateSheet.getRow(6).getCell(3).setCellValue(certificate.getCategory());
    	 
    	for (CertificateInfoModel student : certificate.getStudentList()) {
    		 writeStudent(student);
		}
    	int i=r+1;
    	XSSFRow row=certificateSheet.getRow(i);
    	excel.createMyBoldCell(row,11).setCellValue(certificate.getPreparedBy()); 
    	row=certificateSheet.getRow(i+1);
    	excel.createMyBoldCell(row,11).setCellValue(certificate.getVerifiedBy()); 
    	excel.output();
    	
	}
	private void writeStudent(CertificateInfoModel studentInfo) {
		Student student=studentInfo.getStudent();
		Batch batch=student.getBatch();
		XSSFCell cell=null;
		certificateSheet.shiftRows(r, certificateSheet.getLastRowNum(), 1, true,true);
		XSSFRow row=certificateSheet.createRow(r);
		excel.createMyCell(row, 1).setCellValue(serialNo);;
    	serialNo++;
    	excel.createCenterCell(row,2).setCellValue(student.getNameOfStudent().toUpperCase());
    	excel.createCenterCell(row,3).setCellValue(student.getRollNo().toUpperCase());
    	
    	cell=excel.createCenterCell(row,4);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(batch.getStartDate());
    	cell=excel.createCenterCell(row,5);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(batch.getEndDate());
    	cell=excel.createCenterCell(row,6);
    	cell.getCellStyle().setDataFormat((short)14);
    	cell.setCellValue(studentInfo.getExamHeldOn());
    	excel.createCenterCell(row,7).setCellValue(studentInfo.getGrade().toUpperCase());
    	excel.createCenterCell(row,8).setCellValue(studentInfo.getResultCode());
    	excel.createCenterCell(row,9).setCellValue(studentInfo.getAttend());
    	excel.createCenterCell(row,10).setCellValue(batch.getBatchNumber().toUpperCase());
    	excel.createMyCell(row,11).setCellValue(studentInfo.getSSLCName());
    	
    	
    	XSSFCell dbaCell=excel.createCenterCell(row,14);
    	XSSFCell amountCell=excel.createCenterCell(row,12);
    	int n=1;
    	for (PaymentModel payment : student.getPayments()) {
    		if(n==1) {
    			excel.createMyCell(row,13).setCellValue(payment.getMode());
    		}
    		dbaCell.setCellValue(dbaCell.getStringCellValue()+"\n"+ payment.getDbaNumDate());
    		amountCell.setCellValue(amountCell.getStringCellValue()+"\n"+payment.getAmount());	
		}
    	excel.createCenterCell(row,11);
    	excel.createCenterCell(row,12);
    	excel.createCenterCell(row,13);
    	r++;
	}
}
