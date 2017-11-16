package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaAvaliacaoElegibilidadeThriftEZYER {

	java.lang.String build_uuidFicha ();

	java.lang.Integer build_tpCdsOrigem ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.UnicaLotacaoHeaderThrift build_headerTransport ();

	java.lang.String build_numeroCartaoSus ();

	java.lang.String build_nomeCidadao ();

	java.lang.String build_nomeSocialCidadao ();

	java.lang.Long build_dataNascimentoCidadao ();

	java.lang.Long build_sexoCidadao ();

	java.lang.Long build_racaCorCidadao ();

	java.lang.String build_nomeMaeCidadao ();

	java.lang.Boolean build_desconheceNomeMae ();

	java.lang.String build_codigoIbgeMunicipioNascimento ();

	java.lang.Long build_codigoNacionalidade ();

	java.lang.String build_emailCidadao ();

	java.lang.String build_numeroNisPisPasep ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.EnderecoLocalPermanenciaThrift build_endereco ();

	java.lang.Long build_atencaoDomiciliarOrigem ();

	java.lang.Long build_atencaoDomiciliarModalidade ();

	java.util.List build_situacoesPresentes ();

	java.lang.String build_cid10Principal ();

	java.lang.String build_cid10Segundo ();

	java.lang.String build_cid10Terceiro ();

	java.lang.Long build_conclusaoDestinoElegivel ();

	java.util.List build_conclusaoDestinoInelegivel ();

	java.lang.Long build_cuidadorCidadao ();

}