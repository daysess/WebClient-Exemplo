package br.com.produtos.model.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> obterProduto(@PathVariable Integer id) throws Exception{
		Produto produto = new Produto(id, "Computador", "Intel Core i5");
		
		//Para validar a resposta do webClient
		Thread.sleep(3000);
		
		return ResponseEntity.ok(produto);
	}
	
	
}
