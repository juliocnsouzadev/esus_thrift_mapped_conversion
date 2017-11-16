package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaAtendimentoOdontologicoChildThriftEZYER {

	java.lang.Long build_dtNascimento ();

	java.lang.String build_numCartaoSus ();

	java.lang.String build_numProntuario ();

	java.lang.Boolean build_gestante ();

	java.lang.Boolean build_necessidadesEspeciais ();

	java.lang.Long build_localAtendimento ();

	java.lang.Long build_tipoAtendimento ();

	java.util.List build_tiposEncamOdonto ();

	java.util.List build_tiposFornecimOdonto ();

	java.util.List build_tiposVigilanciaSaudeBucal ();

	java.util.List build_tiposConsultaOdonto ();

	java.util.List build_procedimentosRealizados ();

	java.util.List build_outrosSiaProcedimentos ();

	java.lang.Long build_sexo ();

	java.lang.Long build_turno ();

}