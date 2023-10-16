package com.example.DocumentMessagePattern;

import org.springframework.messaging.Message;

public interface ReservationService<T> {
    void getReservation(Message<T> reservation);
}
