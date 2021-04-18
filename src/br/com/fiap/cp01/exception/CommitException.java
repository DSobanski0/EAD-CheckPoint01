package br.com.fiap.cp01.exception;

public class CommitException extends Exception {

	public CommitException(String msg) {
		super(msg);
	}
	
	public CommitException() {
		super("Erro ao efetuar o commit");
	}
	
}