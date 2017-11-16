package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaProcedimentoChildThriftEZYER {

	java.lang.String build_numProntuario ();

	java.lang.String build_numCartaoSus ();

	java.lang.Long build_dtNascimento ();

	java.lang.Long build_sexo ();

	java.lang.Long build_localAtendimento ();

	java.lang.Long build_turno ();

	java.lang.Boolean build_statusEscutaInicialOrientacao ();

	java.util.List build_procedimentos ();

	java.util.List build_outrosSiaProcedimentos ();

}