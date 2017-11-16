package br.com.juliocnsouza.ezyertoesus.interfaces;

public interface PerguntaQuestionarioCriancasComMaisDoisAnosThriftEZYER {

	br.gov.saude.esus.cds.transport.generated.thrift.consumoalimentar.PerguntaCriancasComMaisDoisAnosEnumThrift build_pergunta ();

	br.gov.saude.esus.cds.transport.generated.thrift.consumoalimentar.RespostaUnicaEscolhaEnumThrift build_respostaUnicaEscolha ();

	java.util.List build_respostaMultiplaEscolha ();

}