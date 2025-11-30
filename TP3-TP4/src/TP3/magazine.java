/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author nouar
 */
import java.time.LocalDate;
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

    
}
