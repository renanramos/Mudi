package br.com.renanrramos.mudi.api;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renanrramos.mudi.dto.RequesicaoOferta;
import br.com.renanrramos.mudi.model.Oferta;
import br.com.renanrramos.mudi.model.Pedido;
import br.com.renanrramos.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Oferta criarOferta(@Valid @RequestBody final RequesicaoOferta requisicao) {
		final Optional<Pedido> pedidoBuscado = pedidoRepository.findById(UUID.fromString(requisicao.getPedidoId()));
		
		if(!pedidoBuscado.isPresent())
		{
			return null;
		}
		final Pedido pedido = pedidoBuscado.get();
		final Oferta nova = requisicao.toOferta();
		nova.withPedido(pedido);
		
		pedido.getOfertas().add(nova);
		
		pedidoRepository.save(pedido);
		
		return nova;
	}
}
