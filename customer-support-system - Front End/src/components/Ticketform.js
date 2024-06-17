import React, { useState } from 'react';
import './Ticketform.css';

function TicketForm({ addTicket }) {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [status, setStatus] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const newTicket = { title, description, status, userEmail };
    fetch('http://localhost:8080/api/tickets', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newTicket),
    })
      .then(response => response.json())
      .then(data => {
        addTicket(data);
        setTitle('');
        setDescription('');
        setStatus('');
        setUserEmail('');
        setMessage('Ticket created successfully!');
      })
      .catch(error => {
        console.error('Error creating ticket:', error);
        setMessage('Failed to create ticket.');
      });
  };

  return (
    <form className="ticket-form" onSubmit={handleSubmit}>
      <label>
        Title:
        <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
      </label>
      <label>
        Description:
        <input type="text" value={description} onChange={(e) => setDescription(e.target.value)} />
      </label>
      <label>
        Status:
        <input type="text" value={status} onChange={(e) => setStatus(e.target.value)} />
      </label>
      <label>
        User Email:
        <input type="email" value={userEmail} onChange={(e) => setUserEmail(e.target.value)} />
      </label>
      <button type="submit">Add Ticket</button>
      {message && <p>{message}</p>}
    </form>
  );
}

export default TicketForm;
