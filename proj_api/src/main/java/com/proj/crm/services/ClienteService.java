package com.proj.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.proj.crm.model.Cliente;
import com.proj.crm.repository.ClienteRepository;

//Services ela e responsavel pelo processamento, validação, coordenação e execução das regras de negócio.


@Component
public class ClienteService {
    
	@Autowired
    private ClienteRepository clienteRepository;
    	
	// Deletar o cliente
	   
	// 	@Transactional evita dados quebrados
	@Transactional
	public void delete(long id) {
		clienteRepository.deleteById(id);
		
	}

	

}
