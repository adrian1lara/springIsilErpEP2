package com.EP2.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EP2.entity.Cliente;
import com.EP2.entity.Pedido;
import com.EP2.entity.Producto;
import com.EP2.repository.ClienteRepository;
import com.EP2.repository.PedidoRepository;
import com.EP2.repository.ProductoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@PostMapping("/agregarPedido")
	public String agregarPedido(@ModelAttribute("nuevoPedido") Pedido nuevoPedido, Model model) {
		pedidoRepository.save(nuevoPedido);
		return "redirect:/home/mostrarGestionPedidos";
	}
	
	@PostMapping("/editarPedido")
	public String editarPedido(@ModelAttribute("pedido") Pedido pedido, Model model) {
		
		pedidoRepository.save(pedido);
		
		return "redirect:/home/mostrarGestionPedidos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(HttpServletRequest request,
			@PathVariable("id") int id, Model model) {
		pedidoRepository.deleteById(id);
		List<Pedido> listaPedidos = pedidoRepository.findAll();
		model.addAttribute("listaPedidos", listaPedidos);
		return "redirect:/home/mostrarGestionPedidos";
	}
	
	@GetMapping("/mostrarEditarPedido/{id}")
	public String mostrarEditarPedido(HttpServletRequest request, 
			@PathVariable("id") int id, Model model) {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		Pedido pedido = optionalPedido.get();
		
		model.addAttribute("pedido", pedido);
		
        List<Cliente> listaCliente = clienteRepository.findAll();
        model.addAttribute("listaCliente", listaCliente);
        
        List<Producto> listaProducto = productoRepository.findAll();
        model.addAttribute("listaProducto", listaProducto);

		return "editarPedido";
	}
	
	@GetMapping("/mostrarNuevoPedido")
	public String mostrarNuevoPedido(HttpServletRequest request, Model model) {
		Pedido nuevoPedido = new Pedido();
		model.addAttribute("nuevoPedido", nuevoPedido);
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		model.addAttribute("listaCliente", listaCliente);
		
		List<Producto> listaProducto = productoRepository.findAll();
		model.addAttribute("listaProducto", listaProducto);
		
		return "nuevoPedido";
	}

}
