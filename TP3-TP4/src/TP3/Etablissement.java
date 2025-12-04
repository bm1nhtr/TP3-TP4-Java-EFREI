package TP3;
import java.time.LocalDate;

/**
 * Classe représentant un établissement (boutique)
 * Un établissement contient des articles et des bons de dépôt
 */
public class Etablissement {
    // Nom de la boutique
    private String nomBoutique;
    // Tableau des articles disponibles dans la boutique
    private article[] Articles;
    // Tableau des bons de dépôt de l'établissement
    private BonDepot[] BonDepots;
    // Compteur pour le nombre d'articles
    private int nbArticles;
    // Compteur pour le nombre de bons de dépôt
    private int nbBonDepots;
    
    /**
     * Constructeur par défaut de la classe Etablissement
     */
    public Etablissement() {
        this.Articles = new article[5];
        this.BonDepots = new BonDepot[5];
        this.nbArticles = 0;
        this.nbBonDepots = 0;
    }
    
    /**
     * Constructeur de la classe Etablissement
     * @param nomBoutique Nom de la boutique
     */
    public Etablissement(String nomBoutique) {
        this.nomBoutique = nomBoutique;
        this.Articles = new article[5];
        this.BonDepots = new BonDepot[5];
        this.nbArticles = 0;
        this.nbBonDepots = 0;
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
     * Méthode pour afficher les instances de la classe Etablissement
     * @return Une chaîne de caractères représentant l'établissement
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Établissement: ").append(nomBoutique != null ? nomBoutique : "Non défini").append("\n");
        sb.append("Nombre d'articles: ").append(nbArticles).append("\n");
        sb.append("Articles disponibles:\n");
        for (int i = 0; i < nbArticles; i++) {
            if (Articles[i] != null) {
                sb.append("  - ").append(Articles[i].toString()).append("\n");
            }
        }
        sb.append("Nombre de bons de dépôt: ").append(nbBonDepots).append("\n");
        sb.append("Bons de dépôt:\n");
        for (int i = 0; i < nbBonDepots; i++) {
            if (BonDepots[i] != null) {
                sb.append("  - Bon n°").append(BonDepots[i].getId())
                  .append(" - Tél: ").append(BonDepots[i].getNumTel())
                  .append(" - Date: ").append(BonDepots[i].getDateDepot()).append("\n");
            }
        }
        return sb.toString();
    }
    
    /**
     * Ajouter un article au stock de l'établissement
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
     * Question 4c : Rechercher un article par son numéro (ISBN ou ISSN)
     * @param numero Le numéro de l'article (ISBN ou ISSN)
     * @return L'article trouvé, null si non trouvé
     */
    public article rechercher(String numero) {
        for (int i = 0; i < nbArticles; i++) {
            if (Articles[i] != null && Articles[i].getNumero().equals(numero)) {
                return Articles[i];
            }
        }
        return null; // Article non trouvé
    }
    
    /**
     * Question 4c : Augmenter le nombre d'exemplaires d'un article
     * 
     * NOTE: Method overloading - Cette méthode a le même nom que la méthode ajouter() 
     * de la question 5b, mais avec des paramètres différents :
     * - Cette méthode (4c) : ajouter(String numeroIsbnIssn, int quantite) - augmente exemplaires d'un article existant
     * - Méthode 5b : ajouter(int numTel, LigneDepot[] lignesDepot) - ajoute un bon de dépôt
     * 
     * @param numeroIsbnIssn Le numéro ISBN ou ISSN de l'article
     * @param quantite La quantité d'exemplaires reçue
     * @return true si l'article a été trouvé et mis à jour, false sinon
     */
    public boolean ajouter(String numeroIsbnIssn, int quantite) {
        article art = rechercher(numeroIsbnIssn);
        if (art != null) {
            art.ajouter(quantite);
            return true;
        }
        return false; // Article non trouvé
    }
    
    /**
     * Question 4c : Diminuer le nombre d'exemplaires d'un article
     * @param numeroIsbnIssn Le numéro ISBN ou ISSN de l'article
     * @param quantite La quantité d'exemplaires vendue
     * @return true si l'article a été trouvé et mis à jour, false sinon
     */
    public boolean retirer(String numeroIsbnIssn, int quantite) {
        article art = rechercher(numeroIsbnIssn);
        if (art != null) {
            art.retirer(quantite);
            return true;
        }
        return false; // Article non trouvé
    }

    // question 4(b) ajouter un livre, magazine ou manuel 
    // true si l'ajout a est fait avec succès, false si le tableau est plein

        //Ajouter un magazine à l'établissement
    public boolean ajouterMagazine(String description, double prixInitial, int nbExemplaires, String issn, String periodicite, LocalDate datePublication) {
        // Création d'un objet Magazine avec les informations fournies
        magazine magazine = new magazine(description, prixInitial, nbExemplaires, issn, periodicite, datePublication);
        // Ajout du magazine au tableau Articles via la méthode ajouterArticle
        return ajouterArticle(magazine);
    }

        //Ajouter un livre à l'établissement
    public boolean ajouterLivre(String description, double prixInitial, int nbExemplaires, String isbn, int nbPages) {
        // Création d'un objet Livre avec les informations fournies
        livre livre = new livre(description, prixInitial, nbExemplaires, isbn, nbPages);
        // Ajout du livre au tableau Articles via la méthode ajouterArticle
        return ajouterArticle(livre);
    }

        //Ajouter un manuel scolaire à l'établissement
    public boolean ajouterManuel(String description, double prixInitial, int nbExemplaires, String isbn, int nbPages, String matiere, String niveauScolaire) {
        // Création d'un objet ManuelScolaire avec les informations fournies
        manuel manuel = new manuel(description, prixInitial, nbExemplaires, isbn, nbPages, matiere, niveauScolaire);
        // Ajout du manuel au tableau Articles 
        return ajouterArticle(manuel);
    }

    /**
     * Question 5b : Ajouter un bon de dépôt à l'établissement.
     * Le bon est automatiquement daté et numéroté.
     * 
     * NOTE: Method overloading - Cette méthode a le même nom que la méthode ajouter() 
     * de la question 4c, mais avec des paramètres différents :
     * - Méthode 4c : ajouter(String numeroIsbnIssn, int quantite) - augmente exemplaires d'un article existant
     * - Cette méthode (5b) : ajouter(int numTel, LigneDepot[] lignesDepot) - ajoute un bon de dépôt
     * 
     * @param numTel Numéro de téléphone du client
     * @param lignesDepot Les lignes de dépôt (articles + exemplaires)
     * @return true si le bon a été ajouté, false si le tableau est plein
     */
    public boolean ajouter(int numTel, LigneDepot[] lignesDepot) {

        //On vérifie s'il reste de la place
        if (nbBonDepots >= BonDepots.length) {
            return false;
        }

        // La date automatique
        LocalDate dateDepot = LocalDate.now();

        // Calcul du nombre total d'articles déposés
        int nbArticles = 0;
        for (LigneDepot ld : lignesDepot) {
            if (ld != null) {
                nbArticles += ld.getExemplaires();
            }
        }

        // Création automatique du bon (numéro automatique géré dans la classe BonDepot)
        BonDepot bon = new BonDepot(numTel, dateDepot, nbArticles, lignesDepot);

        // Ajout dans le tableau
        BonDepots[nbBonDepots] = bon;
        nbBonDepots++;

        return true;
    }



    
}

