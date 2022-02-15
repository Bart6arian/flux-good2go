package com.practice.webflux.controller;

import com.practice.webflux.domain.Book;
import com.practice.webflux.domain.BookDto;
import com.practice.webflux.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class FluxController {

    private final BookMapper bookMapper;

    @GetMapping(value = "/chars", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Character> getChars() {
        return Flux
                .just('a', 'b', 'x', 'y', 'z')
                .delayElements(Duration.ofSeconds(2))
                .log();
    }


    @PostMapping(value = "/bookDtos", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getDtos(@RequestBody Book book) {
        return Flux
                .just(bookMapper.mapToDto(book))
                .log();
    }
}
