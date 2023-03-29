package com.rtornello.inditex.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ErrorDTO {

    private HttpStatus status;
    private int code;
    private String message;

}
