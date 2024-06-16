package com.obalt.customer_support_system.service;

import com.obalt.customer_support_system.dto.TicketDTO;
import com.obalt.customer_support_system.entity.Ticket;
import com.obalt.customer_support_system.mapper.TicketMapper;
import com.obalt.customer_support_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;


    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll().
                stream().
                map(ticketMapper::toDto).
                collect(Collectors.toList());


    }

    @Override
    public TicketDTO getTicketById(Long id) {

        Ticket ticket = ticketRepository.findById(id).orElse(null);
        return ticket != null ? ticketMapper.toDto(ticket) : null;
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        return ticketMapper.toDto(ticketRepository.save(ticket));
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket != null) {
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setUserEmail(ticketDetails.getUserEmail());
            return ticketMapper.toDto(ticketRepository.save(ticket));
        }
        return null;

    }


    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}


