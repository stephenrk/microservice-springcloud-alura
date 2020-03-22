package br.com.alura.microservice.loja.dto;

import java.util.List;

public class CompraDTO {

	private List<ItemCompraDTO> itens;
	
	private EnderecoDTO endereco;

	public List<ItemCompraDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompraDTO> itens) {
		this.itens = itens;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
