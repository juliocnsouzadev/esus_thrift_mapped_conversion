package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface FichaProcedimentoMasterThriftEZYER {

	java.lang.String build_uuidFicha ();

	java.lang.Integer build_tpCdsOrigem ();

	br.gov.saude.esus.cds.transport.generated.thrift.common.UnicaLotacaoHeaderThrift build_headerTransport ();

	java.util.List build_atendProcedimentos ();

	java.lang.Long build_numTotalAfericaoPa ();

	java.lang.Long build_numTotalGlicemiaCapilar ();

	java.lang.Long build_numTotalAfericaoTemperatura ();

	java.lang.Long build_numTotalMedicaoAltura ();

	java.lang.Long build_numTotalCurativoSimples ();

	java.lang.Long build_numTotalMedicaoPeso ();

	java.lang.Long build_numTotalColetaMaterialParaExameLaboratorial ();

}