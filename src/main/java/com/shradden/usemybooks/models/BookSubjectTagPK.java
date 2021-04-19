package com.shradden.usemybooks.models;

import java.io.Serializable;

public class BookSubjectTagPK implements Serializable {
	int bookid;
	String subject_name;
	public BookSubjectTagPK() {}
	public BookSubjectTagPK(int bookid, String subject_name) {
		super();
		this.bookid = bookid;
		this.subject_name = subject_name;
	}
	
	
}
