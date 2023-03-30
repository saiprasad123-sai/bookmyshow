package com.example.bookmyshow.Converters;

import com.example.bookmyshow.Models.Ticket;
import com.example.bookmyshow.ResponseDto.TicketResponseDto;

public class TicketConverter {
    public static TicketResponseDto convertEntiityToDto(Ticket ticket){
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .ticketId(ticket.getId())
                .amount(ticket.getAmount())
                .movieName(ticket.getShow().getMovie().getName())
                .noOfSeatsBooked(ticket.getNumberOfSeats())
                .build();
        return ticketResponseDto;
    }
}