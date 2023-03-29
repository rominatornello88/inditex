package com.rtornello.inditex.domain.exceptions;

import com.rtornello.inditex.domain.constants.ConstantPrice;
import com.rtornello.inditex.domain.dto.ErrorDTO;
import com.rtornello.inditex.domain.utils.MessageUtils;
import java.time.format.DateTimeParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {PriceNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleErrorCodeException(PriceNotFoundException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
            .status(HttpStatus.BAD_REQUEST)
            .message(ex.getMessage())
            .code(HttpStatus.BAD_REQUEST.value())
            .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DateTimeParseException.class})
    public ResponseEntity<ErrorDTO> handleErrorCodeException(DateTimeParseException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
            .status(HttpStatus.BAD_REQUEST)
            .message(ConstantPrice.INVALID_DATE_FORMAT)
            .code(HttpStatus.BAD_REQUEST.value())
            .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDTO> methodArgumentNotValidException(MethodArgumentTypeMismatchException ex) {
        String messageResponse = MessageUtils.getMessageResponse(ex);
        ErrorDTO errorDTO = ErrorDTO.builder()
            .status(HttpStatus.BAD_REQUEST)
            .message(messageResponse)
            .code(HttpStatus.BAD_REQUEST.value())
            .build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
