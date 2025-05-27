package com.wendelNeres.EventsMicroservices.domain.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;
    private String participantEmail;


    public Subscription(){

    }

    public Subscription(Long id, Event event, String participantEmail){
        this.id = id;
        this.event = event;
        this.participantEmail = participantEmail;

    }

    public Subscription(Event event, String emailParticipant) {
        this.event = event;
        this.participantEmail = emailParticipant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return Objects.equals(getEvent(), that.getEvent()) && Objects.equals(getParticipantEmail(), that.getParticipantEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvent(), getParticipantEmail());
    }
}
