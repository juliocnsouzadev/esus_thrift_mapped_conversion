package br.com.juliocnsouza.ezyertoesus.exemple.converter;

import br.com.juliocnsouza.ezyertoesus.converter.Conversor;
import java.util.Date;

/**
 * ExemploDeConversao.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class ExemploDeConversao {

    public static void main( String[] args )
            throws Exception {
        AtendimentoPOJO ficha = new AtendimentoPOJO();
        ficha.setDtAtendimento( new Date() );
        ficha.setNomePessoa( "Jose Alves" );
        ficha.setUbs( "Unidade Testes" );

        Conversor<AtendimentoDoTipoMasterThrift> conversor = new Conversor<>( ficha );
        AtendimentoDoTipoMasterThrift resultado = conversor.get();

        System.out.println( "ficha:\n" + ficha );

        System.out.println( "\nresultado:\n" + resultado );

    }

}
