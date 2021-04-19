package com.shradden.usemybooks.models;

public class Book {
	
	private BasicBook basicBook;
	private String[] examList, subjectList, authorList;
	
	public BasicBook getBasicBook() {
		return basicBook;
	}
	public void setBook(BasicBook basicBook) {
		this.basicBook = basicBook;
	}
	public String[] getExamList() {
		return examList;
	}
	public void setExamList(String[] examList) {
		this.examList = examList;
	}
	public String[] getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(String[] subjectList) {
		this.subjectList = subjectList;
	}
	public String[] getAuthorList() {
		return authorList;
	}
	public void setAuthorList(String[] authorList) {
		this.authorList = authorList;
	}
	
	

}
