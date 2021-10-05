package br.com.service.doit.util;

public class Constants {

	private Constants() {
	}

	public static final String NOT_FOUND = "Nenhum registro encontrado";
	public static final String ID_ALREADY_REGISTERED = "Id j\u00e1 cadastrado";
	public static final String COMMISSION_CONFLICT = "Esta comiss\u00e3o conflita com as comiss\u00f5es: %s";
	public static final String COMMISSION_DATE_VALIDITY = "O fim da vig\u00eancia n\u00e3o pode ser anterior ao in\u00edcio";

	public static final String HTTP_400 = "Invalid input parameters";
	public static final String HTTP_401 = "Not authorized";
	public static final String HTTP_403 = "Forbidden";
	public static final String HTTP_404 = "Not Found";
	public static final String HTTP_500 = "Unknown Error";


	public static final String LOG_INFO_INSERT = "method=insert entity={} id={} message={}";
	public static final String LOG_INFO_UPDATE = "method=update entity={} id={} message={}";
	public static final String LOG_INFO_DELETE = "method=delete entity={} id={} message={}";
	public static final String LOG_ERROR_PERSISTENCE = "method={} entity={} cause={}";

}
