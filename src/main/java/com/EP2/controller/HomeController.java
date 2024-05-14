package com.EP2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EP2.entity.Pedido;
import com.EP2.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	@GetMapping("/mostrarPrincipal") 
	public String mostrarPrincipal(HttpServletRequest request) {
		return "index";
	}
	
	@GetMapping("/mostrarGestionPedidos")
	public String mostrarGestionPedidos(HttpServletRequest request, Model model) {
		List<Pedido> listaPedidos = pedidoRepository.findAll();
		model.addAttribute("listaPedidos", listaPedidos);
		return "gestionPedidos";
	}
	
}
