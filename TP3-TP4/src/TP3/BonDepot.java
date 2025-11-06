package TP3;
import java.time.LocalDate;
import java.util.Arrays;

public class BonDepot {
    private int numTel;
    private LocalDate dateDepot;
    private int nbArticleDeposes;
    private LigneDepot[] listArticles = new LigneDepot[5];
    private static int numerote = 0;
    private int id;
    
    
    public BonDepot(int numTel,LocalDate dateDepot, int nbArticleDeposes, LigneDepot[] listArticles){
        this.numTel = numTel;
        this.nbArticleDeposes = nbArticleDeposes;
        this.listArticles = listArticles;
        
        this.id = numerote;
        numerote++;
    }
    
    
}
