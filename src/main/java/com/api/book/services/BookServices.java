package com.api.book.services;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entyties.Book;

@Component
public class BookServices 
{
	private static List<Book> list = new ArrayList<>(); 
	{
		list.add(new Book(1,"Java","Vishal"));
		list.add(new Book(2,"Python","Devarsh"));
		list.add(new Book(3,"C++","Utsav"));
		list.add(new Book(4,"Android","DP"));
		list.add(new Book(5,"asd","asa"));
	}
	public List<Book>getAllBooks()
	{
		return list;
	}
	public Book getBookById(int id)
	{
		Book book = null;
		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		//stream of data mthi filter lagayu id and "e" reference variable che 
		return book;
	}
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	public void deleteBook(int bid)
	{
		list = list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
		//if apde je nkhyu and getId() same na hoi to data  collect thse list ma jse etle akhi list update thse and same hse to list ma nai nkhe etle akhi list update thse
	}
	public void updateBook(Book book,int bookId)
	{
		list.stream().map(b->{
			if(b.getId()==bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		//.map duplicate allow nai kre en mte che
		// b is reference variable of map work as a cursor
	}
}
