package com.shradden.usemybooks.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shradden.usemybooks.models.BasicBook;
import com.shradden.usemybooks.models.Book;
import com.shradden.usemybooks.models.BookExamTag;
import com.shradden.usemybooks.models.BookSubjectTag;
import com.shradden.usemybooks.repo.BookExamTagRepo;
import com.shradden.usemybooks.repo.BasicBookRepo;
import com.shradden.usemybooks.repo.BookSubjectTagRepo;

@RestController
public class BookController {
	
	@Autowired
	BasicBookRepo repo;
	
	@Autowired
	BookExamTagRepo examTagRepo;
	
	@Autowired
	BookSubjectTagRepo subjectTagRepo;
	
	
	@GetMapping("books")
	public List<BasicBook> getBooks()
	{
		List<BasicBook> books = repo.findAll();
		return books;
	}
	
	@GetMapping("book/{book-id}")
	public BasicBook getBook(@PathVariable("book-id") int id)
	{
		BasicBook book = repo.findById(id).orElse(null);
		return book;
	}
	
	@PostMapping("books/add")
	public boolean addBook(@RequestBody Book book)
	{
		repo.save(book.getBasicBook());
		String[] arr = book.getExamList();
		for(int i=0;i<arr.length;i++)
		{
			examTagRepo.save(new BookExamTag(book.getBasicBook().getBookid(), arr[i]));
		}
		arr=book.getSubjectList();
		for(int i=0;i<arr.length;i++)
		{
			subjectTagRepo.save(new BookSubjectTag(book.getBasicBook().getBookid(), arr[i]));
		}
		
		
		
		return true;
	}
	
	@PostMapping("books/{book-id}/update")
	public boolean updateBook(@RequestBody Book book, @PathVariable("book-id") int bookid)
	{
		BasicBook bb = repo.findById(bookid).orElse(null);
		if(bb==null)
		{
			System.out.println("No such books found");
			return false;
		}
		else {
		
		BasicBook temp = book.getBasicBook();
		bb = temp;
		repo.save(bb);
//		bb.setBookid(book.getBasicBook().getBookid());
//		bb.setBookname(book.getBasicBook().getBookname());
//		bb.setPrice(book.getBasicBook().getPrice());
//		bb.setPublisher(book.getBasicBook().getPublisher());
//		bb.setLocation(book.getBasicBook().getLocation());
//		bb.setEdition(book.getBasicBook().getEdition());
//		bb.setUserid(book.getBasicBook().getUserid());
//		
//		repo.save(bb);
		String[] arr = book.getExamList();
		for(int i=0;i<arr.length;i++)
		{
			examTagRepo.save(new BookExamTag(bookid, arr[i]));
		}
		arr=book.getSubjectList();
		for(int i=0;i<arr.length;i++)
		{
			subjectTagRepo.save(new BookSubjectTag(bookid, arr[i]));
		}
		
		
		return true;
		}
		
	}
	
	@GetMapping("books/{user-id}/delete")
	public boolean deleteBook(@PathVariable("user-id") int id)
	{
		repo.deleteById(id);
		return true;
	}
	
	@GetMapping("exam-tags")
	public List<BookExamTag> getExamTags()
	{
		List<BookExamTag> list = examTagRepo.findAll();
		return list;
	}
	
	@GetMapping("subject-tags")
	public List<BookSubjectTag> getSubjectTags()
	{
		List<BookSubjectTag> list = subjectTagRepo.findAll();
		return list;
	}
	
	

}
