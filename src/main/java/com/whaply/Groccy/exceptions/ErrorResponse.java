package com.whaply.Groccy.exceptions;

public record ErrorResponse(String type, String title, String details, int status) {
    public record Field(String name, String value) {}
}
 