package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaAtendimentoIndividualMasterThriftEZYER {

	br.gov.saude.esus.cds.transport.generated.thrift.common.VariasLotacoesHeaderThrift build_headerTransport ();

	java.util.List build_atendimentosIndividuais ();

	java.lang.String build_uuidFicha ();

	java.lang.Integer build_tpCdsOrigem ();

}