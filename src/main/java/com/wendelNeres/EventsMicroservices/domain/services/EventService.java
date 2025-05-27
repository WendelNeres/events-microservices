package com.wendelNeres.EventsMicroservices.domain.services;


import com.wendelNeres.EventsMicroservices.domain.entities.Event;
import com.wendelNeres.EventsMicroservices.domain.entities.Subscription;
import com.wendelNeres.EventsMicroservices.dtos.CreateEventDTO;
import com.wendelNeres.EventsMicroservices.dtos.CreateSubscriptionDTO;
import com.wendelNeres.EventsMicroservices.dtos.EmailRequestDTO;
import com.wendelNeres.EventsMicroservices.dtos.EventDTO;
import com.wendelNeres.EventsMicroservices.exceptions.EventFullException;
import com.wendelNeres.EventsMicroservices.exceptions.EventNotFoundException;
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

    public EventDTO createEvent(CreateEventDTO createEventDTO){
        return new EventDTO(eventRepository.save(new Event(createEventDTO)));
    }

    public void registerParticipant(String idEvent, CreateSubscriptionDTO createSubscriptionDTO){
        Event event = eventRepository.findById(idEvent).get();

        if(event != null){
            Subscription subscription = new Subscription(event, createSubscriptionDTO.emailParticipant());

            if(event.getRegisteredParticants() >= event.getMaxParticipants()) {
                throw new EventFullException();
            }

            subscriptionRepository.save(subscription);

            event.setRegisteredParticants(event.getRegisteredParticants() + 1);
            EmailRequestDTO emailRequestDTO = new EmailRequestDTO(createSubscriptionDTO.emailParticipant(), "Confirmação de inscrição", "Voce foi inscrito com sucesso");
            emailServiceClient.sendEmail(emailRequestDTO);
        }else throw new EventNotFoundException();

    }

}
