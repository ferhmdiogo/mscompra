package com.compra.mscompra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compra.mscompra.model.Pedido;
import com.compra.mscompra.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pedido")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid Pedido pedido){
		return ResponseEntity.ok(pedidoService.salvar(pedido));
	}
	

}
