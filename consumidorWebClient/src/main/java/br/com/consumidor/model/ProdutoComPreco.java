package br.com.consumidor.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoComPreco {

	private Integer id;
	
	private String nmProduto;
	
	private BigDecimal preco;
	
}
