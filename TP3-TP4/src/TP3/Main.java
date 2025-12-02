package TP3;
import java.time.LocalDate;

/**
 * Classe principale pour tester les classes du TP3
 * @author minhm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== TEST DES CLASSES TP3 ===\n");
        
        // Test 1: Création d'articles
        System.out.println("--- Test 1: Création d'articles ---");
        
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
        System.out.println("--- Test 2: Création de LigneDepot ---");
        
        LigneDepot ligne1 = new LigneDepot(1, 3); // Code article 1, 3 exemplaires
        LigneDepot ligne2 = new LigneDepot(2, 2); // Code article 2, 2 exemplaires
        LigneDepot ligne3 = new LigneDepot(3, 1); // Code article 3, 1 exemplaire
        
        System.out.println("LigneDepot 1:");
        System.out.println("  Code article: " + ligne1.getCodeArticle());
        System.out.println("  Exemplaires: " + ligne1.getExemplaires());
        System.out.println();
        
        System.out.println("LigneDepot 2:");
        System.out.println("  Code article: " + ligne2.getCodeArticle());
        System.out.println("  Exemplaires: " + ligne2.getExemplaires());
        System.out.println();
        
        // Test 3: Création de BonDepot
        System.out.println("--- Test 3: Création de BonDepot ---");
        
        LigneDepot[] lignes = {ligne1, ligne2, ligne3};
        BonDepot bon1 = new BonDepot(612345678, LocalDate.now(), 3, lignes);
        
        System.out.println("BonDepot 1:");
        System.out.println("  ID: " + bon1.getId());
        System.out.println("  Numéro téléphone: " + bon1.getNumTel());
        System.out.println("  Date dépôt: " + bon1.getDateDepot());
        System.out.println("  Nombre d'articles déposés: " + bon1.getNbArticleDeposes());
        System.out.println("  Lignes de dépôt:");
        for (int i = 0; i < bon1.getListArticles().length && bon1.getListArticles()[i] != null; i++) {
            LigneDepot ligne = bon1.getListArticles()[i];
            System.out.println("    - Article " + ligne.getCodeArticle() + ": " + ligne.getExemplaires() + " exemplaire(s)");
        }
        System.out.println();
        
        // Test 4: Création d'un deuxième BonDepot pour vérifier l'incrémentation de l'ID
        System.out.println("--- Test 4: Vérification de l'incrémentation de l'ID ---");
        
        LigneDepot[] lignes2 = {new LigneDepot(4, 5)};
        BonDepot bon2 = new BonDepot(698765432, LocalDate.of(2024, 2, 1), 1, lignes2);
        
        System.out.println("BonDepot 2:");
        System.out.println("  ID: " + bon2.getId() + " (devrait être 2)");
        System.out.println("  Numéro téléphone: " + bon2.getNumTel());
        System.out.println("  Date dépôt: " + bon2.getDateDepot());
        System.out.println();
        
        // Test 5: Question 4a - Ajouter des articles à un établissement
        System.out.println("--- Test 5: Question 4a - Ajouter des articles à un établissement ---");
        
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
        
        // Test 6: Question 4c - Calculer le nombre total d'exemplaires déposés
        System.out.println("--- Test 6: Question 4c - Nombre total d'exemplaires déposés ---");
        
        // Ajouter les bons de dépôt à l'établissement
        etablissement.ajouterBonDepot(bon1);
        etablissement.ajouterBonDepot(bon2);
        
        // Créer un autre bon de dépôt avec le même code article pour tester le calcul
        LigneDepot[] lignes3 = {new LigneDepot(1, 2), new LigneDepot(2, 1)}; // Article 1: 2 exemplaires, Article 2: 1 exemplaire
        BonDepot bon3 = new BonDepot(611111111, LocalDate.of(2024, 2, 15), 2, lignes3);
        etablissement.ajouterBonDepot(bon3);
        
        System.out.println("Nombre de bons de dépôt: " + etablissement.getNbBonDepots());
        System.out.println();
        
        // Calculer le nombre total d'exemplaires déposés pour chaque article
        int totalArticle1 = etablissement.nombreExemplairesDeposes(1);
        int totalArticle2 = etablissement.nombreExemplairesDeposes(2);
        int totalArticle3 = etablissement.nombreExemplairesDeposes(3);
        int totalArticle4 = etablissement.nombreExemplairesDeposes(4);
        
        System.out.println("Total exemplaires déposés pour l'article 1: " + totalArticle1 + " (devrait être 5: 3+2)");
        System.out.println("Total exemplaires déposés pour l'article 2: " + totalArticle2 + " (devrait être 3: 2+1)");
        System.out.println("Total exemplaires déposés pour l'article 3: " + totalArticle3 + " (devrait être 1)");
        System.out.println("Total exemplaires déposés pour l'article 4: " + totalArticle4 + " (devrait être 5)");
        System.out.println();
        
        // Test 7: Question 5a - Rechercher un article par son numéro
        System.out.println("--- Test 7: Question 5a - Rechercher un article par son numéro ---");
        
        // Rechercher un livre par ISBN
        article articleTrouve1 = etablissement.rechercherArticleParNumero("978-2-07-061275-8");
        if (articleTrouve1 != null) {
            System.out.println("Article trouvé (ISBN 978-2-07-061275-8):");
            System.out.println("  Description: " + articleTrouve1.getDescription());
            System.out.println("  Prix: " + articleTrouve1.getPrixInitial() + "€");
            if (articleTrouve1 instanceof livre) {
                livre l = (livre) articleTrouve1;
                System.out.println("  Type: Livre");
                System.out.println("  Pages: " + l.getNbPages());
            }
        } else {
            System.out.println("Article non trouvé pour ISBN 978-2-07-061275-8");
        }
        System.out.println();
        
        // Rechercher un magazine par ISSN
        article articleTrouve2 = etablissement.rechercherArticleParNumero("ISSN-1234-5678");
        if (articleTrouve2 != null) {
            System.out.println("Article trouvé (ISSN ISSN-1234-5678):");
            System.out.println("  Description: " + articleTrouve2.getDescription());
            System.out.println("  Prix: " + articleTrouve2.getPrixInitial() + "€");
            if (articleTrouve2 instanceof magazine) {
                magazine m = (magazine) articleTrouve2;
                System.out.println("  Type: Magazine");
                System.out.println("  Périodicité: " + m.getPeriodicite());
            }
        } else {
            System.out.println("Article non trouvé pour ISSN ISSN-1234-5678");
        }
        System.out.println();
        
        // Rechercher un article qui n'existe pas
        article articleTrouve3 = etablissement.rechercherArticleParNumero("ISBN-999-999-999");
        if (articleTrouve3 != null) {
            System.out.println("Article trouvé: " + articleTrouve3.getDescription());
        } else {
            System.out.println("Article non trouvé pour ISBN-999-999-999 (normal, cet article n'existe pas)");
        }
        System.out.println();
        
        System.out.println("=== FIN DES TESTS ===");


        // Test 8 : 5b - Utilisation des méthodes ajouterLivre, ajouterMagazine, ajouterManuel
        System.out.println("--- Test 5b : Utilisation des méthodes d'ajout spécifiques ---");

        boolean ajoutLivre2 = etablissement.ajouterLivre(
                "Nouveau Livre Test", 12.99, 5, "ISBN-TEST-001", 150);
        boolean ajoutMag2 = etablissement.ajouterMagazine(
                "Magazine Test", 4.50, 8, "ISSN-TEST-001", "Hebdomadaire", "2024-12-01");
        boolean ajoutManuel2 = etablissement.ajouterManuel(
                "Manuel Test", 18.00, 6, "ISBN-TEST-002", 220, "Physique", "Lycée");

        System.out.println("Ajout via ajouterLivre : " + ajoutLivre2);
        System.out.println("Ajout via ajouterMagazine : " + ajoutMag2);
        System.out.println("Ajout via ajouterManuel : " + ajoutManuel2);
        System.out.println();


        // Test 9: 5c - Utilisation de la méthode ajouter() pour un bon de dépôt automatique
        System.out.println("--- Test 5c : Ajout d'un bon de dépôt automatique ---");

        LigneDepot[] lignesTest = {
                new LigneDepot(1, 2),
                new LigneDepot(2, 1)
        };

        boolean ajoutBonAuto = etablissement.ajouter(600000000, lignesTest);

        System.out.println("Ajout du bon automatique : " + ajoutBonAuto);
        System.out.println("Nombre de bons maintenant : " + etablissement.getNbBonDepots());
        System.out.println();

    }
    
    
}
