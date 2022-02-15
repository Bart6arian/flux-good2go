package com.practice.webflux.mapper;

import com.practice.webflux.domain.Book;
import com.practice.webflux.domain.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto dto) {
        return new Book(
                dto.getTitle(),
                dto.getAuthor(),
                dto.getYear());
    }

    public BookDto mapToDto(final Book book) {
        return new BookDto(
                book.getTitle(),
                book.getAuthor(),
                book.getYear());
    }
}
