package br.com.zupacademy.vinicius.casadocodigo.validacao;

public class ErroDeValidacaoDeFormularioDTO {

	private String campo;
	private String erro;
	
	public ErroDeValidacaoDeFormularioDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
