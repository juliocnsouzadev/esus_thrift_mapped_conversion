package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaAtendimentoIndividualChildThriftEZYER {

	java.lang.String build_numeroProntuario ();

	java.lang.String build_cns ();

	java.lang.Long build_dataNascimento ();

	java.lang.Long build_localDeAtendimento ();

	java.lang.Long build_sexo ();

	java.lang.Long build_turno ();

	java.lang.Long build_tipoAtendimento ();

	java.lang.Double build_pesoAcompanhamentoNutricional ();

	java.lang.Double build_alturaAcompanhamentoNutricional ();

	java.lang.Long build_aleitamentoMaterno ();

	java.lang.Long build_dumDaGestante ();

	java.lang.Integer build_idadeGestacional ();

	java.lang.Long build_atencaoDomiciliarModalidade ();

	br.gov.saude.esus.cds.transport.generated.thrift.atividadeindividual.ProblemaCondicaoAvaliacaoAIThrift build_problemaCondicaoAvaliada ();

	java.util.List build_examesSolicitados ();

	java.util.List build_examesAvaliados ();

	java.util.List build_outrosSia ();

	java.lang.Boolean build_vacinaEmDia ();

	java.lang.Long build_pic ();

	java.lang.Boolean build_ficouEmObservacao ();

	java.util.List build_nasfs ();

	java.util.List build_condutas ();

	java.lang.Boolean build_stGravidezPlanejada ();

	java.lang.Integer build_nuGestasPrevias ();

	java.lang.Integer build_nuPartos ();

}