package com.wendelNeres.EventsMicroservices.exceptions;

public class EventNotFoundException extends RuntimeException{


    public EventNotFoundException(){
        super("Evento não encontrado");

    }


    public EventNotFoundException(String mensage){
        super(mensage);
    }
}
