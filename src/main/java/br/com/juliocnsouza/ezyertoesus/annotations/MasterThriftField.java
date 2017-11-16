package br.com.juliocnsouza.ezyertoesus.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Anotação de marcação para identificar campos mapeados - no caso de metodos devem ser metodos com retorno e sem
 * argumentos similares a getters
 * <p>
 * @since 22/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
@Documented
@Target( { FIELD ,
           METHOD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface MasterThriftField {

    /**
     * para usar o valor proprio campo use THIS, para acessar um atributo do objeto use MAPPED. O uso de MAPPED implica
     * em informar o campo a ser mapaedo em lookIn
     * <p>
     * @return
     */
    FieldType type() default FieldType.THIS;

    /**
     * campo na classe Thrift alvo do mapeamento
     * <p>
     * @return
     */
    String target() default "";

    /**
     * campo do objeto mapeado em que valor - em caso de necessidade de acessar outro atributo use o operador '.'. Ex:
     * "lookIn.valor"
     * <p>
     * @return
     */
    String lookIn() default "";

    /**
     * em caso de primitivos informar o Wrapper correspondente, por defaul o metodo toString dos objetos será invocado
     * <p>
     * @return
     */
    Class<?> dataType() default String.class;

}
