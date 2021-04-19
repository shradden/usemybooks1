package com.shradden.usemybooks.models;

import java.io.Serializable;



public class BookExamTagPK implements Serializable {
	
	
	protected int bookid;
	protected String exam_name;
	
	public BookExamTagPK() {}
	public BookExamTagPK(int bookid, String exam_name) {
		super();
		this.bookid = bookid;
		this.exam_name = exam_name;
	}
	
}
