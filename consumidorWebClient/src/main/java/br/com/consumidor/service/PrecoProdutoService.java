package br.com.consumidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.consumidor.model.ProdutoComPreco;
import reactor.core.publisher.Mono;

@Service
public class PrecoProdutoService {

	@Autowired
	private WebClient webClientProdutos;
	
	@Autowired
	private WebClient webClientPrecos;
	
	public ProdutoComPreco obterPorCodigo(Integer idProduto) {
		//WebClient webCliente = WebClient.create("http://localhost:8080");
		
		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
													.method(HttpMethod.GET)
													.uri("/produtos/{id}", idProduto)
													.retrieve()
													.bodyToMono(ProdutoComPreco.class);
		
		Mono<ProdutoComPreco> monoPreco = this.webClientPrecos
											.method(HttpMethod.GET)
											.uri("/precos/{id}", idProduto)
											.retrieve()
											.bodyToMono(ProdutoComPreco.class);
		
		ProdutoComPreco produto = monoProduto.block();
		ProdutoComPreco preco = monoPreco.block();
		
		produto.setPreco(preco.getPreco());
		
		return produto;
	}

}
