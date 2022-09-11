package com.api.book.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.entyties.Book;
import com.api.book.services.BookServices;

@RestController
public class BookController 
{
	@Autowired
	private BookServices bookService;
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return this.bookService.getAllBooks();
	}
	@GetMapping("/books/{id}")
	//for one reocrd
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	@PostMapping("/book")
	//for add book
	public Book addBook(@RequestBody Book book) 
	{
			Book b = this.bookService.addBook(book);
			return b;
	}
	@DeleteMapping("/books/{bookId}")
	//for delete one record
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookService.deleteBook(bookId);
	}
	@PutMapping("/books/{bookId}")
	//for update and even if it does not exits than creates new one
	public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.bookService.updateBook(book,bookId);
	}
	
}
