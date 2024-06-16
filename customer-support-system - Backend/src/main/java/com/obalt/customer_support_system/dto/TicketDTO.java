package com.obalt.customer_support_system.dto;


import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String userEmail;
}
