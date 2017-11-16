package br.com.juliocnsouza.ezyertoesus.exemple.converter;

import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftClass;
import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftField;
import java.util.Date;
import java.util.Random;

/**
 * AtendimentoPOJO.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
@MasterThriftClass( target = AtendimentoDoTipoMasterThrift.class )
public class AtendimentoPOJO {

    @MasterThriftField( target = "paciente" )
    private String nomePessoa;

    @MasterThriftField( target = "unidade" )
    private String ubs;

    @MasterThriftField( target = "data" ,
                        dataType = Date.class )
    private Date dtAtendimento;

    @MasterThriftField( dataType = Integer.class ,
                        target = "qtdProcedimentos" )
    public int contadoProcedimentos() {
        return new Random().nextInt();
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa( String nomePessoa ) {
        this.nomePessoa = nomePessoa;
    }

    public String getUbs() {
        return ubs;
    }

    public void setUbs( String ubs ) {
        this.ubs = ubs;
    }

    public Date getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento( Date dtAtendimento ) {
        this.dtAtendimento = dtAtendimento;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - nomePessoa: " + nomePessoa + ", ubs: " + ubs + ", dtAtendimento: " + dtAtendimento;
    }

}
