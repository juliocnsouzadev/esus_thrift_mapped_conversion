package br.com.juliocnsouza.ezyertoesus.exemple.converter;

import br.gov.saude.esus.cds.transport.generated.thrift.atendimentodomiciliar.FichaAtendimentoDomiciliarMasterThrift;
import java.util.Date;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

/**
 * AtendimentoDoTipoMasterThrift.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class AtendimentoDoTipoMasterThrift implements
        org.apache.thrift.TBase<FichaAtendimentoDomiciliarMasterThrift , FichaAtendimentoDomiciliarMasterThrift._Fields> {

    private static final long serialVersionUID = 1L;

    private String paciente;

    private String unidade;

    private Date data;

    private int qtdProcedimentos;

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente( String paciente ) {
        this.paciente = paciente;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade( String unidade ) {
        this.unidade = unidade;
    }

    public Date getData() {
        return data;
    }

    public void setData( Date data ) {
        this.data = data;
    }

    public int getQtdProcedimentos() {
        return qtdProcedimentos;
    }

    public void setQtdProcedimentos( int qtdProcedimentos ) {
        this.qtdProcedimentos = qtdProcedimentos;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - paciente: " + paciente + ", unidade: " + unidade + ", data: " + data;
    }

    @Override
    public void read( TProtocol tp )
            throws TException {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write( TProtocol tp )
            throws TException {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FichaAtendimentoDomiciliarMasterThrift._Fields fieldForId( int i ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSet( FichaAtendimentoDomiciliarMasterThrift._Fields f ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFieldValue( FichaAtendimentoDomiciliarMasterThrift._Fields f ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFieldValue( FichaAtendimentoDomiciliarMasterThrift._Fields f , Object o ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBase<FichaAtendimentoDomiciliarMasterThrift , FichaAtendimentoDomiciliarMasterThrift._Fields> deepCopy() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo( FichaAtendimentoDomiciliarMasterThrift o ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}
