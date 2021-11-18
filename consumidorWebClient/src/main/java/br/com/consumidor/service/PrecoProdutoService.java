package br.com.consumidor.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.consumidor.model.ProdutoComPreco;
import reactor.core.publisher.Mono;

@Service
public class PrecoProdutoService {

	@Autowired
	private WebClient webClientProdutos;
	
	@Autowired
	private WebClient webClientPrecos;
	
	
	public ProdutoComPreco criarProduto() {
		ProdutoComPreco produto = new ProdutoComPreco(5,"Violão",new BigDecimal(50));

		Mono<ProdutoComPreco> monoProduto = this.webClientProdutos
							.post()
							.uri("/produtos")
							.body(BodyInserters.fromValue(produto))
							.retrieve()
							.bodyToMono(ProdutoComPreco.class);
		
		return monoProduto.block();
	}
	
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
		
		
		ProdutoComPreco produto = Mono.zip(monoProduto, monoPreco).map(tuple -> {
										tuple.getT1().setPreco(tuple.getT2().getPreco());
										return tuple.getT1();
									}).block();
		
		
		return produto;
	}

}
