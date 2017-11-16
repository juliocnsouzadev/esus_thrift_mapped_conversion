package br.com.juliocnsouza.ezyertoesus.envio;

/**
 * ZipWriter.java -> Job:
 * <p>
 * @since 23/09/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (juliocnsouzadev@gmail.com)
 */
import br.gov.saude.esus.transport.common.generated.thrift.DadoTransporteThrift;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter {

    // private final static String EXTENSAO_EXPORT_V12 = ".cds";
    private final static String EXTENSAO_EXPORT_V13 = ".esus13";

    /**
     * Gera um arquivo .zip contendo os dados serializados.
     * <p>
     * @param procedimentos - a lista com os dados (thrifts) a serem serializados e armazenados no arquivo .zip
     */
    public static File generateZip( List<DadoTransporteThrift> thrifts , String caminhoArquivo ) {
        File zipFile = new File( caminhoArquivo );
        ZipOutputStream outputStream = null;

        try {
            outputStream = new ZipOutputStream( new FileOutputStream( zipFile ) );
        }
        catch ( FileNotFoundException e2 ) {
            e2.printStackTrace();
        }

        if ( outputStream != null ) {
            for ( DadoTransporteThrift thrift : thrifts ) {
                try {
                    String entryName = resolveZipEntry( thrift );
                    outputStream.putNextEntry( new ZipEntry( entryName ) );
                    byte[] data = ThriftSerializer.serialize( thrift );
                    outputStream.write( data );

                    outputStream.closeEntry();
                }
                catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
            try {
                outputStream.close();
            }
            catch ( IOException ex ) {
                Logger.getLogger( ZipWriter.class.getName() ).log( Level.SEVERE , null , ex );
            }
        }
        return zipFile;
    }

    /**
     * Gera um arquivo .zip contendo os dados serializados.
     * <p>
     * @param procedimentos - a lista com os dados (thrifts) a serem serializados e armazenados no arquivo .zip
     */
    public static void generateZip( DadoTransporteThrift thrift , String caminhoArquivo ) {
        File zipFile = new File( caminhoArquivo );
        ZipOutputStream outputStream = null;

        try {
            outputStream = new ZipOutputStream( new FileOutputStream( zipFile ) );
        }
        catch ( FileNotFoundException e2 ) {
            e2.printStackTrace();
        }

        if ( outputStream != null ) {
            // for (DadoTransporteThrift thrift : dadoTransporteThrift) {
            try {
                String entryName = resolveZipEntry( thrift );
                outputStream.putNextEntry( new ZipEntry( entryName ) );
                byte[] data = ThriftSerializer.serialize( thrift );
                outputStream.write( data );

                outputStream.closeEntry();
                outputStream.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
            // }
        }
    }

    /**
     * Determina o nome e a extensão das entradas do arquivo .zip
     * <p>
     * @param l - o arquivo thrift a ser analisado
     * @return o nome da entrada no arquivo .zip
     */
    private static String resolveZipEntry( DadoTransporteThrift thrift ) {
        String entryName = thrift.getTipoDadoSerializado() + "";

        // Realizar os testes de tipos e escolher qual o nome de cada entrada do arquivo zip gerado;
        if ( thrift.getTipoDadoSerializado() == 7 ) { // Thrift Procedimentos;
            entryName = thrift.getUuidDadoSerializado() + EXTENSAO_EXPORT_V13;
        }

        return entryName;
    }

}
