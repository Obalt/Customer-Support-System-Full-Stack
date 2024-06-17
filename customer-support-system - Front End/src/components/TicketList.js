import React from 'react';
import './TicketList.css';
import Ticket from './Ticket';

function TicketList({ tickets }) {
  if (!Array.isArray(tickets)) {
    return <p>No tickets available.</p>;
  }

  return (
    <div className="ticket-list">
      {tickets.map(ticket => (
        <Ticket key={ticket.id} ticket={ticket} />
      ))}
    </div>
  );
}

export default TicketList;
