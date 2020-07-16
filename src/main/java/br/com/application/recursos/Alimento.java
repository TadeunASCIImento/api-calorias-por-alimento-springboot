package br.com.application.recursos;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "alimentos")
public class Alimento implements Serializable {	
	private static final long serialVersionUID = -5782963052534642796L;
	
	@Id
	private Object id;
	private String descricao;
	private String quantidade;
	private String calorias;

}
