package br.com.zupacademy.vinicius.casadocodigo.cliente;

public class ResponseClienteDTO {
	
	private Long id;
	
	public ResponseClienteDTO() {
		
	}
	
	public ResponseClienteDTO(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
