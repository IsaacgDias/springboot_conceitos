package com.proj.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proj.crm.model.Cliente;
import com.proj.crm.repository.ClienteRepository;
import com.proj.crm.services.ClienteService;

//O @Controller é usado para sinalizar que é uma classe do Spring MVC e bastante usado para 
//redirecionar views. Já o @RestController faz automaticamente tudo o que o @Controller faz
//é retornar tudo em JSON.

@RestController
@RequestMapping("/clientes")
//Quando vier uma requisição /clientes vai para o ClienteController. 
public class ClienteController {

	//@Autowired adiciona uma instacia automaticamente no clienteRepository, vem da interface ClienteRepository.
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	// (GET) Quando chamar a requisição do tipo GET /clientes @RequestMapping("/clientes") o @GetMapping vai respoder essa requisição.
	
	// Busca o cliente.
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	// (Post) Quando chamar a requisição do tipo POST /clientes @RequestMapping("/clientes") o @PostMapping vai respoder essa requisição.
	//@RequestBody o corpo da requisição vai ser convertido para objeto java.
	//@PathVariable pega o id da url
	
	//Cadastro do cliente.
	
	//@ResponseStatus(HttpStatus.CREATED) quando executar o metodo adicionar, vai retornar o cod 201 de CREATED no postman
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
			return clienteRepository.save(cliente);
	}
	
	// (Delete) Essa requisição do tipo DELETE vai deletar o cliente
	// ResponseEntity significa qual tipo de dado vai me retornar
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id){
		clienteService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
		
	}
	
	// (PUT) Quando chamar a requisição do tipo PUT /clientes/atualizar vai atualizar o cliente
	//http://localhost:8080/clientes/atualizar
	
	@PutMapping("/atualizar")
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
