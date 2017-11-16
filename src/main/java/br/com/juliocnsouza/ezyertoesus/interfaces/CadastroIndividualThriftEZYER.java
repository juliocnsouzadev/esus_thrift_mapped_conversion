package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface CadastroIndividualThriftEZYER {

	br.gov.saude.esus.cds.transport.generated.thrift.cadastroindividual.CondicoesDeSaudeThrift build_condicoesDeSaude ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.HeaderCdsCadastroThrift build_dadosGerais ();

	br.gov.saude.esus.cds.transport.generated.thrift.cadastroindividual.EmSituacaoDeRuaThrift build_emSituacaoDeRua ();

	java.lang.Boolean build_fichaAtualizada ();

	br.gov.saude.esus.cds.transport.generated.thrift.cadastroindividual.IdentificacaoUsuarioCidadaoThrift build_identificacaoUsuarioCidadao ();

	br.gov.saude.esus.cds.transport.generated.thrift.cadastroindividual.InformacoesSocioDemograficasThrift build_informacoesSocioDemograficas ();

	java.lang.Boolean build_statusTermoRecusaCadastroIndividualAtencaoBasica ();

	java.lang.Integer build_tpCdsOrigem ();

	java.lang.String build_uuid ();

	java.lang.String build_uuidFichaOriginadora ();

	java.lang.String build_uuidCidadao ();

}