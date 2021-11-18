package br.com.precos.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Preco {

	private Integer idProduto;
	private BigDecimal preco;
	
}
