package TP3.Utiles;

/**
 * Classe utilitaire pour afficher du texte en couleur dans la console
 * Utilise les codes ANSI pour les couleurs
 * @author minhm
 */
public class ConsoleColors {
    // Codes ANSI pour les couleurs
    public static final String RESET = "\033[0m";  // Reset
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String CYAN = "\033[0;36m";    // CYAN
    
    // Codes ANSI pour les couleurs en gras
    public static final String RED_BOLD = "\033[1;31m";    // RED BOLD
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN BOLD
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN BOLD
    
    /**
     * Affiche un texte en couleur rouge
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String red(String text) {
        return RED + text + RESET;
    }
    
    /**
     * Affiche un texte en couleur rouge en gras
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String redBold(String text) {
        return RED_BOLD + text + RESET;
    }
    
    /**
     * Affiche un texte en couleur verte
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String green(String text) {
        return GREEN + text + RESET;
    }
    
    /**
     * Affiche un texte en couleur verte en gras
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String greenBold(String text) {
        return GREEN_BOLD + text + RESET;
    }
    
    /**
     * Affiche un texte en couleur cyan
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String cyan(String text) {
        return CYAN + text + RESET;
    }
    
    /**
     * Affiche un texte en couleur cyan en gras
     * @param text Le texte à afficher
     * @return Le texte avec les codes de couleur
     */
    public static String cyanBold(String text) {
        return CYAN_BOLD + text + RESET;
    }
    
    /**
     * Affiche un message de test (en cyan gras - nổi bật trên cả background đen và trắng)
     * @param testNumber Le numéro du test
     * @param testName Le nom du test
     * @return Le message formaté en couleur
     */
    public static String testHeader(String testNumber, String testName) {
        return cyanBold("--- Test " + testNumber + ": " + testName + " ---");
    }
    
    /**
     * Affiche un message de succès (en vert)
     * @param message Le message à afficher
     * @return Le message formaté en couleur
     */
    public static String success(String message) {
        return green("✓ " + message);
    }
    
    /**
     * Affiche un message d'erreur (en rouge)
     * @param message Le message à afficher
     * @return Le message formaté en couleur
     */
    public static String error(String message) {
        return red("✗ " + message);
    }
    
    /**
     * Affiche un message d'information (en cyan)
     * @param message Le message à afficher
     * @return Le message formaté en couleur
     */
    public static String info(String message) {
        return cyan("ℹ " + message);
    }
    
    /**
     * Affiche un message d'avertissement (en rouge)
     * @param message Le message à afficher
     * @return Le message formaté en couleur
     */
    public static String warning(String message) {
        return red("⚠ " + message);
    }
}

