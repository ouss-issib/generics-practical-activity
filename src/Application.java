import javax.swing.*;
import java.util.Scanner;

public class Application {

    public static <T> T checkInputValidation(Class<T> type, String nameInput) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Entrer le %s du produit : ", nameInput);

        while (true) {
            if (type == Integer.class && sc.hasNextInt()) {
                return type.cast(sc.nextInt());
            } else if (type == Double.class && sc.hasNextDouble()) {
                return type.cast(sc.nextDouble());
            } else if (type == String.class) {
                return type.cast(sc.next());
            } else {
                System.out.printf("Veuillez saisir un(e) %s valide : ", nameInput);
                sc.next(); // Discard invalid input
            }
        }
    }

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
            while(!sc.hasNextInt()) {
                        System.out.println("Veuiller Saisir valid numero pour le choix !!!! ");
                        System.out.println("Saisir votre Un Choix Valide : ");
                        sc.next();
            }
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    if (metier.getAll().isEmpty()) {
                        System.out.println("La Liste des Produits est vide");
                    } else {
                        System.out.println("La Liste des Produits");
                        for (Produit p : metier.getProduitList()) {
                            System.out.println("------------------------------------------------");
                            System.out.println(p.toString());
                        }
                        System.out.println("------------------------------------------------");
                    }
                }
                case 2 -> {
                    System.out.println("Saisir id de le produit recherché :");
                    Long searchedId = sc.nextLong();
                    Produit p = metier.findById(searchedId);
                    if (p == null) System.out.println("Produit introuvable !!!");
                    else {
                        System.out.println("========= Produit recherché =========");
                        System.out.println(p.toString());
                    }
                }
                case 3 -> {
                    Long nId;
                    String nNom, nMarque, nDescription;
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
                    nPrix = checkInputValidation(Double.class,"Prix");
                    nNbrEnStock = checkInputValidation(Integer.class,"nombre en stock");
                    Produit nProduit = new Produit(nId, nNom, nMarque, nPrix, nDescription, nNbrEnStock);
                    metier.add(nProduit);
                }
                case 4 -> {
                    System.out.println("Entrer Id du produit à supprimer : ");
                    Long deletedId = checkInputValidation(Long.class,"")
                    metier.delete(deletedId);
                }
                case 5 -> System.out.println("Bye !!");
                default -> System.out.println("Veuiler saisir un choix entre 1 et 5");
            }
        }while (choix!=5);


    }
}