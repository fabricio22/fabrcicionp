package br.com.fabricionp.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2108681889636717877L;

	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}

	public ObjectNotFoundException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
}
