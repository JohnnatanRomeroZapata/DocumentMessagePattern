package com.example.DocumentMessagePattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRecordGateway reservationRecordGateway;

    @Override
    public void getReservation(ReservationRecord reservationRecord) {

        logger.info("Reservation information {}", reservationRecord);

        Message<ReservationRecord> reservationRecordMessage = MessageBuilder.withPayload(reservationRecord)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER, 1)
                .setHeader(IntegrationMessageHeaderAccessor.SEQUENCE_SIZE, 5)
                .build();

        reservationRecordGateway.addRecord(reservationRecordMessage);
    }
}
