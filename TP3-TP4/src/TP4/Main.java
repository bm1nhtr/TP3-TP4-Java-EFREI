/*
 * Classe principale pour TP4 - Gestion d'un établissement avec menu interactif
 */
package TP4;

import TP3.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Etablissement etablissement;
    private static Scanner scanner;
    private static final String FICHIER_ARTICLES = "Output/articles_TP4.txt";
    private static final String FICHIER_DEPOTS = "Output/depots_TP4.txt";
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        System.out.println("=== GESTION D'ÉTABLISSEMENT - TP4 ===\n");
        
        // Créer une instance de l'établissement
        System.out.print("Entrez le nom de l'établissement: ");
        String nomEtablissement = scanner.nextLine();
        if (nomEtablissement.trim().isEmpty()) {
            nomEtablissement = "Librairie du Centre";
        }
        etablissement = new Etablissement(nomEtablissement);
        System.out.println("Établissement créé: " + nomEtablissement + "\n");
        
        // Charger les fichiers
        System.out.println("Chargement des fichiers...");
        // Créer le dossier Output s'il n'existe pas
        java.io.File outputDir = new java.io.File("Output");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        boolean articlesCharge = etablissement.depuisFichierArticles(FICHIER_ARTICLES);
        boolean depotsCharge = etablissement.depuisFichierDepots(FICHIER_DEPOTS);
        
        if (articlesCharge) {
            System.out.println("Articles chargés depuis " + FICHIER_ARTICLES);
        } else {
            System.out.println("Aucun fichier d'articles trouvé ou erreur de chargement.");
        }
        
        if (depotsCharge) {
            System.out.println("Bons de dépôt chargés depuis " + FICHIER_DEPOTS);
        } else {
            System.out.println("Aucun fichier de dépôts trouvé ou erreur de chargement.");
        }
        System.out.println();
        
        // Afficher le menu principal
        int choix;
        do {
            afficherMenu();
            System.out.print("Votre choix: ");
            try {
                choix = Integer.parseInt(scanner.nextLine());
                traiterChoix(choix);
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide.\n");
                choix = -1;
            }
        } while (choix != 0);
        
        // Sauvegarder avant de quitter
        System.out.println("\nSauvegarde des données...");
        boolean articlesSauve = etablissement.versFichierArticles(FICHIER_ARTICLES);
        boolean depotsSauve = etablissement.versFichierDepots(FICHIER_DEPOTS);
        
        if (articlesSauve) {
            System.out.println("Articles sauvegardés dans " + FICHIER_ARTICLES);
        } else {
            System.out.println("Erreur lors de la sauvegarde des articles.");
        }
        
        if (depotsSauve) {
            System.out.println("Bons de dépôt sauvegardés dans " + FICHIER_DEPOTS);
        } else {
            System.out.println("Erreur lors de la sauvegarde des dépôts.");
        }
        
        System.out.println("\nAu revoir!");
        scanner.close();
    }
    
    /**
     * Affiche le menu principal
     */
    private static void afficherMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Lister tous les articles (triés par exemplaires)");
        System.out.println("2. Lister les bons de dépôt d'un client");
        System.out.println("3. Lister les bons de dépôt pour un article et une période");
        System.out.println("4. Ajouter un livre");
        System.out.println("5. Ajouter un magazine");
        System.out.println("6. Ajouter un manuel");
        System.out.println("7. Ajouter un bon de dépôt");
        System.out.println("8. Rechercher un article");
        System.out.println("9. Ajouter des exemplaires à un article");
        System.out.println("10. Retirer des exemplaires d'un article");
        System.out.println("0. Quitter");
        System.out.println();
    }
    
    /**
     * Traite le choix de l'utilisateur
     */
    private static void traiterChoix(int choix) {
        System.out.println();
        switch (choix) {
            case 1:
                listerArticles();
                break;
            case 2:
                listerBonsClient();
                break;
            case 3:
                listerBonsArticlePeriode();
                break;
            case 4:
                ajouterLivre();
                break;
            case 5:
                ajouterMagazine();
                break;
            case 6:
                ajouterManuel();
                break;
            case 7:
                ajouterBonDepot();
                break;
            case 8:
                rechercherArticle();
                break;
            case 9:
                ajouterExemplaires();
                break;
            case 10:
                retirerExemplaires();
                break;
            case 0:
                System.out.println("Fermeture du programme...");
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.\n");
        }
    }
    
    /**
     * Option 1: Lister tous les articles
     */
    private static void listerArticles() {
        etablissement.lister();
    }
    
    /**
     * Option 2: Lister les bons de dépôt d'un client
     */
    private static void listerBonsClient() {
        System.out.print("Entrez le numéro de téléphone du client: ");
        try {
            int numTel = Integer.parseInt(scanner.nextLine());
            etablissement.lister(numTel);
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Numéro de téléphone invalide.\n");
        }
    }
    
    /**
     * Option 3: Lister les bons de dépôt pour un article et une période
     */
    private static void listerBonsArticlePeriode() {
        System.out.print("Entrez le numéro ISBN/ISSN: ");
        String numero = scanner.nextLine().trim();
        
        System.out.print("Entrez la date de début (format: yyyy-MM-dd): ");
        try {
            LocalDate dateDebut = LocalDate.parse(scanner.nextLine().trim());
            
            System.out.print("Entrez la date de fin (format: yyyy-MM-dd): ");
            LocalDate dateFin = LocalDate.parse(scanner.nextLine().trim());
            
            etablissement.lister(numero, dateDebut, dateFin);
        } catch (Exception e) {
            System.out.println("Erreur: Format de date invalide. Utilisez le format yyyy-MM-dd.\n");
        }
    }
    
    /**
     * Option 4: Ajouter un livre
     */
    private static void ajouterLivre() {
        System.out.print("Description: ");
        String description = scanner.nextLine();
        
        System.out.print("Prix initial: ");
        try {
            double prix = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Nombre d'exemplaires: ");
            int exemplaires = Integer.parseInt(scanner.nextLine());
            
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            
            System.out.print("Nombre de pages: ");
            int pages = Integer.parseInt(scanner.nextLine());
            
            boolean reussi = etablissement.ajouterLivre(description, prix, exemplaires, isbn, pages);
            if (reussi) {
                System.out.println("Livre ajouté avec succès!\n");
            } else {
                System.out.println("Erreur: Impossible d'ajouter le livre (tableau plein).\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Format numérique invalide.\n");
        }
    }
    
    /**
     * Option 5: Ajouter un magazine
     */
    private static void ajouterMagazine() {
        System.out.print("Description: ");
        String description = scanner.nextLine();
        
        System.out.print("Prix initial: ");
        try {
            double prix = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Nombre d'exemplaires: ");
            int exemplaires = Integer.parseInt(scanner.nextLine());
            
            System.out.print("ISSN: ");
            String issn = scanner.nextLine();
            
            System.out.print("Périodicité (hebdomadaire/mensuel/trimestriel): ");
            String periodicite = scanner.nextLine();
            
            System.out.print("Date de publication (format: yyyy-MM-dd): ");
            LocalDate datePub = LocalDate.parse(scanner.nextLine().trim());
            
            boolean reussi = etablissement.ajouterMagazine(description, prix, exemplaires, issn, periodicite, datePub);
            if (reussi) {
                System.out.println("Magazine ajouté avec succès!\n");
            } else {
                System.out.println("Erreur: Impossible d'ajouter le magazine (tableau plein).\n");
            }
        } catch (Exception e) {
            System.out.println("Erreur: Format invalide.\n");
        }
    }
    
    /**
     * Option 6: Ajouter un manuel
     */
    private static void ajouterManuel() {
        System.out.print("Description: ");
        String description = scanner.nextLine();
        
        System.out.print("Prix initial: ");
        try {
            double prix = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Nombre d'exemplaires: ");
            int exemplaires = Integer.parseInt(scanner.nextLine());
            
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            
            System.out.print("Nombre de pages: ");
            int pages = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Matière: ");
            String matiere = scanner.nextLine();
            
            System.out.print("Niveau: ");
            String niveau = scanner.nextLine();
            
            boolean reussi = etablissement.ajouterManuel(description, prix, exemplaires, isbn, pages, matiere, niveau);
            if (reussi) {
                System.out.println("Manuel ajouté avec succès!\n");
            } else {
                System.out.println("Erreur: Impossible d'ajouter le manuel (tableau plein).\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Format numérique invalide.\n");
        }
    }
    
    /**
     * Option 7: Ajouter un bon de dépôt
     */
    private static void ajouterBonDepot() {
        System.out.print("Numéro de téléphone du client: ");
        try {
            int numTel = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Nombre de lignes de dépôt: ");
            int nbLignes = Integer.parseInt(scanner.nextLine());
            
            LigneDepot[] lignes = new LigneDepot[nbLignes];
            
            for (int i = 0; i < nbLignes; i++) {
                System.out.print("Ligne " + (i + 1) + " - ISBN/ISSN: ");
                String numero = scanner.nextLine();
                
                System.out.print("Ligne " + (i + 1) + " - Nombre d'exemplaires: ");
                int exemplaires = Integer.parseInt(scanner.nextLine());
                
                lignes[i] = new LigneDepot(numero, exemplaires);
            }
            
            boolean reussi = etablissement.ajouter(numTel, lignes);
            if (reussi) {
                System.out.println("Bon de dépôt ajouté avec succès!\n");
            } else {
                System.out.println("Erreur: Impossible d'ajouter le bon de dépôt (tableau plein).\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Format numérique invalide.\n");
        }
    }
    
    /**
     * Option 8: Rechercher un article
     */
    private static void rechercherArticle() {
        System.out.print("Entrez le numéro ISBN/ISSN: ");
        String numero = scanner.nextLine().trim();
        
        article art = etablissement.rechercher(numero);
        if (art != null) {
            System.out.println("Article trouvé:");
            System.out.println("  Description: " + art.getDescription());
            System.out.println("  Prix initial: " + art.getPrixInitial() + "€");
            System.out.println("  Prix actuel: " + art.calculerPrix() + "€");
            System.out.println("  Exemplaires: " + art.getNbExemplaires());
            System.out.println("  Numéro: " + art.getNumero());
            System.out.println();
        } else {
            System.out.println("Article non trouvé.\n");
        }
    }
    
    /**
     * Option 9: Ajouter des exemplaires
     */
    private static void ajouterExemplaires() {
        System.out.print("Entrez le numéro ISBN/ISSN: ");
        String numero = scanner.nextLine().trim();
        
        System.out.print("Nombre d'exemplaires à ajouter: ");
        try {
            int quantite = Integer.parseInt(scanner.nextLine());
            
            boolean reussi = etablissement.ajouter(numero, quantite);
            if (reussi) {
                System.out.println("Exemplaires ajoutés avec succès!\n");
            } else {
                System.out.println("Erreur: Article non trouvé.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Format numérique invalide.\n");
        }
    }
    
    /**
     * Option 10: Retirer des exemplaires
     */
    private static void retirerExemplaires() {
        System.out.print("Entrez le numéro ISBN/ISSN: ");
        String numero = scanner.nextLine().trim();
        
        System.out.print("Nombre d'exemplaires à retirer: ");
        try {
            int quantite = Integer.parseInt(scanner.nextLine());
            
            boolean reussi = etablissement.retirer(numero, quantite);
            if (reussi) {
                System.out.println("Exemplaires retirés avec succès!\n");
            } else {
                System.out.println("Erreur: Article non trouvé ou quantité insuffisante.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur: Format numérique invalide.\n");
        }
    }
}
