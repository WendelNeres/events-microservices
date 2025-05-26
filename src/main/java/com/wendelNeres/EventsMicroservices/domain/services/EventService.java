package com.wendelNeres.EventsMicroservices.domain.services;


import com.wendelNeres.EventsMicroservices.domain.entities.Event;
import com.wendelNeres.EventsMicroservices.dtos.EventDTO;
import com.wendelNeres.EventsMicroservices.repositories.EventRepository;
import com.wendelNeres.EventsMicroservices.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmailServiceClient emailServiceClient;



    public List<EventDTO> findAll(){
        return eventRepository.findAll()
                .stream()
                .map(EventDTO::new)
                .collect(Collectors.toList());
    }


    public List<EventDTO> getUpcomingEvents(){
        return eventRepository.findUpcomingEvents(LocalDateTime.now()).stream()
                .map(EventDTO ::new)
                .collect(Collectors.toList());
    }

    public EventDTO createEvent(Eve){

    }

}
