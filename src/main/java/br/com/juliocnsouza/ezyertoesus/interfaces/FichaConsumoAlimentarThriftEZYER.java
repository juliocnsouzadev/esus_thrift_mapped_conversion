package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaConsumoAlimentarThriftEZYER {

	br.gov.saude.esus.cds.transport.generated.thrift.common.UnicaLotacaoHeaderThrift build_headerTransport ();

	java.lang.String build_numeroCartaoSus ();

	java.lang.String build_identificacaoUsuario ();

	java.lang.Long build_dataNascimento ();

	java.lang.Long build_sexo ();

	java.lang.Long build_localAtendimento ();

	java.util.List build_perguntasQuestionarioCriancasMenoresSeisMeses ();

	java.util.List build_perguntasQuestionarioCriancasDeSeisVinteTresMeses ();

	java.util.List build_perguntasQuestionarioCriancasComMaisDoisAnos ();

	java.lang.String build_uuidFicha ();

	java.lang.Integer build_tpCdsOrigem ();

}