package br.com.zupacademy.vinicius.casadocodigo.config.validacao;

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
