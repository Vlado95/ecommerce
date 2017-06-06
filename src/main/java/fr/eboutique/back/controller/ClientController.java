package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Client;
import fr.eboutique.service.IService;

@Controller
public class ClientController {
	
	@Autowired
	private IService<Client> serviceClient;
	
	@RequestMapping(value = "/clients**", method = RequestMethod.GET)
	public String clintPage( Model model) {
		List<Client> clientList= serviceClient.findAll();
		model.addAttribute("title", "List de tous les clients");
		model.addAttribute("clientList", clientList);
		System.out.println("clients "+clientList);
		return "/clients";
	
	}


}
