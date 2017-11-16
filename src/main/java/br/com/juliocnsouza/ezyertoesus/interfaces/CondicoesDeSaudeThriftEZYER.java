package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface CondicoesDeSaudeThriftEZYER {

	java.lang.String build_descricaoCausaInternacaoEm12Meses ();

	java.lang.String build_descricaoOutraCondicao1 ();

	java.lang.String build_descricaoOutraCondicao2 ();

	java.lang.String build_descricaoOutraCondicao3 ();

	java.lang.String build_descricaoPlantasMedicinaisUsadas ();

	java.util.List build_doencaCardiaca ();

	java.util.List build_doencaRespiratoria ();

	java.util.List build_doencaRins ();

	java.lang.String build_maternidadeDeReferencia ();

	java.lang.Long build_situacaoPeso ();

	java.lang.Boolean build_statusEhDependenteAlcool ();

	java.lang.Boolean build_statusEhDependenteOutrasDrogas ();

	java.lang.Boolean build_statusEhFumante ();

	java.lang.Boolean build_statusEhGestante ();

	java.lang.Boolean build_statusEstaAcamado ();

	java.lang.Boolean build_statusEstaDomiciliado ();

	java.lang.Boolean build_statusTemDiabetes ();

	java.lang.Boolean build_statusTemDoencaRespiratoria ();

	java.lang.Boolean build_statusTemHanseniase ();

	java.lang.Boolean build_statusTemHipertensaoArterial ();

	java.lang.Boolean build_statusTemTeveCancer ();

	java.lang.Boolean build_statusTemTeveDoencasRins ();

	java.lang.Boolean build_statusTemTuberculose ();

	java.lang.Boolean build_statusTeveAvcDerrame ();

	java.lang.Boolean build_statusTeveDoencaCardiaca ();

	java.lang.Boolean build_statusTeveInfarto ();

	java.lang.Boolean build_statusTeveInternadoEm12Meses ();

	java.lang.Boolean build_statusTratamentoPsiquicoOuProblemaMental ();

	java.lang.Boolean build_statusUsaOutrasPraticasIntegrativasOuComplementares ();

	java.lang.Boolean build_statusUsaPlantaMedicinais ();

}