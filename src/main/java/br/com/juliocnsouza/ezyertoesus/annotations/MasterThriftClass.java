package br.com.juliocnsouza.ezyertoesus.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Anotação de marcação para identificar classes para conversao
 * <p>
 * @since 22/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
@Documented
@Target( { TYPE } )
@Retention( RetentionPolicy.RUNTIME )
public @interface MasterThriftClass {

    /**
     * classe Thrift alvo da conversao
     * <p>
     * @return
     */
    Class<? extends org.apache.thrift.TBase> target();

}
