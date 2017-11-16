package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaAtendimentoOdontologicoMasterThriftEZYER {

	java.lang.String build_uuidFicha ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.VariasLotacoesHeaderThrift build_headerTransport ();

	java.util.List build_atendimentosOdontologicos ();

	java.lang.Integer build_tpCdsOrigem ();

}