package com.practice.webflux;


import com.practice.webflux.domain.Book;
import com.practice.webflux.domain.BookDto;
import com.practice.webflux.mapper.BookMapper;
import reactor.core.publisher.Flux;

public class FirstFluxCheck {

    public static void main(String[] args) {
        Book book1 = new Book("Title1", "Author1", 1999);
        Book book2 = new Book("Title2", "Author2", 2001);

        BookMapper mapper = new BookMapper();
        BookDto dto1 = mapper.mapToDto(book1);
        BookDto dto2 = mapper.mapToDto(book2);

        Flux<BookDto> fluxbookDto = Flux.just(dto1, dto2);
        fluxbookDto.subscribe(System.out::println, FirstFluxCheck::handleException);
    }

    private static void handleException(Throwable e) {
        System.out.println("Error : " + e);
    }
}
