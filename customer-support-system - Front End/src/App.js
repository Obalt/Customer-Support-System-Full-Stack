import React, { useState, useEffect } from 'react';
import './App.css';
import TicketList from './components/TicketList';
import TicketForm from './components/Ticketform';

function App() {
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    // Fetch tickets from the backend
    fetch('/api/tickets')
      .then(response => response.json())
      .then(data => {
        if (Array.isArray(data)) {
          setTickets(data);
        } else {
          console.error('Expected an array of tickets');
        }
      })
      .catch(error => console.error('Error fetching tickets:', error));
  }, []);

  const addTicket = (ticket) => {
    setTickets([...tickets, ticket]);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Customer Support System</h1>
      </header>
      <main>
        <TicketForm addTicket={addTicket} />
        <TicketList tickets={tickets} />
      </main>
    </div>
  );
}

export default App;
