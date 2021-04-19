package com.shradden.usemybooks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shradden.usemybooks.models.BasicBook;


public interface BasicBookRepo extends JpaRepository<BasicBook, Integer>{

}
