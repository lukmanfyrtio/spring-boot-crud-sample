package com.application.CrudApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.CrudApp.JsonMessage;
import com.application.CrudApp.BookDTO.BookDTO;
import com.application.CrudApp.Model.Book;
import com.application.CrudApp.Service.BookService;


@RestController
@RequestMapping("/api")
public class BookController {
	public final BookService bookService;

@Autowired
public BookController(BookService bookService) {
	this.bookService=bookService;
}



@RequestMapping(value="/add",method=RequestMethod.POST)
public @ResponseBody JsonMessage add(@RequestBody BookDTO dto){
	BookDTO save=bookService.save(dto);
	if(save!=null) {
	return JsonMessage.showInfoMessage("Data Berhasil Disimpan",save);
	}else{
	return JsonMessage.showInfoMessage("Data Gagal Disimpan",save);
	}
	
} 

@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
public @ResponseBody JsonMessage update(@PathVariable("id")Long id ,@RequestBody BookDTO dto){
	BookDTO save=bookService.update(id, dto);
	if(save!=null) {
	return JsonMessage.showInfoMessage("Data Berhasil Di Update",save);
	}else{
	return JsonMessage.showInfoMessage("Data Gagal Di Update",save);
	}
} 

@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
public @ResponseBody JsonMessage delete(@PathVariable("id")Long id) {
	if(bookService.delete(id)) {
		return JsonMessage.showInfoMessage("Data Berhasil Di Hapus",null);
	}
	    return JsonMessage.showInfoMessage("Data Gagal Di Hapus",null);
}

@RequestMapping(value="/list",method=RequestMethod.GET)
public List<Book> getList(){
	return bookService.getAll();
}


	
}
