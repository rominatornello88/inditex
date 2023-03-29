package com.rtornello.inditex.domain.utils;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public final class MessageUtils {

    public MessageUtils() {
        throw new IllegalStateException("BankUtils class");

    }

    public static String getMessageResponse(MethodArgumentTypeMismatchException ex) {
        return ex.getLocalizedMessage();
    }
}