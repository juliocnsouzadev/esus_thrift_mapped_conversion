package br.com.juliocnsouza.ezyertoesus.interfaces;

import br.com.juliocnsouza.ezyertoesus.util.ClassFinder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.ClassUtils;

/**
 * Generator.java -> Job:
 * <p>
 * @since 28/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
public class Generator {

    private final Class<?> modelo;
    private final StringBuilder builder;

    public Generator(
            Class<?> modelo ) {
        this.modelo = modelo;
        builder = new StringBuilder();
    }

    public static List<Class<?>> getThriftClasses()
            throws ClassNotFoundException {

        List<Class<?>> classes = new ArrayList<>();
        classes.addAll( ClassFinder.find( "br.gov.saude.esus.cds.transport.generated.thrift" ) );
        classes.addAll( ClassFinder.find( "br.gov.saude.esus.thrift.definition.cidadao" ) );
        return classes;
    }

    private static void gerar(
            Class<?> clazz )
            throws IOException {
        final Generator generator = new Generator( clazz );
        final String conteudo = generator.build();

        File arquivo = new File( generator.getCaminhoCompleto() );
        if ( !arquivo.exists() ) {
            arquivo.createNewFile();
        }
        FileWriter fw = new FileWriter( arquivo.getAbsoluteFile() );
        BufferedWriter bw = new BufferedWriter( fw );
        bw.write( conteudo );
        bw.close();
    }

    public static void main( String[] args )
            throws Exception {

        Generator.getThriftClasses().stream().forEach( clazz -> {
            try {
                gerar( clazz );
            }
            catch ( IOException ex ) {
                Logger.getLogger( Generator.class.getName() ).log( Level.SEVERE , null , ex );
            }
        } );
        System.out.println( "\n\n\nconcluido!!!!" );
    }

    public String build() {
        return builder
                .append( pacote() )
                .append( quebraLinha() )
                .append( quebraLinha() )
                .append( declaracaoInterface() )
                .append( quebraLinha() )
                .append( quebraLinha() )
                .append( metodosAbstratos() )
                .append( fim() ).toString();

    }

    public String getCaminhoCompleto() {
        String caminho = Generator.class.getPackage().getName().replaceAll( "\\." , "/" );
        final String fullPath = "src/main/java/" + caminho + "/" + getNovoNome() + ".java";
        return fullPath;
    }

    private String metodosAbstratos() {
        StringBuilder sb = new StringBuilder( "" );
        List<Field> campos = Arrays.asList( modelo.getDeclaredFields() );
        campos.stream().filter( c -> ehValido( c ) ).forEach( c -> sb
                .append( "\t" )
                .append( tipo( c ) )
                .append( espaco() )
                .append( assinatura( c ) )
                .append( espaco() )
                .append( "();" )
                .append( quebraLinha() )
                .append( quebraLinha() )
        );
        return sb.toString();
    }

    private boolean ehValido( Field c ) {
        if ( c == null ) {
            return false;
        }
        if ( c.getName().startsWith( "_" ) || c.getType().getName().contains( "[" ) ) {
            return false;
        }
        if ( c.isEnumConstant() ) {
            return false;
        }
        final int modifiers = c.getModifiers();
        if ( modifiers != 1 && modifiers != 2 && modifiers != 17 && modifiers != 18 ) {
            return false;
        }
        return true;
    }

    private String assinatura( Field c ) {
        return "build_" + c.getName();
    }

    private String tipo( Field c ) {
        Class<?> tipo = c.getType();
        if ( tipo.isPrimitive() ) {
            tipo = ClassUtils.primitiveToWrapper( tipo );
        }
        return tipo.getName();
    }

    private String espaco() {
        return " ";
    }

    private String fim() {
        return "}";
    }

    private String declaracaoInterface() {
        return "public interface " + getNovoNome() + " {";
    }

    public String getNovoNome() {
        return modelo.getSimpleName() + "EZYER";
    }

    private String pacote() {
        return "package " + this.getClass().getPackage().getName() + ";";
    }

    private String quebraLinha() {
        return "\n";
    }

}
