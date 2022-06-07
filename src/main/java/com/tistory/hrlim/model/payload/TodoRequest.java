package com.tistory.hrlim.model.payload;

import com.tistory.hrlim.annotation.YearMonth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String title;

    private int important;

    private Boolean completed;

    @YearMonth
    private String yearMonth;
}
