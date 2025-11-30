/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author nouar
 */
// Un livre est un article qui possède un ISBN et un nombre de pages
public class livre extends article {
    // Numéro ISBN (identifiant unique du livre)
    protected String isbn;

    // Nombre de pages du livre
    protected int nbPages;

    // Constructeur du livre
    public livre(String description, double prixInitial, int nbExemplaires,String isbn, int nbPages) {
        super(description, prixInitial, nbExemplaires); // Appel du constructeur Article
        this.isbn = isbn;
        this.nbPages = nbPages;
    }

    // Le numéro d’un livre est SON ISBN
    @Override
    public String getNumero() {
        return isbn;
    }

    // ----------- GETTERS / SETTERS -----------

    public String getIsbn() { return isbn; }
    public int getNbPages() { return nbPages; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setNbPages(int nbPages) { this.nbPages = nbPages; }
    
}
