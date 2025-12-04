package TP3;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Classe représentant un bon de dépôt
 * Un bon de dépôt peut contenir plusieurs lignes de dépôt
 */
public class BonDepot {
    // Numéro de téléphone du client
    private int numTel;
    // Date du dépôt
    private LocalDate dateDepot;
    // Nombre d'articles déposés
    private int nbArticleDeposes;
    // Liste des articles déposés (tableau de lignes de dépôt)
    private LigneDepot[] listArticles = new LigneDepot[5];
    // Compteur statique pour générer des identifiants uniques
    private static int numerote = 0;
    // Identifiant unique du bon de dépôt
    private int id;
    
    
    /**
     * Constructeur de la classe BonDepot
     * @param numTel Numéro de téléphone du client
     * @param dateDepot Date du dépôt
     * @param nbArticleDeposes Nombre d'articles déposés
     * @param listArticles Tableau des lignes de dépôt
     */
    public BonDepot(int numTel,LocalDate dateDepot, int nbArticleDeposes, LigneDepot[] listArticles){
        // Un bon de dépôt peut avoir des lignes de dépôt
        this.numTel = numTel;
        this.dateDepot = dateDepot;
        this.nbArticleDeposes = nbArticleDeposes;
        this.listArticles = listArticles;
        
        numerote++;
        this.id = numerote;
    }
    
    // Getters
    public int getNumTel() {
        return numTel;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }
    
    public int getNbArticleDeposes() {
        return nbArticleDeposes;
    }

    public LigneDepot[] getListArticles() {
        return listArticles;
    }
    
    public int getId() {
        return id;
    }
    
    // Setters

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
    

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }
    
    public void setNbArticleDeposes(int nbArticleDeposes) {
        this.nbArticleDeposes = nbArticleDeposes;
    }
    
    public void setListArticles(LigneDepot[] listArticles) {
        this.listArticles = listArticles;
    }

    /**
     * Question 5a : Ajouter une ligne de dépôt au bon de dépôt
     * @param numeroIsbnIssn Le numéro ISBN ou ISSN de l'article
     * @param exemplaires Le nombre d'exemplaires déposés
     * @return true si la ligne a été ajoutée, false si le tableau est plein
     */
    public boolean ajouterLigne(String numeroIsbnIssn, int exemplaires) {
        // Chercher la première position libre dans le tableau
        for (int i = 0; i < listArticles.length; i++) {
            if (listArticles[i] == null) {
                // Créer une nouvelle ligne de dépôt et l'ajouter
                listArticles[i] = new LigneDepot(numeroIsbnIssn, exemplaires);
                // Mettre à jour le nombre d'articles déposés
                nbArticleDeposes += exemplaires;
                return true;
            }
        }
        return false; // Tableau plein
    }
    
    
}
