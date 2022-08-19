package com.infy.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.dto.BookDTO;
import com.infy.exception.InfyBookException;

public class BookServiceImpl implements BookService {

	@Override
	public BookDTO getBookDetails(Integer bookId) throws InfyBookException {
		return null;
	}

	@Override
	public void addBook(BookDTO bookDTO) throws InfyBookException {
		
	}

	@Override
	public List<BookDTO> getBookByAuthorName(String authorName) throws InfyBookException {
		return null;
	}

	@Override
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws InfyBookException {
		return null;
	}

	@Override
	public List<BookDTO> getBookLessThanPrice(Integer price) throws InfyBookException {
		return null;
	}

	@Override
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws InfyBookException {
		return null;
	}

	@Override
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws InfyBookException {
		return null;
	}

	@Override
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws InfyBookException {
		return null;
	}

	@Override
	public void updateBookPrice(Integer bookId, Integer price) throws InfyBookException {
		
	}

	@Override
	public void deleteBook(Integer bookId) throws InfyBookException {
		
	}


	
}
