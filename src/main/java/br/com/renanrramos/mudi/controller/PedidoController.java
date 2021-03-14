package br.com.renanrramos.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanrramos.mudi.dto.RequisicaoNovoPedido;
import br.com.renanrramos.mudi.model.Pedido;
import br.com.renanrramos.mudi.model.StatusPedido;
import br.com.renanrramos.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(final RequisicaoNovoPedido requisicao)
	{
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid final RequisicaoNovoPedido requisicao, BindingResult result)
	{		
		if (result.hasErrors())
		{
			return "pedido/formulario";
		}
		
		final Pedido pedido = requisicao.toPedido(StatusPedido.AGUARDANDO);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
