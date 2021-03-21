package br.com.renanrramos.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@With
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Oferta> ofertas;

	public Pedido() {
	}

}
