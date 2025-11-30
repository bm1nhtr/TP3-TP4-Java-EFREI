/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author nouar
 */
// Classe mère abstraite : représente un article général
public abstract class article {
     // Description de l’article (titre, nom…)
    private String description;

    // Prix initial avant réduction
    private double prixInitial;

    // Nombre d’exemplaires en stock
    private int nbExemplaires;

    // Constructeur commun à tous les articles
    public article(String description, double prixInitial, int nbExemplaires) {
        this.description = description;
        this.prixInitial = prixInitial;
        this.nbExemplaires = nbExemplaires;
    }

    // Méthode abstraite : chaque article a un numéro différent (ISBN ou ISSN)
    // Les sous-classes DOIVENT l’implémenter
    public abstract String getNumero();

    // ----------- GETTERS / SETTERS -----------

    public String getDescription() { return description; }
    public double getPrixInitial() { return prixInitial; }
    public int getNbExemplaires() { return nbExemplaires; }

    public void setDescription(String description) { this.description = description; }
    public void setPrixInitial(double prixInitial) { this.prixInitial = prixInitial; }
    public void setNbExemplaires(int nbExemplaires) { this.nbExemplaires = nbExemplaires; }

    
}
