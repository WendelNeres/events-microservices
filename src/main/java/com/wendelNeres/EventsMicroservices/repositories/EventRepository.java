package com.wendelNeres.EventsMicroservices.repositories;

import com.wendelNeres.EventsMicroservices.domain.entities.Event;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM events e WHERE parsedatetime(e.date, 'dd/MM/yyyy') > :currentDate",nativeQuery = true)
    List<Event> findUpcomingEvents(@Param("currentDate")LocalDateTime currentDate);

    @Nonnull
    Optional <Event> findById (@Nonnull String id);




}
