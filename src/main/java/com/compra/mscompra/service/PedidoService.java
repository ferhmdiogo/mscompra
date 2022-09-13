package com.compra.mscompra.service;

import com.compra.mscompra.service.rabbitmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compra.mscompra.model.Pedido;
import com.compra.mscompra.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final Producer producer;
	
	public Pedido salvar(Pedido pedido) {
		pedido = pedidoRepository.save(pedido);
		producer.enviarPedido(pedido.toString());
		return pedido;
	}

}
