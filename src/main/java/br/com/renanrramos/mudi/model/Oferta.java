package br.com.renanrramos.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	private BigDecimal valor;
	
	private LocalDate dataDaEntrada;

	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	public Oferta() {
		
	}
}
