package com.proj.crm.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity e do JPA
//@Entity significa que é uma entidade, ela e mapeada para uma tabela no banco de dados (Tabela cliente).
@Table(name = "tb_cliente")
@Entity
public class Cliente {
	
	// @Id chave primaria banco de dados.
	//@GeneratedValue  serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados.
	//GenerationType.IDENTITY responsabilidade de icrementar passa para o db.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column não e necessario pois o @Entity mapea toda a estrutura da classe cliente.
	//Caso queira especificar algo o @Column pode ser necessario.
	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
}
