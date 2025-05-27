package com.wendelNeres.EventsMicroservices.exceptions;

public class EventFullException extends RuntimeException{


    public EventFullException(){
        super("Evento cheio");
    }

    public EventFullException(String mensage){
        super(mensage);
    }
}
