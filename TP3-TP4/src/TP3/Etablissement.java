package TP3;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

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

    // ========== TP4 - MÉTHODES LISTER ==========
    
    /**
     * TP4 : Afficher l'ensemble des articles avec leur prix à la date courante,
     * rangés par ordre croissant du nombre d'exemplaires
     */
    public void lister() {
        // Créer une copie du tableau pour ne pas modifier l'original
        article[] articlesTries = new article[nbArticles];
        for (int i = 0; i < nbArticles; i++) {
            articlesTries[i] = Articles[i];
        }
        
        // Trier par nombre d'exemplaires croissant
        Arrays.sort(articlesTries, 0, nbArticles, new Comparator<article>() {
            @Override
            public int compare(article a1, article a2) {
                if (a1 == null && a2 == null) return 0;
                if (a1 == null) return 1;
                if (a2 == null) return -1;
                return Integer.compare(a1.getNbExemplaires(), a2.getNbExemplaires());
            }
        });
        
        // Afficher les articles
        System.out.println("=== Liste des articles (triés par nombre d'exemplaires croissant) ===");
        for (int i = 0; i < nbArticles; i++) {
            if (articlesTries[i] != null) {
                System.out.println("  - " + articlesTries[i].getDescription() + 
                                 " | Prix actuel: " + articlesTries[i].calculerPrix() + "€" +
                                 " | Exemplaires: " + articlesTries[i].getNbExemplaires() +
                                 " | Numéro: " + articlesTries[i].getNumero());
            }
        }
        System.out.println();
    }
    
    /**
     * TP4 : Afficher l'ensemble des bons de dépôt correspondant à un client donné
     * (identifié par son numéro de téléphone), rangés par date (la plus récente en dernier)
     * @param numTel Numéro de téléphone du client
     */
    public void lister(int numTel) {
        // Créer un tableau temporaire pour stocker les bons du client
        BonDepot[] bonsClient = new BonDepot[nbBonDepots];
        int nbBonsClient = 0;
        
        // Filtrer les bons du client
        for (int i = 0; i < nbBonDepots; i++) {
            if (BonDepots[i] != null && BonDepots[i].getNumTel() == numTel) {
                bonsClient[nbBonsClient] = BonDepots[i];
                nbBonsClient++;
            }
        }
        
        if (nbBonsClient == 0) {
            System.out.println("Aucun bon de dépôt trouvé pour le numéro de téléphone: " + numTel);
            return;
        }
        
        // Trier par date (plus récente en dernier)
        Arrays.sort(bonsClient, 0, nbBonsClient, new Comparator<BonDepot>() {
            @Override
            public int compare(BonDepot b1, BonDepot b2) {
                if (b1 == null && b2 == null) return 0;
                if (b1 == null) return 1;
                if (b2 == null) return -1;
                return b1.getDateDepot().compareTo(b2.getDateDepot());
            }
        });
        
        // Afficher les bons
        System.out.println("=== Bons de dépôt pour le client " + numTel + " ===");
        for (int i = 0; i < nbBonsClient; i++) {
            if (bonsClient[i] != null) {
                System.out.println("  Bon n°" + bonsClient[i].getId() + 
                                 " | Date: " + bonsClient[i].getDateDepot() +
                                 " | Articles: " + bonsClient[i].getNbArticleDeposes());
                // Afficher les lignes de dépôt
                LigneDepot[] lignes = bonsClient[i].getListArticles();
                for (int j = 0; j < lignes.length; j++) {
                    if (lignes[j] != null) {
                        System.out.println("    - " + lignes[j].getNumeroIsbnIssn() + 
                                         " : " + lignes[j].getExemplaires() + " exemplaire(s)");
                    }
                }
            }
        }
        System.out.println();
    }
    
    /**
     * TP4 : Afficher l'ensemble des bons de dépôt réalisés pour un numéro ISBN ou ISSN précis
     * et une période donnée
     * @param numeroIsbnIssn Numéro ISBN ou ISSN à rechercher
     * @param dateDebut Date de début de la période
     * @param dateFin Date de fin de la période
     */
    public void lister(String numeroIsbnIssn, LocalDate dateDebut, LocalDate dateFin) {
        System.out.println("=== Bons de dépôt pour " + numeroIsbnIssn + 
                         " entre " + dateDebut + " et " + dateFin + " ===");
        
        boolean trouve = false;
        
        // Parcourir tous les bons de dépôt
        for (int i = 0; i < nbBonDepots; i++) {
            if (BonDepots[i] != null) {
                LocalDate dateBon = BonDepots[i].getDateDepot();
                
                // Vérifier si la date est dans la période
                if ((dateBon.isAfter(dateDebut) || dateBon.isEqual(dateDebut)) &&
                    (dateBon.isBefore(dateFin) || dateBon.isEqual(dateFin))) {
                    
                    // Vérifier si le bon contient l'article recherché
                    LigneDepot[] lignes = BonDepots[i].getListArticles();
                    for (int j = 0; j < lignes.length; j++) {
                        if (lignes[j] != null && 
                            lignes[j].getNumeroIsbnIssn().equals(numeroIsbnIssn)) {
                            
                            trouve = true;
                            System.out.println("  Bon n°" + BonDepots[i].getId() + 
                                             " | Date: " + dateBon +
                                             " | Client: " + BonDepots[i].getNumTel() +
                                             " | Exemplaires: " + lignes[j].getExemplaires());
                            break;
                        }
                    }
                }
            }
        }
        
        if (!trouve) {
            System.out.println("Aucun bon de dépôt trouvé pour " + numeroIsbnIssn + 
                             " dans la période spécifiée.");
        }
        System.out.println();
    }
    
    // ========== TP4 - MÉTHODES DE GESTION DES FICHIERS ==========
    
    /**
     * TP4 : Sauvegarder les articles dans un fichier texte
     * Format: Chaque article sur plusieurs lignes séparées
     * @param nomFichier Nom du fichier dans lequel sauvegarder
     * @return true si la sauvegarde a réussi, false sinon
     */
    public boolean versFichierArticles(String nomFichier) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(nomFichier, false); // false = écraser le fichier existant
            
            for (int i = 0; i < nbArticles; i++) {
                if (Articles[i] != null) {
                    String[] lignes = null;
                    
                    // Déterminer le type d'article et formater en conséquence
                    if (Articles[i] instanceof manuel) {
                        manuel m = (manuel) Articles[i];
                        lignes = m.versFichier();
                    } else if (Articles[i] instanceof magazine) {
                        magazine mag = (magazine) Articles[i];
                        lignes = mag.versFichier();
                    } else if (Articles[i] instanceof livre) {
                        livre l = (livre) Articles[i];
                        lignes = l.versFichier();
                    }
                    
                    // Écrire chaque ligne
                    if (lignes != null) {
                        for (String ligne : lignes) {
                            if (ligne != null && !ligne.isEmpty()) {
                                fw.write(ligne);
                                fw.write(System.lineSeparator());
                            }
                        }
                    }
                }
            }
            
            fw.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier: " + e.getMessage());
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            return false;
        }
    }
    
    /**
     * TP4 : Charger les articles depuis un fichier texte
     * Format: Chaque article sur plusieurs lignes séparées
     * @param nomFichier Nom du fichier à lire
     * @return true si le chargement a réussi, false sinon
     */
    public boolean depuisFichierArticles(String nomFichier) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(nomFichier);
            br = new BufferedReader(fr);
            
            String ligne;
            while ((ligne = br.readLine()) != null) {
                ligne = ligne.trim();
                if (ligne.isEmpty()) continue;
                
                String numero = ligne; // Première ligne : ISBN/ISSN
                
                // Lire la ligne suivante
                String ligne2 = br.readLine();
                if (ligne2 == null) break;
                ligne2 = ligne2.trim();
                
                // Parser ligne 2 : Description : prix : exemplaires : ...
                String[] parties = ligne2.split(" : ");
                if (parties.length < 3) continue;
                
                String description = parties[0].trim();
                double prix = Double.parseDouble(parties[1].trim());
                int exemplaires = Integer.parseInt(parties[2].trim());
                
                // Déterminer le type d'article
                if (numero.startsWith("ISSN") || numero.startsWith("issn") || numero.matches("\\d{8}")) {
                    // Magazine: ISSN, Description : prix : exemplaires : périodicité : datePublication
                    if (parties.length >= 5) {
                        String periodicite = parties[3].trim();
                        LocalDate datePub = LocalDate.parse(parties[4].trim());
                        ajouterMagazine(description, prix, exemplaires, numero, periodicite, datePub);
                    }
                } else {
                    // Livre ou Manuel: ISBN, Description : prix : exemplaires : pages : [matière :]
                    if (parties.length >= 4) {
                        int pages = Integer.parseInt(parties[3].trim());
                        
                        if (parties.length >= 5 && parties[4].trim().endsWith(":")) {
                            // Manuel: Description : prix : exemplaires : pages : matière :
                            String matiere = parties[4].trim().replace(":", "").trim();
                            // Lire la ligne suivante pour le niveau
                            String ligne3 = br.readLine();
                            if (ligne3 != null) {
                                String niveau = ligne3.trim();
                                ajouterManuel(description, prix, exemplaires, numero, pages, matiere, niveau);
                            }
                        } else {
                            // Livre: Description : prix : exemplaires : pages
                            ajouterLivre(description, prix, exemplaires, numero, pages);
                        }
                    }
                }
            }
            
            br.close();
            fr.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier: " + e.getMessage());
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            return false;
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format numérique dans le fichier: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * TP4 : Sauvegarder les bons de dépôt dans un fichier texte
     * Format: Chaque bon sur plusieurs lignes séparées
     * @param nomFichier Nom du fichier dans lequel sauvegarder
     * @return true si la sauvegarde a réussi, false sinon
     */
    public boolean versFichierDepots(String nomFichier) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(nomFichier, false); // false = écraser le fichier existant
            
            for (int i = 0; i < nbBonDepots; i++) {
                if (BonDepots[i] != null) {
                    String[] lignes = BonDepots[i].versFichier();
                    
                    // Écrire chaque ligne
                    for (String ligne : lignes) {
                        if (ligne != null && !ligne.isEmpty()) {
                            fw.write(ligne);
                            fw.write(System.lineSeparator());
                        }
                    }
                }
            }
            
            fw.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier: " + e.getMessage());
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            return false;
        }
    }
    
    /**
     * TP4 : Charger les bons de dépôt depuis un fichier texte
     * Format: Chaque bon sur plusieurs lignes séparées
     * @param nomFichier Nom du fichier à lire
     * @return true si le chargement a réussi, false sinon
     */
    public boolean depuisFichierDepots(String nomFichier) {
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(nomFichier);
            br = new BufferedReader(fr);
            
            // Lire toutes les lignes dans une liste
            java.util.List<String> toutesLignes = new java.util.ArrayList<>();
            String ligne;
            while ((ligne = br.readLine()) != null) {
                ligne = ligne.trim();
                if (!ligne.isEmpty()) {
                    toutesLignes.add(ligne);
                }
            }
            
            br.close();
            fr.close();
            
            // Parser les lignes
            int index = 0;
            while (index < toutesLignes.size()) {
                // Première ligne : ID
                String ligneId = toutesLignes.get(index);
                if (!ligneId.matches("^\\d+$")) {
                    index++;
                    continue;
                }
                int id = Integer.parseInt(ligneId);
                index++;
                
                if (index >= toutesLignes.size()) break;
                
                // Deuxième ligne : numTel : date : nbArticles
                String ligne2 = toutesLignes.get(index);
                if (!ligne2.contains(" : ")) {
                    index++;
                    continue;
                }
                
                String[] parties = ligne2.split(" : ");
                if (parties.length < 3) {
                    index++;
                    continue;
                }
                
                int numTel = Integer.parseInt(parties[0].trim());
                LocalDate date = LocalDate.parse(parties[1].trim());
                int nbArticles = Integer.parseInt(parties[2].trim());
                index++;
                
                // Parser les lignes de dépôt (lignes suivantes : exemplaires : ISBN/ISSN)
                LigneDepot[] lignesDepot = new LigneDepot[5];
                int nbLignes = 0;
                
                // Lire les lignes suivantes jusqu'à trouver un nombre (ID bon suivant) ou fin du fichier
                while (index < toutesLignes.size() && nbLignes < lignesDepot.length) {
                    String ligneArticle = toutesLignes.get(index);
                    
                    // Vérifier si c'est l'ID du bon suivant (uniquement un nombre, sans " : ")
                    if (ligneArticle.matches("^\\d+$") && !ligneArticle.contains(" : ")) {
                        // Peut être l'ID du bon suivant (généralement un nombre court)
                        // Mais peut aussi être un ISBN/ISSN uniquement numérique
                        // Si cette ligne n'a pas " : ", on considère que c'est l'ID du bon suivant
                        // et on s'arrête
                        break;
                    }
                    
                    // Format: exemplaires : ISBN/ISSN
                    if (ligneArticle.contains(" : ")) {
                        String[] parts = ligneArticle.split(" : ");
                        if (parts.length >= 2) {
                            try {
                                int exemplaires = Integer.parseInt(parts[0].trim());
                                String numeroIsbnIssn = parts[1].trim();
                                lignesDepot[nbLignes] = new LigneDepot(numeroIsbnIssn, exemplaires);
                                nbLignes++;
                                index++;
                            } catch (NumberFormatException e) {
                                // Format không đúng, bỏ qua
                                index++;
                                break;
                            }
                        } else {
                            index++;
                            break;
                        }
                    } else {
                        // Không phải format đúng, bỏ qua
                        index++;
                        break;
                    }
                }
                
                // Créer le bon de dépôt
                BonDepot bon = new BonDepot(numTel, date, nbArticles, lignesDepot);
                
                // Ajouter au tableau (vérifier qu'il y a de la place)
                if (nbBonDepots < BonDepots.length) {
                    BonDepots[nbBonDepots] = bon;
                    nbBonDepots++;
                }
            }
            
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier: " + e.getMessage());
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier: " + ex.getMessage());
                }
            }
            return false;
        } catch (NumberFormatException e) {
            System.err.println("Erreur de format numérique dans le fichier: " + e.getMessage());
            return false;
        }
    }

    
}

