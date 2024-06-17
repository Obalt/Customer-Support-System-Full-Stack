package com.obalt.customer_support_system.mapper;

import com.obalt.customer_support_system.dto.TicketDTO;
import com.obalt.customer_support_system.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDTO toDto(Ticket ticket){
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setTitle(ticket.getDescription());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        dto.setUserEmail(ticket.getUserEmail());

        return dto;
    }

    public Ticket toEntity(TicketDTO dto){
        Ticket ticket = new Ticket();
        ticket.setId(dto.getId());
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());
        ticket.setUserEmail(dto.getUserEmail());
        return ticket;
    }
}
