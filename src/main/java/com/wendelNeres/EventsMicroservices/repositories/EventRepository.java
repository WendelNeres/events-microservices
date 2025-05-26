package com.wendelNeres.EventsMicroservices.repositories;

import com.wendelNeres.EventsMicroservices.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event, String> {
}
