package TP3;

/**
 * Classe représentant une ligne de dépôt
 * Une ligne de dépôt contient un article et le nombre d'exemplaires déposés
 */
public class LigneDepot {
    private int codeArticle; // Code de l'article déposé
    private int exemplaires; // Nombre d'exemplaires déposés
    
    /**
     * Constructeur de la classe LigneDepot
     * @param codeArticle Code de l'article
     * @param exemplaires Nombre d'exemplaires déposés
     */
    public LigneDepot(int codeArticle, int exemplaires){
        this.codeArticle = codeArticle;
        this.exemplaires = exemplaires;
    }
    

    // Getters
    public int getcodeArticle(){
        return this.codeArticle;
    }
    
    public int getexemplaires(){
        return this.exemplaires;
    }
    
    // Setters
    public void setexemplaires(int exemplaires){
        this.exemplaires = exemplaires;
    }
    
    public void setcodeArticle(int codeArticle){
        this.codeArticle = codeArticle;
    }
}
