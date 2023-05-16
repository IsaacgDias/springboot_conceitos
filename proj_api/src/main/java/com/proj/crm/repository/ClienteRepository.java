package com.proj.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.crm.model.Cliente;

//Repositorio aonde colocamos o criar, atualiza, deletar.
//@Repository responsavel para interagir com o db.
//JpaRepository<Cliente, Long> assim ele vai ter o delete(), findAll().

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
