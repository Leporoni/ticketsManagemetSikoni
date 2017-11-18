package com.leporonitech.tickets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leporonitech.tickets.model.Ticket;
import com.leporonitech.tickets.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	private TicketService service;

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/ticket");
		mv.addObject("tickets", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Ticket ticket) {

		ModelAndView mv = new ModelAndView("/ticketAdd");
		mv.addObject("ticket", ticket);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(service.findOne(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Ticket ticket, BindingResult result) {

		if (result.hasErrors()) {
			return add(ticket);
		}

		service.save(ticket);

		return findAll();
	}

}
