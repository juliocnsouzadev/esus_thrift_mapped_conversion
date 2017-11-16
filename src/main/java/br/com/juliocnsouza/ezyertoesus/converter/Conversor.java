package br.com.juliocnsouza.ezyertoesus.converter;

import br.com.juliocnsouza.ezyertoesus.annotations.FieldType;
import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftClass;
import br.com.juliocnsouza.ezyertoesus.annotations.MasterThriftField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.ClassUtils;
import org.apache.thrift.TBase;

/**
 * Conversor.java -> Job:
 * <p>
 * @since 22/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class Conversor<T extends TBase> {

    private Class<? extends Object> classeSeuObjeto;
    private Class<? extends TBase> classeAlvo;
    private TBase objetoAlvo;

    public T get() {
        if ( objetoAlvo == null ) {
            return null;
        }
        return ( T ) objetoAlvo;
    }

    public Conversor( Object seuObjetoMapeado )
            throws NoSuchMethodException ,
                   InstantiationException ,
                   IllegalAccessException ,
                   IllegalArgumentException ,
                   InvocationTargetException {
        init( seuObjetoMapeado );
    }

    public final void init( Object seuObjetoMapeado )
            throws NoSuchMethodException ,
                   InstantiationException ,
                   IllegalAccessException ,
                   IllegalArgumentException ,
                   InvocationTargetException {
        verficarObjetoRecebido( seuObjetoMapeado );

        if ( classeSeuObjeto.getDeclaredFields() != null ) {
            popularPelosCamposMapeados( seuObjetoMapeado );
        }
        if ( classeSeuObjeto.getDeclaredMethods() != null ) {
            popularPelosMetodosMepados( seuObjetoMapeado );
        }

    }

    private void popularPelosCamposMapeados( Object seuObjetoMapeado )
            throws SecurityException {
        List<Field> camposSeuObjeto = Arrays.asList( classeSeuObjeto.getDeclaredFields() );
        camposSeuObjeto.stream()
                .filter( campoMapeado -> campoMapeado.getDeclaredAnnotation( MasterThriftField.class ) != null )
                .forEach( campoMapeado -> {
                    setValor( campoMapeado , seuObjetoMapeado );
                } );
    }

    private void popularPelosMetodosMepados( Object seuObjetoMapeado ) {
        List<Method> metodosAsListSeuObjeto = Arrays.asList( classeSeuObjeto.getDeclaredMethods() );
        metodosAsListSeuObjeto.stream()
                .filter( m -> m.getDeclaredAnnotation( MasterThriftField.class ) != null )
                .forEach( m -> {
                    setValor( m , seuObjetoMapeado );
                } );
    }

    private void setValor( Field campoMapeado , Object seuObjetoMapeado ) {
        campoMapeado.setAccessible( true );
        MasterThriftField masterField = campoMapeado.getDeclaredAnnotation( MasterThriftField.class );
        FieldType tipoCampo = masterField.type();

        String olharEm = masterField.lookIn();
        if ( tipoCampo.equals( FieldType.MAPPED ) && ( olharEm == null || olharEm.isEmpty() ) ) {
            throw new IllegalArgumentException(
                    "o campo " + campoMapeado.getName() + " esta anotado como sendo do tipo 'MAPPED', porem nao foi declarado valor no 'lookIn' da anotação" );
        }

        if ( tipoCampo.equals( FieldType.THIS ) ) {
            setValor( masterField , campoMapeado , seuObjetoMapeado );
            return;
        }

        String[] partes = olharEm.split( "\\." );
        if ( partes == null || partes.length == 0 ) {
            throw new IllegalArgumentException(
                    "o campo " + campoMapeado.getName() + " esta anotado como sendo do tipo 'MAPPED', porem nao a sintaxe no 'lookIn' da anotação está incorreto: " + olharEm + ". O correto é 'algo.outracoisa'" );
        }
        for ( String parte : partes ) {
            //TODO implemetar objetos complexos
            throw new UnsupportedOperationException( "objetos complexos ainda não implementado" );
        }

    }

    private void setValor( MasterThriftField masterField , Field campoMapeado , Object seuObjetoMapeado )
            throws IllegalArgumentException {
        String nomeCampoAlvo = masterField.target();
        if ( nomeCampoAlvo == null || nomeCampoAlvo.isEmpty() ) {
            throw new IllegalArgumentException( "nao foi informado 'target' para o campo " + campoMapeado.getName() );
        }
        Class<?> tipoDadoCampoAlvo = masterField.dataType();
        if ( tipoDadoCampoAlvo == null ) {
            throw new IllegalArgumentException( "nao foi informado 'dataType' para o campo " + campoMapeado.getName() );
        }

        try {
            Field campoNaClasseAlvo = classeAlvo.getDeclaredField( nomeCampoAlvo );
            campoNaClasseAlvo.setAccessible( true );
            final Class<?> tipoCampoClasseAlvo = campoNaClasseAlvo.getType();

            if ( ehDoMesmoTipo( tipoCampoClasseAlvo , tipoDadoCampoAlvo ) ) {
                throw new IllegalArgumentException(
                        "o 'dataType' para o campo " + nomeCampoAlvo + " não é o mesmo do tipo declarado na classe target " + classeAlvo.getSimpleName() + ". Tipo do campo na classe alvo " + tipoCampoClasseAlvo + ", tipo de dado declarado no @MasterField: " + tipoDadoCampoAlvo );
            }

            System.out.println( "nome campo a ser setado: " + campoNaClasseAlvo.getName() );
            final Object valorParaOCampo = campoMapeado.get( seuObjetoMapeado );
            System.out.println( "valor para o campo: " + valorParaOCampo );

            campoNaClasseAlvo.set( objetoAlvo , valorParaOCampo );
        }
        catch ( NoSuchFieldException |
                SecurityException ex ) {
            throw new IllegalArgumentException(
                    "nao foi encontrado o campo " + nomeCampoAlvo + " na classe alvo " + classeAlvo.getSimpleName() + ". Detalhes: " + ex );
        }
        catch ( IllegalArgumentException |
                IllegalAccessException ex ) {
            throw new IllegalArgumentException(
                    "tipo de dado mapeado (" + nomeCampoAlvo + ") nao condiz com tip na classe alvo " + classeAlvo.getSimpleName() + ". Detalhes:" + ex );
        }
    }

    private static boolean ehDoMesmoTipo(
            Class<?> tipoCampoClasseAlvo ,
            Class<?> tipoDadoCampoAlvo ) {
        if ( tipoCampoClasseAlvo.isPrimitive() ) {
            tipoCampoClasseAlvo = ClassUtils.primitiveToWrapper( tipoDadoCampoAlvo );
        }
        return !tipoCampoClasseAlvo.equals( tipoDadoCampoAlvo );
    }

    private void verficarObjetoRecebido( Object seuObjetoMapeado )
            throws InvocationTargetException ,
                   IllegalAccessException ,
                   NoSuchMethodException ,
                   RuntimeException ,
                   IllegalArgumentException ,
                   SecurityException ,
                   InstantiationException {
        if ( seuObjetoMapeado == null ) {
            throw new IllegalArgumentException( "o objeto informado não pode ser nulo" );
        }
        classeSeuObjeto = seuObjetoMapeado.getClass();
        Annotation masterClass = classeSeuObjeto.getDeclaredAnnotation( MasterThriftClass.class );
        if ( masterClass == null ) {
            throw new IllegalArgumentException( "a classe do objeto informado deve estar anotada com @MasterThriftClass" );
        }
        classeAlvo = ( ( MasterThriftClass ) masterClass ).target();
        if ( classeAlvo == null ) {
            throw new IllegalArgumentException(
                    "você deve informar o target na anotação @MasterThriftClass de " + classeSeuObjeto.getSimpleName() );
        }

        Constructor<? extends TBase> construtorAlvo = classeAlvo.getConstructor();
        construtorAlvo.setAccessible( true );
        objetoAlvo = construtorAlvo.newInstance();
        if ( objetoAlvo == null ) {
            throw new RuntimeException( "erro ao instanciar objeto do tipo " + classeAlvo.getSimpleName() );
        }
    }

    private void setValor( Method metodo , Object seuObjetoMapeado ) {
        metodo.setAccessible( true );
        MasterThriftField masterField = metodo.getDeclaredAnnotation( MasterThriftField.class );
        FieldType tipometodo = masterField.type();

        String olharEm = masterField.lookIn();
        if ( tipometodo.equals( FieldType.MAPPED ) && ( olharEm == null || olharEm.isEmpty() ) ) {
            throw new IllegalArgumentException(
                    "o metodo " + metodo.getName() + " esta anotado como sendo do tipo 'MAPPED', porem nao foi declarado valor no 'lookIn' da anotação" );
        }

        if ( tipometodo.equals( FieldType.THIS ) ) {
            setValor( masterField , metodo , seuObjetoMapeado );
            return;
        }

        String[] partes = olharEm.split( "\\." );
        if ( partes == null || partes.length == 0 ) {
            throw new IllegalArgumentException(
                    "o metodo " + metodo.getName() + " esta anotado como sendo do tipo 'MAPPED', porem nao a sintaxe no 'lookIn' da anotação está incorreto: " + olharEm + ". O correto é 'algo.outracoisa'" );
        }
        for ( String parte : partes ) {
            //TODO implemetar objetos complexos
            throw new UnsupportedOperationException( "objetos complexos ainda não implementado" );
        }

    }

    private void setValor( MasterThriftField masterField , Method metodoMapeado , Object seuObjetoMapeado )
            throws IllegalArgumentException {
        String nomemetodoAlvo = masterField.target();
        if ( nomemetodoAlvo == null || nomemetodoAlvo.isEmpty() ) {
            throw new IllegalArgumentException( "nao foi informado 'target' para o metodo " + metodoMapeado.getName() );
        }
        Class<?> tipoDadometodoAlvo = masterField.dataType();
        if ( tipoDadometodoAlvo == null ) {
            throw new IllegalArgumentException( "nao foi informado 'dataType' para o metodo " + metodoMapeado.getName() );
        }
        try {
            Field metodoNaClasseAlvo = classeAlvo.getDeclaredField( nomemetodoAlvo );
            metodoNaClasseAlvo.setAccessible( true );

            if ( ehDoMesmoTipo( metodoNaClasseAlvo.getType() , tipoDadometodoAlvo ) ) {
                throw new IllegalArgumentException(
                        "o 'dataType' para o metodo " + nomemetodoAlvo + " não é o mesmo do tipo declarado na classe target " + classeAlvo.getSimpleName() + ". Tipo do metodo na classe alvo " + metodoNaClasseAlvo.getType() + ", tipo de dado declarado no @MasterField: " + tipoDadometodoAlvo );
            }

            System.out.println( "nome metodo a ser setado: " + metodoNaClasseAlvo.getName() );
            final Object valorParaOmetodo = metodoMapeado.invoke( seuObjetoMapeado );
            System.out.println( "valor para o metodo: " + valorParaOmetodo );

            metodoNaClasseAlvo.set( objetoAlvo , valorParaOmetodo );
        }
        catch ( NoSuchFieldException |
                SecurityException ex ) {
            throw new IllegalArgumentException(
                    "nao foi encontrado o metodo " + nomemetodoAlvo + " na classe alvo " + classeAlvo.getSimpleName() + ". Detalhes: " + ex );
        }
        catch ( IllegalArgumentException |
                IllegalAccessException ex ) {
            throw new IllegalArgumentException(
                    "tipo de dado mapeado (" + nomemetodoAlvo + ") nao condiz com tip na classe alvo " + classeAlvo.getSimpleName() + ". Detalhes:" + ex );
        }
        catch ( InvocationTargetException ex ) {
            throw new RuntimeException(
                    "falha ao invocar o metodo " + metodoMapeado.getName() + " de " + metodoMapeado.getClass() + ", certifique-se de que o metodo nao receba parametros e nao seja void. Detelhes: " + ex );
        }
    }

}
