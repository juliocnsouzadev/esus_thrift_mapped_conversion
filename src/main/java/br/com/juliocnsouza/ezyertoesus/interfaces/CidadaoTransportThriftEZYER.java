package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface CidadaoTransportThriftEZYER {

	java.lang.Boolean build_naoPossuiCns ();

	java.lang.String build_cns ();

	java.lang.String build_cpf ();

	java.lang.Long build_dataNascimento ();

	java.lang.Boolean build_desconheceNomeMae ();

	java.lang.String build_nomeMae ();

	java.lang.String build_email ();

	br.gov.saude.esus.thrift.definition.cidadao.EnderecoTransportThrift build_endereco ();

	java.lang.Long build_escolaridadeId ();

	java.lang.Long build_estadoCivilId ();

	java.lang.Boolean build_estrangeiro ();

	java.lang.Long build_etniaId ();

	java.lang.Boolean build_faleceu ();

	java.lang.String build_municipioNascimentoCep ();

	java.lang.String build_municipioNascimentoDne ();

	java.lang.String build_municipioNascimentoIbge ();

	java.lang.String build_nisPisPasep ();

	java.lang.String build_nomeCompleto ();

	java.lang.String build_nomeSocial ();

	java.lang.String build_numeroProntuario ();

	java.lang.String build_numeroProntuarioCnes ();

	java.lang.Long build_racaCorId ();

	br.gov.saude.esus.thrift.definition.cidadao.SexoThrift build_sexo ();

	java.lang.String build_telefoneCelular ();

	java.lang.String build_telefoneContato ();

	java.lang.String build_telefoneResidencial ();

	br.gov.saude.esus.thrift.definition.cidadao.TipoSanguineoThrift build_tipoSanguineo ();

	java.lang.String build_cboNumero ();

}