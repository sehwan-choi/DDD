package com.start.domain_driven_design.common;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SimpleResponse {

    private String message;

    private boolean success;

    private LocalDateTime timestamp;

    public static SimpleResponse ok() {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.success = true;
        simpleResponse.timestamp = LocalDateTime.now();
        return simpleResponse;
    }

}
