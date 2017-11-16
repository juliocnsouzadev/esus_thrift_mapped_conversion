package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaVisitaDomiciliarMasterThriftEZYER {

	java.lang.String build_uuidFicha ();

	java.lang.Integer build_tpCdsOrigem ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.UnicaLotacaoHeaderThrift build_headerTransport ();

	java.util.List build_visitasDomiciliares ();

}