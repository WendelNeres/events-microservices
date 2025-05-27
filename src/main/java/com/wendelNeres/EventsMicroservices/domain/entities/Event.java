package com.wendelNeres.EventsMicroservices.domain.entities;

import com.wendelNeres.EventsMicroservices.dtos.CreateEventDTO;
import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maxParticipants;
    private int registeredParticants;
    private String data;
    private String title;
    private String description;


    public Event (){

    }

    public Event(String id, String data, String title, String description){
        this.id = id;
        this.data = data;
        this.title = title;
        this.description = description;

    }

    public Event(CreateEventDTO createEventDTO) {
        this.title = createEventDTO.title();
        this.data = createEventDTO.data();
        this.description = createEventDTO.description();
        this.maxParticipants = createEventDTO.maxParticipants();

    }


    public String getId (){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }



    public int getRegisteredParticants() {
        return registeredParticants;
    }

    public void setRegisteredParticants(int registeredParticants) {
        this.registeredParticants = registeredParticants;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return getMaxParticipants() == event.getMaxParticipants() && getRegisteredParticants() == event.getRegisteredParticants() && Objects.equals(getData(), event.getData()) && Objects.equals(getTitle(), event.getTitle()) && Objects.equals(getDescription(), event.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxParticipants(), getRegisteredParticants(), getData(), getTitle(), getDescription());
    }

}
