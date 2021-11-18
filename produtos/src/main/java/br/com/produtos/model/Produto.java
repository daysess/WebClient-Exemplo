package br.com.produtos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {

	private Integer id;
	
	private String nmProduto;
	
	private String dsProduto;
	
}
