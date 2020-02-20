package com.application.CrudApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.CrudApp.BookDTO.BookDTO;
import com.application.CrudApp.Model.Book;
import com.application.CrudApp.Repository.BookRepository;


@Service
public class BookService{
	public final BookRepository bookRepo;

	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book toEntity(BookDTO dto) {
		Book model= new Book();
		model.setId(dto.getId());
		model.setBookName(dto.getBookName());
		model.setPublisher(dto.getPublisher());
		return model;
	}
	
	public BookDTO toDTO (Book model){
		BookDTO dto=new BookDTO();
		dto.setId(model.getId());
		dto.setBookName(model.getBookName());
		dto.setPublisher(model.getPublisher());
		return dto;
	}
	
	public BookDTO save(BookDTO dto){
		
		return toDTO(bookRepo.save(toEntity(dto)));
	}
	
	public BookDTO update(Long id,BookDTO dto){
		Optional<Book> data=bookRepo.findById(id);
		Book oldata=new Book();
		if(data.isPresent()) {
			oldata.setId(id);
			oldata.setBookName(dto.getBookName());
			oldata.setPublisher(dto.getPublisher());
			return toDTO(bookRepo.save(oldata));
		}
		return null;
	}
	
	public Boolean delete(Long id) {
		Optional<Book> data=bookRepo.findById(id);
		if(data.isPresent()) {
		bookRepo.deleteById(id);
		return true;
		}
		 return false;
	}
	
	public List<Book>getAll() {
		List<Book> data=bookRepo.findAll();
		if(data!=null) {
			return data;
		}
		return null;
	}
}
