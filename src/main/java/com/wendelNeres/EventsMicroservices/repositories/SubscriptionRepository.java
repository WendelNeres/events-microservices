package com.wendelNeres.EventsMicroservices.repositories;

import com.wendelNeres.EventsMicroservices.domain.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
