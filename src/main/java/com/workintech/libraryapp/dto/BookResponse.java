package com.workintech.libraryapp.dto;

public record BookResponse(long id, String name, String categoryName, AuthorResponse authorResponse) {
}
