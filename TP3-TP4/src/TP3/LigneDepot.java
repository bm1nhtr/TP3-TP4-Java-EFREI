package TP3;


public class LigneDepot {
    private int codeArticle;
    private int exemplaires;
    
    public LigneDepot(int codeArticle, int exemplaires){
        this.codeArticle = codeArticle;
        this.exemplaires = exemplaires;
    }
    public int getcodeArticle(){
        return this.codeArticle;
    }
    public int getexemplaires(){
        return this.exemplaires;
    }
    public void setexemplaires(int exemplaires){
        this.exemplaires = exemplaires;
    }
    public void setcodeArticle(int codeArticle){
        this.codeArticle = codeArticle;
    }
}
