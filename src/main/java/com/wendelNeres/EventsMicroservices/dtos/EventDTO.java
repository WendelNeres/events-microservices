package com.wendelNeres.EventsMicroservices.dtos;


import com.wendelNeres.EventsMicroservices.domain.entities.Event;

public class EventDTO {
    private String id;
    private int maxParticipants;
    private String data;
    private String title;
    private String description;

    public EventDTO(){
    }

    public EventDTO(Event event) {
        this.id = event.getId();
        this.maxParticipants = event.getMaxParticipants();
        this.data = event.getData();
        this.title = event.getTitle();
        this.description = event.getDescription();

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
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
}
