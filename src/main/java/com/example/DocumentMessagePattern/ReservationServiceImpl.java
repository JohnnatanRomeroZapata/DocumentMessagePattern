package com.example.DocumentMessagePattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@MessageEndpoint
public class ReservationServiceImpl implements ReservationService<ReservationRecord>{

    private static final Logger logger = LogManager.getLogger(ReservationServiceImpl.class);

    @ServiceActivator(inputChannel = "reservationRecordChannel")
    @Override
    public void getReservation(Message<ReservationRecord> reservation) {

        IntegrationMessageHeaderAccessor accessor = new IntegrationMessageHeaderAccessor(reservation);

        logger.info("Sequence Number: {}, Sequence Size: {}", accessor.getSequenceNumber(), accessor.getSequenceSize());

        logger.info("Reservation info: {}", reservation.getPayload());
    }
}
