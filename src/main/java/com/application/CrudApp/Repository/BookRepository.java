package com.application.CrudApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.CrudApp.Model.Book;


public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByBookName(String bookName);
	
}
