package TP3;
import java.time.LocalDate;
import java.io.IOException;
import java.io.PrintStream;
import TP3.Utiles.ConsoleColors;

/**
 * Classe principale pour tester les classes du TP3
 * @author minhm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Option pour sauvegarder la sortie dans un fichier
        // Décommentez la ligne suivante pour sauvegarder les résultats dans output_test.txt
        enableFileOutput();
        
        System.out.println(ConsoleColors.cyanBold("=== TEST DES CLASSES TP3 ===\n"));
        
        // Test 1: Création d'articles
        System.out.println(ConsoleColors.testHeader("1", "Création d'articles"));
        
        livre livre1 = new livre("Le Petit Prince", 15.50, 10, "978-2-07-061275-8", 96);
        System.out.println("Livre créé:");
        System.out.println("  Description: " + livre1.getDescription());
        System.out.println("  Prix: " + livre1.getPrixInitial() + "€");
        System.out.println("  Exemplaires: " + livre1.getNbExemplaires());
        System.out.println("  ISBN: " + livre1.getIsbn());
        System.out.println("  Pages: " + livre1.getNbPages());
        System.out.println("  Numéro (getNumero): " + livre1.getNumero());
        System.out.println();
        
        magazine mag1 = new magazine("Science & Vie", 5.90, 20, "ISSN-1234-5678", "Mensuel", LocalDate.of(2024, 1, 15));
        System.out.println("Magazine créé:");
        System.out.println("  Description: " + mag1.getDescription());
        System.out.println("  Prix: " + mag1.getPrixInitial() + "€");
        System.out.println("  Exemplaires: " + mag1.getNbExemplaires());
        System.out.println("  ISSN: " + mag1.getIssn());
        System.out.println("  Périodicité: " + mag1.getPeriodicite());
        System.out.println("  Date publication: " + mag1.getDatePublication());
        System.out.println("  Numéro (getNumero): " + mag1.getNumero());
        System.out.println();
        
        manuel manuel1 = new manuel("Mathématiques 3ème", 25.00, 15, "978-2-10-123456-7", 320, "Mathématiques", "Collège");
        System.out.println("Manuel créé:");
        System.out.println("  Description: " + manuel1.getDescription());
        System.out.println("  Prix: " + manuel1.getPrixInitial() + "€");
        System.out.println("  Exemplaires: " + manuel1.getNbExemplaires());
        System.out.println("  ISBN: " + manuel1.getIsbn());
        System.out.println("  Pages: " + manuel1.getNbPages());
        System.out.println("  Matière: " + manuel1.getMatiere());
        System.out.println("  Niveau: " + manuel1.getNiveau());
        System.out.println("  Numéro (getNumero): " + manuel1.getNumero());
        System.out.println();
        
        // Test 2: Création de LigneDepot
        System.out.println(ConsoleColors.testHeader("2", "Création de LigneDepot"));
        System.out.println("Création de 3 lignes de dépôt pour tester la classe LigneDepot:");
        System.out.println();
        
        // Création de la première ligne : un livre avec ISBN
        LigneDepot ligne1 = new LigneDepot("978-2-07-061275-8", 3);
        System.out.println("LigneDepot 1 (Livre avec ISBN):");
        System.out.println("  Numéro ISBN/ISSN: " + ligne1.getNumeroIsbnIssn());
        System.out.println("  Exemplaires: " + ligne1.getExemplaires());
        System.out.println();
        
        // Création de la deuxième ligne : un magazine avec ISSN
        LigneDepot ligne2 = new LigneDepot("ISSN-1234-5678", 2);
        System.out.println("LigneDepot 2 (Magazine avec ISSN):");
        System.out.println("  Numéro ISBN/ISSN: " + ligne2.getNumeroIsbnIssn());
        System.out.println("  Exemplaires: " + ligne2.getExemplaires());
        System.out.println();
        
        // Création de la troisième ligne : un manuel avec ISBN
        LigneDepot ligne3 = new LigneDepot("978-2-10-123456-7", 1);
        System.out.println("LigneDepot 3 (Manuel avec ISBN):");
        System.out.println("  Numéro ISBN/ISSN: " + ligne3.getNumeroIsbnIssn());
        System.out.println("  Exemplaires: " + ligne3.getExemplaires());
        System.out.println();
        
        // Test 3: Création de BonDepot
        System.out.println(ConsoleColors.testHeader("3", "Création de BonDepot"));
        System.out.println("Création d'un bon de dépôt contenant les 3 lignes créées précédemment:");
        System.out.println();
        
        // Création d'un tableau contenant les 3 lignes de dépôt
        LigneDepot[] lignes = {ligne1, ligne2, ligne3};
        // Création du bon de dépôt avec numéro de téléphone, date actuelle, et les lignes
        BonDepot bon1 = new BonDepot(612345678, LocalDate.now(), 3, lignes);
        
        System.out.println("BonDepot 1 créé:");
        System.out.println("  ID (numéro unique): " + bon1.getId() + " (devrait être 1)");
        System.out.println("  Numéro téléphone du déposant: " + bon1.getNumTel());
        System.out.println("  Date du dépôt: " + bon1.getDateDepot());
        System.out.println("  Nombre total d'articles déposés: " + bon1.getNbArticleDeposes());
        System.out.println("  Détail des lignes de dépôt:");
        for (int i = 0; i < bon1.getListArticles().length && bon1.getListArticles()[i] != null; i++) {
            LigneDepot ligne = bon1.getListArticles()[i];
            System.out.println("    - Ligne " + (i+1) + ": " + ligne.getNumeroIsbnIssn() + " - " + ligne.getExemplaires() + " exemplaire(s)");
        }
        System.out.println();
        
        // Test 4: Création d'un deuxième BonDepot pour vérifier l'incrémentation de l'ID
        System.out.println(ConsoleColors.testHeader("4", "Vérification de l'incrémentation automatique de l'ID"));
        System.out.println("Création d'un deuxième bon de dépôt pour vérifier que l'ID s'incrémente automatiquement:");
        System.out.println();
        
        // Création d'un nouveau bon avec une seule ligne
        LigneDepot[] lignes2 = {new LigneDepot("978-2-07-061275-8", 5)};
        BonDepot bon2 = new BonDepot(698765432, LocalDate.of(2024, 2, 1), 1, lignes2);
        
        System.out.println("BonDepot 2 créé:");
        System.out.println("  ID (numéro unique): " + bon2.getId() + " (devrait être 2, incrémenté automatiquement)");
        System.out.println("  Numéro téléphone du déposant: " + bon2.getNumTel());
        System.out.println("  Date du dépôt: " + bon2.getDateDepot());
        System.out.println("  Nombre total d'articles déposés: " + bon2.getNbArticleDeposes());
        System.out.println();
        
        // Test 5: Question 4a - Ajouter des articles à un établissement
        System.out.println(ConsoleColors.testHeader("5", "Question 4a - Ajouter des articles à un établissement"));
        
        Etablissement etablissement = new Etablissement("Librairie du Centre");
        System.out.println("Établissement créé: " + etablissement.getNomBoutique());
        System.out.println();
        
        // Ajouter des articles
        boolean ajout1 = etablissement.ajouterArticle(livre1);
        boolean ajout2 = etablissement.ajouterArticle(mag1);
        boolean ajout3 = etablissement.ajouterArticle(manuel1);
        
        System.out.println("Ajout livre1: " + (ajout1 ? " Réussi" : " Échec"));
        System.out.println("Ajout mag1: " + (ajout2 ? " Réussi" : " Échec"));
        System.out.println("Ajout manuel1: " + (ajout3 ? " Réussi" : " Échec"));
        System.out.println("Nombre d'articles dans l'établissement: " + etablissement.getNbArticles());
        System.out.println();
        
        // Test 6: Question 4a - Test des méthodes de la hiérarchie d'articles
        System.out.println(ConsoleColors.testHeader("6", "Question 4a - Méthodes de la hiérarchie d'articles"));
        
        // Test placerApres
        System.out.println("Test placerApres():");
        boolean livreApresMag = livre1.placerApres(mag1);
        System.out.println("  livre1.placerApres(mag1): " + livreApresMag + " (compare ISBN vs ISSN)");
        boolean magApresLivre = mag1.placerApres(livre1);
        System.out.println("  mag1.placerApres(livre1): " + magApresLivre);
        System.out.println();
        
        // Test ajouter (augmenter exemplaires)
        System.out.println("Test ajouter() - Augmenter exemplaires:");
        System.out.println("  Exemplaires avant: " + livre1.getNbExemplaires());
        livre1.ajouter(5);
        System.out.println("  Après ajouter(5): " + livre1.getNbExemplaires() + " (devrait être 15)");
        System.out.println();
        
        // Test retirer (diminuer exemplaires)
        System.out.println("Test retirer() - Diminuer exemplaires:");
        System.out.println("  Exemplaires avant: " + livre1.getNbExemplaires());
        livre1.retirer(3);
        System.out.println("  Après retirer(3): " + livre1.getNbExemplaires() + " (devrait être 12)");
        System.out.println();
        
        // Test calculerPrix
        System.out.println("Test calculerPrix():");
        System.out.println("  Prix initial livre1: " + livre1.getPrixInitial() + "€");
        System.out.println("  Prix calculé livre1: " + livre1.calculerPrix() + "€ (réduction 50% en avril)");
        System.out.println("  Prix initial mag1: " + mag1.getPrixInitial() + "€");
        System.out.println("  Prix calculé mag1: " + mag1.calculerPrix() + "€ (selon date publication)");
        System.out.println();
        
        // Test 7: Question 4c - Rechercher, ajouter et retirer exemplaires dans Etablissement
        System.out.println(ConsoleColors.testHeader("7", "Question 4c - Gérer exemplaires dans Etablissement"));
        
        // Rechercher un article
        System.out.println("Test rechercher():");
        article articleTrouve1 = etablissement.rechercher("978-2-07-061275-8");
        if (articleTrouve1 != null) {
            System.out.println("  Article trouvé (ISBN 978-2-07-061275-8): " + articleTrouve1.getDescription());
            System.out.println("  Exemplaires actuels: " + articleTrouve1.getNbExemplaires());
        } else {
            System.out.println("  Article non trouvé");
        }
        System.out.println();
        
        // Ajouter exemplaires via Etablissement
        System.out.println("Test ajouter() - Augmenter exemplaires via Etablissement:");
        boolean ajoutReussi = etablissement.ajouter("978-2-07-061275-8", 10);
        System.out.println("  Ajout de 10 exemplaires: " + (ajoutReussi ? "Réussi" : "Échec"));
        if (ajoutReussi) {
            article art = etablissement.rechercher("978-2-07-061275-8");
            System.out.println("  Nouveaux exemplaires: " + art.getNbExemplaires());
        }
        System.out.println();
        
        // Retirer exemplaires via Etablissement
        System.out.println("Test retirer() - Diminuer exemplaires via Etablissement:");
        boolean retraitReussi = etablissement.retirer("978-2-07-061275-8", 5);
        System.out.println("  Retrait de 5 exemplaires: " + (retraitReussi ? "Réussi" : "Échec"));
        if (retraitReussi) {
            article art = etablissement.rechercher("978-2-07-061275-8");
            System.out.println("  Nouveaux exemplaires: " + art.getNbExemplaires());
        }
        System.out.println();
        
        // Test avec article inexistant
        System.out.println("Test avec article inexistant:");
        boolean ajoutEchec = etablissement.ajouter("ISBN-999-999-999", 5);
        System.out.println("  Ajout exemplaires pour ISBN inexistant: " + (ajoutEchec ? "Réussi" : "Échec (normal)"));
        System.out.println();
        
        


        // Test 8: Question 4b - Utilisation des méthodes ajouterLivre, ajouterMagazine, ajouterManuel
        System.out.println(ConsoleColors.testHeader("8", "Question 4b - Méthodes d'ajout spécifiques"));

        boolean ajoutLivre2 = etablissement.ajouterLivre(
                "Nouveau Livre Test", 12.99, 5, "ISBN-TEST-001", 150);
        boolean ajoutMag2 = etablissement.ajouterMagazine(
                "Magazine Test", 4.50, 8, "ISSN-TEST-001", "Hebdomadaire", LocalDate.of(2024, 12, 1));
        boolean ajoutManuel2 = etablissement.ajouterManuel(
                "Manuel Test", 18.00, 6, "ISBN-TEST-002", 220, "Physique", "Lycée");

        System.out.println("Ajout via ajouterLivre : " + ajoutLivre2);
        System.out.println("Ajout via ajouterMagazine : " + ajoutMag2);
        System.out.println("Ajout via ajouterManuel : " + ajoutManuel2);
        System.out.println();


        // Test 9: Question 5b - Utilisation de la méthode ajouter() pour un bon de dépôt automatique
        System.out.println(ConsoleColors.testHeader("9", "Question 5b - Ajout d'un bon de dépôt automatique"));

        LigneDepot[] lignesTest = {
                new LigneDepot("978-2-07-061275-8", 2),
                new LigneDepot("ISSN-1234-5678", 1)
        };

        boolean ajoutBonAuto = etablissement.ajouter(600000000, lignesTest);

        System.out.println("Ajout du bon automatique : " + ajoutBonAuto);
        System.out.println("Nombre de bons maintenant : " + etablissement.getNbBonDepots());
        System.out.println();
        
        // Test 10: Question 5a - Test de la méthode ajouterLigne
        System.out.println(ConsoleColors.testHeader("10", "Question 5a - Test de la méthode ajouterLigne"));
        
        BonDepot bonTest = new BonDepot(699999999, LocalDate.now(), 0, new LigneDepot[5]);
        boolean ajoutLigne1 = bonTest.ajouterLigne("978-2-07-061275-8", 5);
        boolean ajoutLigne2 = bonTest.ajouterLigne("ISSN-1234-5678", 3);
        
        System.out.println("Ajout ligne 1 (ISBN, 5 exemplaires): " + ajoutLigne1);
        System.out.println("Ajout ligne 2 (ISSN, 3 exemplaires): " + ajoutLigne2);
        System.out.println("Nombre d'articles déposés dans le bon: " + bonTest.getNbArticleDeposes());
        System.out.println("Lignes de dépôt:");
        for (int i = 0; i < bonTest.getListArticles().length && bonTest.getListArticles()[i] != null; i++) {
            LigneDepot ligne = bonTest.getListArticles()[i];
            System.out.println("    - " + ligne.getNumeroIsbnIssn() + ": " + ligne.getExemplaires() + " exemplaire(s)");
        }
        System.out.println();
        
        System.out.println(ConsoleColors.cyanBold("\n=== FIN DES TESTS ==="));
        
        // Si vous avez activé la sauvegarde dans un fichier, fermez le flux
        System.out.flush(); // S'assurer que tout est écrit dans le fichier
        closeFileOutput(); // Fermer le fichier proprement

    }
    
    // Variable pour stocker le PrintStream du fichier (pour pouvoir le fermer à la fin)
    private static PrintStream fileOutputStream = null;
    
    /**
     * Méthode utilitaire pour sauvegarder la sortie dans un fichier
     * Décommentez l'appel à cette méthode dans main() pour activer la sauvegarde
     * Les résultats seront affichés dans la console ET sauvegardés dans le fichier
     */
    private static void enableFileOutput() {
        try {
            // Créer un PrintStream pour le fichier dans le dossier Output (même niveau que src)
            String filePath = "Output/output_TP3.txt"; // Fichier de sortie pour TP3
            java.io.File file = new java.io.File(filePath);
            // Créer le répertoire Output si nécessaire
            file.getParentFile().mkdirs();
            fileOutputStream = new PrintStream(file, "UTF-8");
            PrintStream consoleOut = System.out;
            
            // Créer un DualOutputStream qui écrit dans les deux
            System.setOut(new PrintStream(new TP3.Utiles.DualOutputStream(consoleOut, fileOutputStream)));
            
            // Afficher le chemin absolu du fichier
            String absolutePath = file.getAbsolutePath();
            System.out.println("Les résultats sont également sauvegardés dans: " + absolutePath + "\n");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier de sortie: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Ferme le fichier de sortie si il a été ouvert
     */
    private static void closeFileOutput() {
        if (fileOutputStream != null) {
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("\nFichier de sortie fermé avec succès.");
        }
    }
    
}
