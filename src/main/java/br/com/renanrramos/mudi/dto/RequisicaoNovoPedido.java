package br.com.renanrramos.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.renanrramos.mudi.model.Pedido;
import br.com.renanrramos.mudi.model.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RequisicaoNovoPedido {

	@NotBlank(message = "Campo obrigatório")
	private String nomeProduto;

	@NotBlank(message = "Campo obrigatório")
	private String urlProduto;

	@NotBlank(message = "Campo obrigatório")
	private String urlImagem;

	@NotBlank
	private String descricao;

	public RequisicaoNovoPedido() {
		
	}

	public Pedido toPedido(final StatusPedido status)
	{
		return new Pedido()
				.withNomeProduto(nomeProduto)
				.withUrlImagem(urlImagem)
				.withUrlProduto(urlProduto)
				.withDescricao(descricao)
				.withStatus(status);
	}
}
