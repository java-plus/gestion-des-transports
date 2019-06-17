package fr.diginamic.exception;

public class AuthenticateException extends RuntimeException {

	/**
	 * Constructeur
	 * 
	 */
	public AuthenticateException() {
	}

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public AuthenticateException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public AuthenticateException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public AuthenticateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public AuthenticateException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
