package com.shradden.usemybooks.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="booksubjecttags")
@IdClass(BookSubjectTagPK.class)
public class BookSubjectTag implements Serializable{
	
	
	@Id
	int bookid;
	@Id
	String subject_name;
	
	public BookSubjectTag() {}
	
	public BookSubjectTag(int bookid, String subject_name) {
		super();
		
		this.bookid = bookid;
		this.subject_name = subject_name;
	}

	

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
}
