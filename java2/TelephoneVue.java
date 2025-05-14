package java2;

import java.util.Scanner;

public class TelephoneVue {
    private TelephoneService service = new TelephoneService();
    private Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1-Ajouter un numéro Téléphone dans le Tableau");
            System.out.println("2-Lister les numéros Téléphone du tableau");
            System.out.println("3-Rechercher les numéros du tableau");
            System.out.println("4-Quitter");
            System.out.print("Choix : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    ajouter();
                    break;
                case "2":
                    lister();
                    break;
                case "3":
                    rechercher();
                    break;
                case "4":
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private void ajouter() {
        System.out.print("Entrer le numéro : ");
        String numero = scanner.nextLine();
        if (service.ajouterNumero(numero)) {
            System.out.println("Numéro ajouté avec succès !");
        } else {
            System.out.println("Numéro invalide ou déjà existant !");
        }
    }

    private void lister() {
        System.out.println("Liste des numéros :");
        for (Telephone tel : service.listerNumeros()) {
            System.out.println("- " + tel);
        }
    }

    private void rechercher() {
        System.out.print("Entrez un motif à rechercher : ");
        String motif = scanner.nextLine();
        var resultats = service.rechercher(motif);
        if (resultats.isEmpty()) {
            System.out.println("Aucun résultat.");
        } else {
            System.out.println("Résultats trouvés :");
            for (Telephone tel : resultats) {
                System.out.println("- " + tel);
            }
        }
    }
}
