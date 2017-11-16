package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface CadastroDomiciliarThriftEZYER {

	java.util.List build_animaisNoDomicilio ();

	br.gov.saude.esus.cds.transport.generated.thrift.cadastrodomiciliar.CondicaoMoradiaThrift build_condicaoMoradia ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.HeaderCdsCadastroThrift build_dadosGerais ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.EnderecoLocalPermanenciaThrift build_enderecoLocalPermanencia ();

	java.util.List build_familias ();

	java.lang.Boolean build_fichaAtualizada ();

	java.lang.String build_quantosAnimaisNoDomicilio ();

	java.lang.Boolean build_stAnimaisNoDomicilio ();

	java.lang.Boolean build_statusTermoRecusaCadastroDomiciliarAtencaoBasica ();

	java.lang.Integer build_tpCdsOrigem ();

	java.lang.String build_uuid ();

	java.lang.String build_uuidFichaOriginadora ();

}