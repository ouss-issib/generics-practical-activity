import javax.swing.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MetierProduitImpl metier = new MetierProduitImpl();
        int choix;
        do {
            System.out.println("************** Activité pratique : La généricité **************");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.println("Saisir votre Choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:

                    if(metier.getAll().isEmpty())
                    {
                        System.out.println("La Liste des Produits est vide");
                    }
                        else{
                        System.out.println("La Liste des Produits");
                        for (Produit p : metier.getProduitList()) {
                            System.out.println("------------------------------------------------");
                            System.out.println(p.toString());
                        }
                        System.out.println("------------------------------------------------");

                    }
                    break;

                case 2:
                    System.out.println("Saisir id de le produit recherché :");
                    Long searchedId = sc.nextLong();
                    Produit p = metier.findById(searchedId);
                    if (p == null) System.out.println("Produit introuvable !!!");
                    else {
                        System.out.println("========= Produit recherché =========");
                        System.out.println(p.toString());
                    }
                    break;

                case 3:
                    Long nId;
                    String nNom,nMarque,nDescription;
                    int nNbrEnStock;
                    double nPrix;
                    System.out.println("Entrer l'id du produit");
                    nId = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Entrer le nom du produit");
                    nNom = sc.nextLine();
                    System.out.println("Entrer la marque du produit");
                    nMarque = sc.nextLine();
                    System.out.println("Entrer la description du produit");
                    nDescription = sc.nextLine();
                    System.out.println("Entrer le prix du produit");
                    nPrix = sc.nextDouble();
                    System.out.println("Entrer le nombre en stock du produit");
                    nNbrEnStock = sc.nextInt();
                    Produit nProduit = new Produit(nId,nNom,nMarque,nPrix,nDescription,nNbrEnStock);
                    metier.add(nProduit);
                    break;
                case 4:
                    System.out.println("Entrer Id du produit à supprimer : ");
                    Long deletedId = sc.nextLong();
                    metier.delete(deletedId);
                    break;
                case 5:
                    System.out.println("Bye !!");
                    break;
                default:
                    System.out.println("Veuiler saisir un choix entre 1 et 5");
                    break;
            }
        }while (choix!=5);


    }
}