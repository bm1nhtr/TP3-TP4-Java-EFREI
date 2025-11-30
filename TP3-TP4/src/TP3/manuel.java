/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author nouar
 */
// Un manuel scolaire est un type particulier de Livre.
// Il hérite donc de Livre (donc d'Article) : possède isbn + nbPages,
// et ajoute : matiere + niveau scolaire.
public class manuel extends livre {
    
    // Matière enseignée (ex : "Français", "Mathématiques")
    private String matiere;

    // Niveau scolaire (ex : "Collège", "Lycée", "Licence")
    private String niveau;

    // Constructeur : on appelle d'abord le constructeur de Livre (super)
    public manuel(String description,
                  double prixInitial,
                  int nbExemplaires,
                  String isbn,
                  int nbPages,
                  String matiere,
                  String niveau) {
        // super(...) initialise description, prixInitial, nbExemplaires, isbn, nbPages
        super(description, prixInitial, nbExemplaires, isbn, nbPages);
        this.matiere = matiere;
        this.niveau = niveau;
    }

    // Getters
    public String getMatiere() { return matiere; }
    public String getNiveau()  { return niveau; }

    // Setters
    public void setMatiere(String matiere) { this.matiere = matiere; }
    public void setNiveau(String niveau)   { this.niveau = niveau; }

    // getNumero est déjà défini dans Livre (retourne l'isbn).
    // On peut le redéfinir ici si on veut être explicite, mais ce n'est pas obligatoire.
    
}
