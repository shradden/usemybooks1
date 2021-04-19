package com.shradden.usemybooks.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="bookexamtags")
@IdClass(BookExamTagPK.class)
public class BookExamTag implements Serializable{
	@Id
	int bookid;
	@Id
	String exam_name;
	
	public BookExamTag() {}
	
	public BookExamTag(int bookid, String exam_name) {
		super();
		this.bookid = bookid;
		this.exam_name = exam_name;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	
	
}
