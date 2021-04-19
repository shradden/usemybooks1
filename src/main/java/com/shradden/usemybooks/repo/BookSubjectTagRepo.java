package com.shradden.usemybooks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shradden.usemybooks.models.BookSubjectTag;

public interface BookSubjectTagRepo extends JpaRepository<BookSubjectTag, Integer>{

}
