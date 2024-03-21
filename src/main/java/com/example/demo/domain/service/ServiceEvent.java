package com.example.demo.domain.service;

import com.example.demo.domain.model.EventQualifier;

import java.util.List;

public interface ServiceEvent {

    String convertToXML(List<EventQualifier> events);

    void  executeSp(List<EventQualifier> eventQualifiers);

}
