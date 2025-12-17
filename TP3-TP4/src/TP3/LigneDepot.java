package TP3;

/**
 * Classe représentant une ligne de dépôt
 * Une ligne de dépôt contient un article et le nombre d'exemplaires déposés
 */
public class LigneDepot {
    private String codeArticle; // Code de l'article déposé (ISBN ou ISSN)
    private int exemplaires; // Nombre d'exemplaires déposés
    
    /**
     * Constructeur de la classe LigneDepot
     * @param codeArticle Code de l'article (ISBN ou ISSN)
     * @param exemplaires Nombre d'exemplaires déposés
     */
    public LigneDepot(String codeArticle, int exemplaires){
        this.codeArticle = codeArticle;
        this.exemplaires = exemplaires;
    }
    

    // Getters
    public String getCodeArticle(){
        return this.codeArticle;
    }
    
    public String getNumeroIsbnIssn(){
        return this.codeArticle;
    }
    
    public int getExemplaires(){
        return this.exemplaires;
    }
    
    // Setters
    public void setExemplaires(int exemplaires){
        this.exemplaires = exemplaires;
    }
    
    public void setCodeArticle(String codeArticle){
        this.codeArticle = codeArticle;
    }
    
    /**
     * TP4 : Méthode versFichier pour sauvegarder les informations de la ligne de dépôt dans un fichier
     * Format: exemplaires : ISBN/ISSN
     * @return Chaîne de caractères formatée pour l'écriture dans un fichier
     */
    public String versFichier() {
        return exemplaires + " : " + codeArticle;
    }
}
