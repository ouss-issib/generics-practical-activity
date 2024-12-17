import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produitList = new ArrayList<>();
    ;

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
            this.produitList = produitList;
    }


    @Override
    public void add(Produit o) {
        produitList.add(o);
        System.out.println("Produit ajouté avec success");
    }

    @Override
    public List<Produit> getAll() {

            return this.produitList;
    }

    @Override
    public Produit findById(Long id) {
        for(Produit p :produitList){
            if(p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        int index = -1;
        produitList.removeIf(p -> p.getId() == id);
        System.out.println("Produit supprimé avec success");

    }
}
