import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ajouter une personne");
            System.out.println("2. Lister toutes les personnes");
            System.out.println("3. Rechercher par téléphone");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: Personne.ajouterPersonne(); break;
                case 2: Personne.listerPersonnes(); break;
                case 3: Personne.rechercherPersonne(); break;
                case 4: 
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                default: System.out.println("Option invalide !");
            }
        }
    }
}