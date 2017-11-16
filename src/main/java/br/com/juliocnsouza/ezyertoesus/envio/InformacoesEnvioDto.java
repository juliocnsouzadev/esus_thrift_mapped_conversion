package br.com.juliocnsouza.ezyertoesus.envio;

import br.gov.saude.esus.transport.common.api.configuracaodestino.VersaoThrift;
import br.gov.saude.esus.transport.common.generated.thrift.DadoInstalacaoThrift;

/**
 * InformacoesEnvioDto.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class InformacoesEnvioDto {

    private String cnesDadoSerializado;
    private String codIbge;
    private byte[] dadoSerializado;
    private String ineDadoSerializado;
    private Long numLote;
    private DadoInstalacaoThrift originadora;
    private DadoInstalacaoThrift remetente;
    private Long tipoDadoSerializado;
    private String uuidDadoSerializado;
    private VersaoThrift versao;

    public InformacoesEnvioDto() {

    }

    public String getCnesDadoSerializado() {
        return cnesDadoSerializado;
    }

    public void setCnesDadoSerializado( String cnesDadoSerializado ) {
        this.cnesDadoSerializado = cnesDadoSerializado;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge( String codIbge ) {
        this.codIbge = codIbge;
    }

    public byte[] getDadoSerializado() {
        return dadoSerializado;
    }

    public void setDadoSerializado( byte[] dadoSerializado ) {
        this.dadoSerializado = dadoSerializado;
    }

    public String getIneDadoSerializado() {
        return ineDadoSerializado;
    }

    public void setIneDadoSerializado( String ineDadoSerializado ) {
        this.ineDadoSerializado = ineDadoSerializado;
    }

    public Long getNumLote() {
        return numLote;
    }

    public void setNumLote( Long numLote ) {
        this.numLote = numLote;
    }

    public DadoInstalacaoThrift getOriginadora() {
        return originadora;
    }

    public void setOriginadora( DadoInstalacaoThrift originadora ) {
        this.originadora = originadora;
    }

    public DadoInstalacaoThrift getRemetente() {
        return remetente;
    }

    public void setRemetente( DadoInstalacaoThrift remetente ) {
        this.remetente = remetente;
    }

    public Long getTipoDadoSerializado() {
        return tipoDadoSerializado;
    }

    public void setTipoDadoSerializado( Long tipoDadoSerializado ) {
        this.tipoDadoSerializado = tipoDadoSerializado;
    }

    public String getUuidDadoSerializado() {
        return uuidDadoSerializado;
    }

    public void setUuidDadoSerializado( String uuidDadoSerializado ) {
        this.uuidDadoSerializado = uuidDadoSerializado;
    }

    public VersaoThrift getVersao() {
        return versao;
    }

    public void setVersao( VersaoThrift versao ) {
        this.versao = versao;
    }

}
