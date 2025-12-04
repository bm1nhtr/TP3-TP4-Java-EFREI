package TP3.Utiles;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Classe utilitaire pour écrire simultanément dans la console et dans un fichier
 * @author minhm
 */
public class DualOutputStream extends OutputStream {
    private PrintStream console;
    private PrintStream file;
    
    /**
     * Constructeur
     * @param console Le PrintStream pour la console
     * @param file Le PrintStream pour le fichier
     */
    public DualOutputStream(PrintStream console, PrintStream file) {
        this.console = console;
        this.file = file;
    }
    
    @Override
    public void write(int b) throws IOException {
        console.write(b);
        file.write(b);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        console.write(b);
        file.write(b);
    }
    
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        console.write(b, off, len);
        file.write(b, off, len);
    }
    
    @Override
    public void flush() throws IOException {
        console.flush();
        file.flush();
    }
    
    @Override
    public void close() throws IOException {
        // Ne pas fermer la console (System.out), seulement le fichier
        file.close();
    }
}

