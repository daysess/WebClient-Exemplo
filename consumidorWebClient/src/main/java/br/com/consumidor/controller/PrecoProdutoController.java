package br.com.consumidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.consumidor.model.ProdutoComPreco;
import br.com.consumidor.service.PrecoProdutoService;

@RestController
public class PrecoProdutoController {

	@Autowired
	private PrecoProdutoService precoProdutoService;
	
	@GetMapping("/produto/{idProduto}/preco")
	public ResponseEntity<ProdutoComPreco> obterProdutoComPreco(@PathVariable Integer idProduto){
		ProdutoComPreco produtoComPreco = this.precoProdutoService.obterPorCodigo(idProduto);
		return ResponseEntity.ok(produtoComPreco);
	}
	
	
}
