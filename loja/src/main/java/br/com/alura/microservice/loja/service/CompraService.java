package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	//@Autowired
	//private RestTemplate client;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private DiscoveryClient eurekaClient;
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
//		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange("http://fornecedor:8081/info/".concat(compra.getEndereco().getEstado()), 
//				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		// Imprime todas as intancias disponiveis da aplicação fornecedor
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(fornecedor -> {
			System.out.println("localhost:" + fornecedor.getPort());
		});
		
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("buscando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(estado);
		
		LOG.info("realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}
}
