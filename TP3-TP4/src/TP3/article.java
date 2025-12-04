/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

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

    // ----------- QUESTION 4A -----------
    
    /**
     * Question 4a : Comparer deux articles pour déterminer l'ordre
     * @param autre L'autre article à comparer
     * @return true si cet article doit être placé après l'autre dans le tableau, false sinon
     */
    public boolean placerApres(article autre) {
        if (autre == null) {
            return false;
        }
        // Comparer les numéros ISBN ou ISSN en utilisant compareTo
        return this.getNumero().compareTo(autre.getNumero()) > 0;
    }
    
    /**
     * Question 4a : Augmenter le nombre d'exemplaires d'une quantité donnée
     * @param quantite La quantité à ajouter
     */
    public void ajouter(int quantite) {
        if (quantite > 0) {
            this.nbExemplaires += quantite;
        }
    }
    
    /**
     * Question 4a : Diminuer le nombre d'exemplaires d'une quantité donnée
     * @param quantite La quantité à retirer
     */
    public void retirer(int quantite) {
        if (quantite > 0 && quantite <= this.nbExemplaires) {
            this.nbExemplaires -= quantite;
        }
    }
    
    /**
     * Question 4a : Calculer le prix de l'article en tenant compte des réductions
     * Cette méthode doit être redéfinie dans les sous-classes pour appliquer les réductions spécifiques
     * @return Le prix calculé avec les réductions
     */
    public abstract double calculerPrix();
    
}
