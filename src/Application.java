import javax.swing.*;
import java.util.Scanner;

public class Application {

    public static <T> T checkInputValidation(Class<T> type,String msgInput ,String nameInput) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msgInput);

        while (true) {
            if (type == Integer.class && sc.hasNextInt()) {
                return type.cast(sc.nextInt());
            }
            else if (type == Long.class && sc.hasNextLong()) {
                return type.cast(sc.nextLong());
            } else if (type == Double.class && sc.hasNextDouble()) {
                return type.cast(sc.nextDouble());
            } else if (type == String.class) {
                return type.cast(sc.next());
            } else {
                System.out.printf("Veuillez saisir un(e) %s valide : ", nameInput);
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        int choix;
        do {
            System.out.println("******************************************************** Activité pratique : La généricité **********************************************************************");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par ID.");
            System.out.println("5. Quitter ce programme.");
            choix = checkInputValidation(Integer.class,"Saisir votre choix :" ,"Choix");

            switch (choix) {
                case 1 -> {
                    if (metier.getAll().isEmpty()) {
                        System.out.println("La Liste des Produits est vide");
                    } else {
                        System.out.println("La Liste des Produits");
                        for (Produit p : metier.getProduitList()) {
                            System.out.println("------------------------------------------------------------------------------------------------");
                            System.out.println(p.toString());
                        }
                        System.out.println("------------------------------------------------------------------------------------------------");
                    }
                }
                case 2 -> {
                    Long searchedId = checkInputValidation(Long.class,"Saisir id du produit recherché :", "Id");
                    Produit p = metier.findById(searchedId);
                    if (p == null) System.out.println("Produit introuvable !!!");
                    else {
                        System.out.println("==================================== Produit recherché ====================================");
                        System.out.println(p.toString());
                    }
                }
                case 3 -> {
                    Long nId;
                    String nNom, nMarque, nDescription;
                    int nNbrEnStock;
                    double nPrix;
                    nId = checkInputValidation(Long.class,"Entrer l'id du produit :","ID");
                    nNom = checkInputValidation(String.class,"Entrer le nom du produit :","nom");
                    nMarque = checkInputValidation(String.class,"Entrer la marque du produit :","marque");
                    nDescription = checkInputValidation(String.class,"Entrer la description du produit :","description");
                    nPrix = checkInputValidation(Double.class,"Entrer le prix du produit :","Prix");
                    nNbrEnStock = checkInputValidation(Integer.class,"Entrer le nombre en stock du produit :","nombre en stock");
                    Produit nProduit = new Produit(nId, nNom, nMarque, nPrix, nDescription, nNbrEnStock);
                    metier.add(nProduit);
                }
                case 4 -> {
                    Long deletedId = checkInputValidation(Long.class,"Entrer Id du produit à supprimer : ","Id du produit à supprimer");
                    metier.delete(deletedId);
                }
                case 5 -> System.out.println("Bye !!");
                default -> System.out.println("Veuiler saisir un choix entre 1 et 5");
            }
        }while (choix!=5);


    }
}