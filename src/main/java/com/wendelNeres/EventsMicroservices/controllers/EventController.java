package com.wendelNeres.EventsMicroservices.controllers;


import com.wendelNeres.EventsMicroservices.domain.services.EventService;
import com.wendelNeres.EventsMicroservices.dtos.CreateEventDTO;
import com.wendelNeres.EventsMicroservices.dtos.CreateSubscriptionDTO;
import com.wendelNeres.EventsMicroservices.dtos.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping
    public ResponseEntity<List<EventDTO>> findAll(){
        return new ResponseEntity<List<EventDTO>>(eventService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody CreateEventDTO createEventDTO){
        return new ResponseEntity<EventDTO>(eventService.createEvent(createEventDTO),HttpStatus.CREATED);
    }

    @GetMapping("/upComingEvents")
    public ResponseEntity<List<EventDTO>> getUpcomingEvents(){
        return new ResponseEntity<List<EventDTO>>(eventService.getUpcomingEvents(),HttpStatus.OK);
    }

    @PostMapping("/register/{idEvent}")
    public void registerParticipant(@PathVariable String idEvent, @RequestBody CreateSubscriptionDTO createSubscriptionDTO){
        eventService.registerParticipant(idEvent,createSubscriptionDTO);
    }






}
