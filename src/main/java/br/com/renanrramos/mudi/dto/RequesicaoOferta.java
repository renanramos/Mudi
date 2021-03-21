package br.com.renanrramos.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.renanrramos.mudi.model.Oferta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RequesicaoOferta {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@NotBlank(message = "Campo obrigatório")
	private String pedidoId;

	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	@NotBlank(message = "Campo obrigatório")
	private String valor;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotBlank(message = "Campo obrigatório")
	private String dataDaEntrega;
	
	@NotBlank(message = "Campo obrigatório")
	private String comentario;
	
	public RequesicaoOferta()
	{
		
	}

	public Oferta toOferta() 
	{
		return new Oferta()
				.withComentario(this.comentario)
				.withDataDaEntrada(LocalDate.parse(this.dataDaEntrega, formatter))
				.withValor(new BigDecimal(this.valor));
	}
}
