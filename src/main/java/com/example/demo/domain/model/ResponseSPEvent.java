package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSPEvent {

    private Integer status;

    private String message;

    private String firstId;
}
