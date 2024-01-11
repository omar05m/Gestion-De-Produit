package ma.eheio;


public class Produit {
    private long id;
    private String nom;
    private double prix;
    private int qte;

    public Produit(long id, String nom, double prix, int qte) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
    }

    public long getId() {
        return id;
    }
    public double getPrix() {
        return prix;
    }
    public String getNom() {
        return nom;
    }
    public int getQte() {
        return qte;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", qte=" + qte +
                '}';
    }
}
