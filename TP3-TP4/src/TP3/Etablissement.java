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

    // question 4(b) ajouter un livre, magazine ou manuel 
    // true si l'ajout a est fait avec succès, false si le tableau est plein

        //Ajouter un magazine à l'établissement
    public boolean ajouterMagazine(String description, double prixInitial, int nbExemplaires, String issn, String periodicite, String datePublication) {
        // Création d'un objet Magazine avec les informations fournies
        Magazine magazine = new Magazine(description, prixInitial, nbExemplaires, issn, periodicite, datePublication);
        // Ajout du magazine au tableau Articles via la méthode ajouterArticle
        return ajouterArticle(magazine);
    }

        //Ajouter un livre à l'établissement
    public boolean ajouterLivre(String description, double prixInitial, int nbExemplaires, String isbn, int nbPages) {
        // Création d'un objet Livre avec les informations fournies
        Livre livre = new Livre(description, prixInitial, nbExemplaires, isbn, nbPages);
        // Ajout du livre au tableau Articles via la méthode ajouterArticle
        return ajouterArticle(livre);
    }

        //Ajouter un manuel scolaire à l'établissement
    public boolean ajouterManuel(String description, double prixInitial, int nbExemplaires, String isbn, int nbPages, String matiere, String niveauScolaire) {
        // Création d'un objet ManuelScolaire avec les informations fournies
        ManuelScolaire manuel = new ManuelScolaire(description, prixInitial, nbExemplaires, isbn, nbPages, matiere, niveauScolaire);
        // Ajout du manuel au tableau Articles 
        return ajouterArticle(manuel);
    }

    //QUESTION 5B
    //Ajouter un bon de dépôt à l'établissement.
    //Le bon est automatiquement daté et numéroté.
    //numTel : Numéro de téléphone du client
    //lignesDepot : Les lignes de dépôt (articles + exemplaires)
    //true si le bon a été ajouté, false si le tableau est plein
 
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

