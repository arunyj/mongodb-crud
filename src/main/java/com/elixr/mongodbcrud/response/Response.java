package com.elixr.mongodbcrud.response;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {
    @NonNull
    private String message;
}
