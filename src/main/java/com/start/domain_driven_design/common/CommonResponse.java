package com.start.domain_driven_design.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CommonResponse<T> {

    private T data;

    private String message;

    private boolean success;

    private LocalDateTime time;

    public CommonResponse(T data, boolean success) {
        CommonResponse.builder()
                .data(data)
                .success(success)
                .time(LocalDateTime.now())
                .build();
    }

}
