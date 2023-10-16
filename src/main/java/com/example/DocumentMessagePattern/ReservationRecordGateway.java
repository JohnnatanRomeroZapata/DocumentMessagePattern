package com.example.DocumentMessagePattern;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "reservationRecordGateway", defaultRequestChannel = "reservationRecordChannel")
public interface ReservationRecordGateway {

    @Gateway
    void addRecord(Message<ReservationRecord> reservationRecordMessage);
}
