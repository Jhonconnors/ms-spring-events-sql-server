package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventQualifier {

    private String codEvent;

    private String valueEvent;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date entryDate;

    private String responsible;

}
