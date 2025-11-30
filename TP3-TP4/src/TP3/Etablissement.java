package TP3;

/**
 * Classe représentant un établissement (boutique)
 * Un établissement contient des articles et des bons de dépôt
 */
public class Etablissement {
    // Nom de la boutique
    private String nomBoutique;
    // Tableau des articles disponibles dans la boutique
    private article[] Articles = new article[5];
    // Tableau des bons de dépôt de l'établissement
    private BonDepot[] BonDepots = new BonDepot[5];
    // Compteur pour le nombre d'articles
    private int nbArticles = 0;
    // Compteur pour le nombre de bons de dépôt
    private int nbBonDepots = 0;
    
    /**
     * Constructeur par défaut de la classe Etablissement
     */
    public Etablissement() {
    }
    
    /**
     * Constructeur de la classe Etablissement
     * @param nomBoutique Nom de la boutique
     */
    public Etablissement(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }
    
    // Getters
    public String getNomBoutique() {
        return nomBoutique;
    }
    
    public article[] getArticles() {
        return Articles;
    }
    
    public BonDepot[] getBonDepots() {
        return BonDepots;
    }
    
    public int getNbArticles() {
        return nbArticles;
    }
    
    public int getNbBonDepots() {
        return nbBonDepots;
    }
    
    // Setters
    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }
    
    public void setArticles(article[] Articles) {
        this.Articles = Articles;
    }
    
    public void setBonDepots(BonDepot[] BonDepots) {
        this.BonDepots = BonDepots;
    }
    
    /**
     * Question 4a : Ajouter un article au stock de l'établissement
     * @param art L'article à ajouter
     * @return true si l'article a été ajouté, false si le tableau est plein
     */
    public boolean ajouterArticle(article art) {
        if (nbArticles < Articles.length) {
            Articles[nbArticles] = art;
            nbArticles++;
            return true;
        }
        return false; // Tableau plein
    }
    
    /**
     * Question 4c : Calculer le nombre total d'exemplaires déposés pour un article donné
     * @param codeArticle Le code de l'article recherché
     * @return Le nombre total d'exemplaires déposés pour cet article
     */
    public int nombreExemplairesDeposes(int codeArticle) {
        int total = 0;
        for (int i = 0; i < nbBonDepots; i++) {
            if (BonDepots[i] != null) {
                LigneDepot[] lignes = BonDepots[i].getListArticles();
                for (int j = 0; j < lignes.length && lignes[j] != null; j++) {
                    if (lignes[j].getCodeArticle() == codeArticle) {
                        total += lignes[j].getExemplaires();
                    }
                }
            }
        }
        return total;
    }
    
    /**
     * Ajouter un bon de dépôt à l'établissement
     * @param bon Le bon de dépôt à ajouter
     * @return true si le bon a été ajouté, false si le tableau est plein
     */
    public boolean ajouterBonDepot(BonDepot bon) {
        if (nbBonDepots < BonDepots.length) {
            BonDepots[nbBonDepots] = bon;
            nbBonDepots++;
            return true;
        }
        return false; // Tableau plein
    }
    
    /**
     * Question 5a : Rechercher un article par son numéro (ISBN ou ISSN)
     * @param numero Le numéro de l'article (ISBN ou ISSN)
     * @return L'article trouvé, null si non trouvé
     */
    public article rechercherArticleParNumero(String numero) {
        for (int i = 0; i < nbArticles; i++) {
            if (Articles[i] != null && Articles[i].getNumero().equals(numero)) {
                return Articles[i];
            }
        }
        return null; // Article non trouvé
    }
}

