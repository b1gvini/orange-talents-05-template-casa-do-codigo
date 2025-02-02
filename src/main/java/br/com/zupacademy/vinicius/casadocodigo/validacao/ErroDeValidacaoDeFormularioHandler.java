package br.com.zupacademy.vinicius.casadocodigo.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErroDeValidacaoDeFormularioHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeValidacaoDeFormularioDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroDeValidacaoDeFormularioDTO> dto = new ArrayList<>();
		List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();

		fieldError.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeValidacaoDeFormularioDTO erro = new ErroDeValidacaoDeFormularioDTO(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}

}
