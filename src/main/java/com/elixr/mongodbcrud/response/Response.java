package com.elixr.mongodbcrud.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Response {
    @NonNull
    private Integer statusCode;
    @NonNull
    private String message;
    @NonNull
    private String status;
    @NonNull
    private String traceId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;
}
