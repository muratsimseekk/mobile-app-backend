package com.kitapmobile.Spring.Project.For.Mobile.Book.App.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonErrorRespone {
    private Integer status;
    private String message;
    private LocalDateTime timeStamp;
}
