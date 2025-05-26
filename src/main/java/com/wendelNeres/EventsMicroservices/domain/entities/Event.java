package com.wendelNeres.EventsMicroservices.domain.entities;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maxParticipants;
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
        return getMaxParticipants() == event.getMaxParticipants() && Objects.equals(getId(), event.getId()) && Objects.equals(getData(), event.getData()) && Objects.equals(getTitle(), event.getTitle()) && Objects.equals(getDescription(), event.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMaxParticipants(), getData(), getTitle(), getDescription());
    }
}
