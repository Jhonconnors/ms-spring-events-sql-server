package com.example.demo.domain.service.impl;

import com.example.demo.domain.model.EventQualifier;
import com.example.demo.domain.model.ResponseSPEvent;
import com.example.demo.domain.service.ServiceEvent;
import com.example.demo.persistence.SpOperation;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceEventImpl implements ServiceEvent {

    private final SpOperation spOperation;

    public ServiceEventImpl(SpOperation spOperation) {
        this.spOperation = spOperation;
    }

    @Override
    public String convertToXML(List<EventQualifier> events) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            StringBuilder xmlBuilder = new StringBuilder("<Events>");
            for (EventQualifier event : events) {
                String eventXml = xmlMapper.writeValueAsString(event);
                xmlBuilder.append("<Event>").append(eventXml).append("</Event>");
            }
            xmlBuilder.append("</Events>");
            return xmlBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void executeSp(List<EventQualifier> eventQualifiers) {

    }

    @PostConstruct
    public void getXml(){
        List<EventQualifier> createEvents = createEvents();
        String xml = convertToXML(createEvents);
        System.out.println(xml);

        ResponseSPEvent responseSPEvent;
        spOperation.insertEvents(xml);

    }

    public List<EventQualifier> createEvents(){
        List<EventQualifier> createEvents = new ArrayList<>();
        EventQualifier e1 =  new EventQualifier("123", "5", new Date(), "e1");
        EventQualifier e2 =  new EventQualifier("1230", "8", new Date(), "e2");
        EventQualifier e3 =  new EventQualifier("1223", "4", new Date(), "e3");
        EventQualifier e4 =  new EventQualifier("1232", "1", new Date(), "e4");
        EventQualifier e5 =  new EventQualifier("1234", "77", new Date(), "e5");
        createEvents.add(e1);
        createEvents.add(e2);
        createEvents.add(e3);
        createEvents.add(e4);
        createEvents.add(e5);
        return createEvents;
    }


}
