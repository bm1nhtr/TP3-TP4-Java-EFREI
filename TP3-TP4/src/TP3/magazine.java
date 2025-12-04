/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3;

/**
 *
 * @author nouar
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
// Un magazine est un article avec ISSN + périodicité + date de publication
public class magazine extends article {
    // Identifiant unique des magazines
    private String issn;

    // périodicité : hebdomadaire, mensuel ou trimestriel
    private String periodicite;

    // Date de publication
    private LocalDate datePublication;

    // Constructeur
    public magazine(String description, double prixInitial, int nbExemplaires,
                    String issn, String periodicite, LocalDate datePublication) {
        super(description, prixInitial, nbExemplaires);
        this.issn = issn;
        this.periodicite = periodicite;
        this.datePublication = datePublication;
    }

    // Le numéro d’un magazine est son ISSN
    @Override
    public String getNumero() {
        return issn;
    }

    // ----------- GETTERS / SETTERS -----------

    public String getIssn() { return issn; }
    public String getPeriodicite() { return periodicite; }
    public LocalDate getDatePublication() { return datePublication; }

    public void setIssn(String issn) { this.issn = issn; }
    public void setPeriodicite(String periodicite) { this.periodicite = periodicite; }
    public void setDatePublication(LocalDate datePublication) { this.datePublication = datePublication; }

    /**
     * Question 4a : Calculer le prix du magazine en tenant compte des réductions
     * - Hebdomadaire: > 2 semaines = 50%, > 4 semaines = 75%
     * - Mensuel: > 2 mois = 50%, > 4 mois = 75%
     * - Trimestriel: > 2 trimestres = 50%, > 4 trimestres = 75%
     * @return Le prix calculé avec les réductions
     */
    @Override
    public double calculerPrix() {
        LocalDate aujourdhui = LocalDate.now();
        long duree;
        
        // Calculer la durée selon la périodicité
        if (periodicite.equalsIgnoreCase("hebdomadaire")) {
            duree = ChronoUnit.WEEKS.between(datePublication, aujourdhui);
            if (duree > 4) {
                return getPrixInitial() * 0.25; // Réduction 75%
            } else if (duree > 2) {
                return getPrixInitial() * 0.5; // Réduction 50%
            }
        } else if (periodicite.equalsIgnoreCase("mensuel")) {
            duree = ChronoUnit.MONTHS.between(datePublication, aujourdhui);
            if (duree > 4) {
                return getPrixInitial() * 0.25; // Réduction 75%
            } else if (duree > 2) {
                return getPrixInitial() * 0.5; // Réduction 50%
            }
        } else if (periodicite.equalsIgnoreCase("trimestriel")) {
            // 1 trimestre = 3 mois
            long mois = ChronoUnit.MONTHS.between(datePublication, aujourdhui);
            duree = mois / 3;
            if (duree > 4) {
                return getPrixInitial() * 0.25; // Réduction 75%
            } else if (duree > 2) {
                return getPrixInitial() * 0.5; // Réduction 50%
            }
        }
        
        return getPrixInitial(); // Pas de réduction
    }
    
}
