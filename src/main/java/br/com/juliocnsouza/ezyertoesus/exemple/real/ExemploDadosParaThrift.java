package br.com.juliocnsouza.ezyertoesus.exemple.real;

import br.com.juliocnsouza.ezyertoesus.converter.Conversor;
import br.com.juliocnsouza.ezyertoesus.envio.InformacoesEnvioDto;
import br.com.juliocnsouza.ezyertoesus.envio.ThriftSerializer;
import br.com.juliocnsouza.ezyertoesus.envio.ZipWriter;
import br.gov.saude.esus.cds.transport.generated.thrift.procedimento.FichaProcedimentoMasterThrift;
import br.gov.saude.esus.transport.common.api.configuracaodestino.VersaoThrift;
import br.gov.saude.esus.transport.common.generated.thrift.DadoInstalacaoThrift;
import br.gov.saude.esus.transport.common.generated.thrift.DadoTransporteThrift;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

/**
 * ExemploDadosParaThrift.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class ExemploDadosParaThrift {

    public static void main( String[] args )
            throws Exception {

        // Passo 5: serializar o thrift de transporte e gerar o arquivo zip;
        ZipWriter.generateZip( Arrays.asList( get() , get() , get() ) ,
                               "exemploConversaoThrift.zip" );
    }

    private static DadoTransporteThrift get()
            throws IllegalAccessException ,
                   InstantiationException ,
                   InvocationTargetException ,
                   IllegalArgumentException ,
                   NoSuchMethodException {
        // Passo 1: criar e preencher o thrift do atendimento;

        FichaProcedimentoMinhaAplicacao ficha = getFichaProcedimentoExemplo();
        Conversor<FichaProcedimentoMasterThrift> conversor = new Conversor<>( ficha );
        FichaProcedimentoMasterThrift fichaThrift = conversor.get();
        // Passo 2: serializar o thrift do atendimento;
        byte[] dadoSerializado = ThriftSerializer.serialize( fichaThrift );
        // Passo 3: coletar as informações do envio e das instalações;
        InformacoesEnvioDto informacoesEnvioDto = new InformacoesEnvioDto();
        informacoesEnvioDto.setTipoDadoSerializado( new Random().nextLong() );
        informacoesEnvioDto.setDadoSerializado( dadoSerializado );
        informacoesEnvioDto.setUuidDadoSerializado( ficha.getUuidFicha() );
        informacoesEnvioDto.setCnesDadoSerializado( "32432432" );
        informacoesEnvioDto.setCodIbge( "323132" );
        informacoesEnvioDto.setIneDadoSerializado( "32433243" );
        // Passo 4: preencher o thrift de transporte com as informações coletadas; -- fazer builder
        DadoTransporteThrift dadoTransporteThrift = getInfoInstalacao( informacoesEnvioDto );
        return dadoTransporteThrift;
    }

    private static FichaProcedimentoMinhaAplicacao getFichaProcedimentoExemplo() {
        FichaProcedimentoMinhaAplicacao ficha = new FichaProcedimentoMinhaAplicacao();
        ficha.setAltura( 170 );
        ficha.setClicemia( 12 );
        ficha.setColeta( 11 );
        ficha.setCurativos( 1 );
        ficha.setPa( 12 );
        ficha.setPeso( 9 );
        ficha.setTemperatura( 2 );
        ficha.setTipoCds( 1 );
        return ficha;
    }

    public static DadoTransporteThrift getInfoInstalacao( InformacoesEnvioDto informacoesEnvioDto ) {
        DadoTransporteThrift dadoTransporteThrift = new DadoTransporteThrift();

        // Obrigatórios;
        dadoTransporteThrift.setCnesDadoSerializado( informacoesEnvioDto.getCnesDadoSerializado() );
        dadoTransporteThrift.setDadoSerializado( informacoesEnvioDto.getDadoSerializado() );

        DadoInstalacaoThrift originadora = new DadoInstalacaoThrift();
        originadora.setContraChave( "123456" );
        originadora.setCpfOuCnpj( "11111111111" );
        originadora.setEmail( "a@b.com" );
        originadora.setFone( "999999999" );
        originadora.setNomeOuRazaoSocial( "Nome ou Razao Social Originadora" );
        originadora.setUuidInstalacao( "UUIDUNICO111" );
        dadoTransporteThrift.setOriginadora( originadora );

        DadoInstalacaoThrift remetente = new DadoInstalacaoThrift();
        remetente.setContraChave( "789010" );
        remetente.setCpfOuCnpj( "11111111111" );
        remetente.setEmail( "b@a.com" );
        remetente.setFone( "98888888" );
        remetente.setNomeOuRazaoSocial( "Nome ou Razao Social Remetente" );
        remetente.setUuidInstalacao( "UUIDUNICO222" );
        dadoTransporteThrift.setRemetente( remetente );

        dadoTransporteThrift.setTipoDadoSerializado( informacoesEnvioDto.getTipoDadoSerializado() );
        dadoTransporteThrift.setUuidDadoSerializado( informacoesEnvioDto.getUuidDadoSerializado() );

        // Opcionais;
        String codIbge = informacoesEnvioDto.getCodIbge();
        dadoTransporteThrift.setCodIbge( codIbge == null
                                         ? ""
                                         : codIbge );

        String ineDadoSerializado = informacoesEnvioDto.getIneDadoSerializado();
        dadoTransporteThrift.setIneDadoSerializado( ineDadoSerializado == null
                                                    ? ""
                                                    : ineDadoSerializado );

        Long numLote = informacoesEnvioDto.getNumLote();
        dadoTransporteThrift.setNumLote( numLote == null
                                         ? 0l
                                         : numLote );

        VersaoThrift versaoThrift = new VersaoThrift();
        versaoThrift.setMajor( 1 );
        versaoThrift.setMinor( 0 );
        versaoThrift.setRevision( 0 );
        dadoTransporteThrift.setVersao( versaoThrift );

        return dadoTransporteThrift;
    }

}
