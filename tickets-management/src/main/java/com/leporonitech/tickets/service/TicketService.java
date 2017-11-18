package com.leporonitech.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leporonitech.tickets.model.Ticket;
import com.leporonitech.tickets.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	public List<Ticket> findAll() {
		return repository.findAll();
	}

	public Ticket findOne(Long id) {
		return repository.findOne(id);
	}

	public Ticket save(Ticket ticket) {
		return repository.saveAndFlush(ticket);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
