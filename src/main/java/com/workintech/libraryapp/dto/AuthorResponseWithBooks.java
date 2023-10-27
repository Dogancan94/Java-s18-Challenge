package com.workintech.libraryapp.dto;

import java.util.List;

public record AuthorResponseWithBooks(List<BookResponse> responseList) {
}
