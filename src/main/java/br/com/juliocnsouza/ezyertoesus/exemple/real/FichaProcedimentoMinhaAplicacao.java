package br.com.juliocnsouza.ezyertoesus.exemple.real;

import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftClass;
import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftField;
import br.gov.saude.esus.cds.transport.generated.thrift.common.UnicaLotacaoHeaderThrift;
import br.gov.saude.esus.cds.transport.generated.thrift.procedimento.FichaProcedimentoChildThrift;
import br.gov.saude.esus.cds.transport.generated.thrift.procedimento.FichaProcedimentoMasterThrift;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * FichaProcedimentoMinhaAplicacao.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
@MasterThriftClass( target = FichaProcedimentoMasterThrift.class )
public class FichaProcedimentoMinhaAplicacao {

    @MasterThriftField( target = "tpCdsOrigem" ,
                        dataType = Integer.class )
    private int tipoCds;

    @MasterThriftField( target = "numTotalAfericaoPa" ,
                        dataType = Long.class )
    private long pa; // optional

    @MasterThriftField( target = "numTotalGlicemiaCapilar" ,
                        dataType = Long.class )
    private long clicemia; // optional

    @MasterThriftField( target = "numTotalAfericaoTemperatura" ,
                        dataType = Long.class )
    private long temperatura; // optional

    @MasterThriftField( target = "numTotalMedicaoAltura" ,
                        dataType = Long.class )
    private long altura; // optional

    @MasterThriftField( target = "numTotalCurativoSimples" ,
                        dataType = Long.class )
    private long curativos; // optional

    @MasterThriftField( target = "numTotalMedicaoPeso" ,
                        dataType = Long.class )
    private long peso; // optional

    @MasterThriftField( target = "numTotalColetaMaterialParaExameLaboratorial" ,
                        dataType = Long.class )
    private long coleta; // optional

    @MasterThriftField( target = "uuidFicha" )
    public String getUuidFicha() {
        return UUID.randomUUID().toString();
    }

    @MasterThriftField( target = "headerTransport" ,
                        dataType = UnicaLotacaoHeaderThrift.class )
    public UnicaLotacaoHeaderThrift getHeaderTransport() {
        UnicaLotacaoHeaderThrift ulht = new UnicaLotacaoHeaderThrift();
        ulht.setCboCodigo_2002( "2132213" );
        ulht.setCboCodigo_2002IsSet( true );
        ulht.setCnes( "480328432843204832" );
        ulht.setCnesIsSet( true );
        ulht.setCodigoIbgeMunicipio( "13213213" );
        ulht.setCodigoIbgeMunicipioIsSet( true );
        ulht.setDataAtendimento( new Date().getTime() );
        ulht.setDataAtendimentoIsSet( true );
        ulht.setIne( "32424324" );
        ulht.setIneIsSet( true );
        ulht.setProfissionalCNS( "34324324234" );
        ulht.setProfissionalCNSIsSet( true );
        return ulht;
    }

    @MasterThriftField( target = "atendProcedimentos" ,
                        dataType = List.class )
    public List<FichaProcedimentoChildThrift> getAtendProcedimentos() {
        FichaProcedimentoChildThrift ficha = new FichaProcedimentoChildThrift();
        ficha.setDtNascimento( new Date().getTime() );
        return Arrays.asList( ficha );
    }

    public int getTipoCds() {
        return tipoCds;
    }

    public void setTipoCds( int tipoCds ) {
        this.tipoCds = tipoCds;
    }

    public long getPa() {
        return pa;
    }

    public void setPa( long pa ) {
        this.pa = pa;
    }

    public long getClicemia() {
        return clicemia;
    }

    public void setClicemia( long clicemia ) {
        this.clicemia = clicemia;
    }

    public long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura( long temperatura ) {
        this.temperatura = temperatura;
    }

    public long getAltura() {
        return altura;
    }

    public void setAltura( long altura ) {
        this.altura = altura;
    }

    public long getCurativos() {
        return curativos;
    }

    public void setCurativos( long curativos ) {
        this.curativos = curativos;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso( long peso ) {
        this.peso = peso;
    }

    public long getColeta() {
        return coleta;
    }

    public void setColeta( long coleta ) {
        this.coleta = coleta;
    }

}
