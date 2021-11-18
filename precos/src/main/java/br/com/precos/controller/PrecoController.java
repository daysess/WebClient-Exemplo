package br.com.precos.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.precos.model.Preco;

@RestController
@RequestMapping("/precos")
public class PrecoController {

	@GetMapping("/{idProduto}")
	public ResponseEntity<Preco> obterPreco(@PathVariable Integer idProduto){
		Preco preco = new Preco(idProduto, new BigDecimal(3750));
		return ResponseEntity.ok(preco);
	}
	
}
