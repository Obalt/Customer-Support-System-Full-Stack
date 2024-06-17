import React from 'react';
import './Ticket.css';

function Ticket({ ticket }) {
  return (
    <div className="ticket">
      <h2>{ticket.title}</h2>
      <p>{ticket.description}</p>
      <p>Status: {ticket.status}</p>
      <p>User Email: {ticket.userEmail}</p>
    </div>
  );
}

export default Ticket;
