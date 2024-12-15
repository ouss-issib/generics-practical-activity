public class Produit {

    //Créez une classe Produit avec les attributs id, nom, marque, prix, description,
   // et nombre en stock.

    private Long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nbrEnStock;

    public Produit() {
    }

    public Produit(Long id, String nom, String marque, double prix, String description, int nbrEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrEnStock = nbrEnStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbrEnStock() {
        return nbrEnStock;
    }

    public void setNbrEnStock(int nbrEnStock) {
        this.nbrEnStock = nbrEnStock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                " DH , description='" + description + '\'' +
                ", nbrEnStock=" + nbrEnStock +
                '}';
    }
}
