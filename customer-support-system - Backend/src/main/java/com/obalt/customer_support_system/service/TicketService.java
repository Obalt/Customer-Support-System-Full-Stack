package com.obalt.customer_support_system.service;

import com.obalt.customer_support_system.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    List <TicketDTO> getAllTickets();
    TicketDTO getTicketById (Long id);
    TicketDTO createTicket(TicketDTO ticket);
    TicketDTO updateTicket(Long id, TicketDTO ticketDetails);
    void deleteTicket(Long id);
}