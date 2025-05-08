import java.util.*;

public class Personne {
    // Attributs d'instance
    private String nom;
    private String adresse;
    private int age;
    private String telephone;
    
    // Variables de classe pour la gestion
    private static Personne[] personnes = new Personne[100];
    private static int nombrePersonnes = 0;
    private static Scanner scanner = new Scanner(System.in);

    // Constructeurs
    public Personne() {} // Constructeur vide
    
    public Personne(String nom, String adresse, int age, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.age = age;
        this.telephone = telephone;
    }

    // Méthodes de gestion (statiques)
    public static void ajouterPersonne() {
        if (nombrePersonnes >= personnes.length) {
            System.out.println("La limite de personnes est atteinte !");
            return;
        }

        // Validation du nom
        String nom;
        do {
            System.out.print("Entrez le nom (min 2 caractères) : ");
            nom = scanner.nextLine().trim();
        } while (nom.length() < 2);

        System.out.print("Entrez l'adresse : ");
        String adresse = scanner.nextLine();

        // Validation de l'âge
        int age;
        do {
            System.out.print("Entrez l'âge : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.next();
            }
            age = scanner.nextInt();
            scanner.nextLine();
        } while (age <= 0);

        // Validation du numero de téléphone
        String telephone;
        boolean numeroValide;
        do {
            System.out.print("Entrez le téléphone (9 chiffres) : ");
            telephone = scanner.nextLine().trim();
            
            numeroValide = telephone.matches("\\d{9}");
            
            if (numeroValide) {
                for (int i = 0; i < nombrePersonnes; i++) {
                    if (personnes[i].telephone.equals(telephone)) {
                        System.out.println("Ce numéro existe déjà !");
                        numeroValide = false;
                        break;
                    }
                }
            }
            
            if (!numeroValide) {
                System.out.println("Numéro invalide. Il doit avoir exactement 9 chiffres.");
            }
        } while (!numeroValide);

        personnes[nombrePersonnes++] = new Personne(nom, adresse, age, telephone);
        System.out.println("Personne ajoutée avec succès !");
    }

    public static void listerPersonnes() {
        if (nombrePersonnes == 0) {
            System.out.println("Aucune personne à afficher.");
            return;
        }

        System.out.println("\nListe des personnes :");
        for (int i = 0; i < nombrePersonnes; i++) {
            afficherPersonne(personnes[i]);
        }
    }

    public static void rechercherPersonne() {
        System.out.print("Entrez le numéro de téléphone à rechercher : ");
        String telRecherche = scanner.nextLine().trim();
        boolean trouve = false;

        for (int i = 0; i < nombrePersonnes; i++) {
            if (personnes[i].telephone.equals(telRecherche)) {
                System.out.println("Personne trouvée :");
                afficherPersonne(personnes[i]);
                trouve = true;
                break;
            }
        }

        if (!trouve) {
            System.out.println("Aucune personne trouvée avec ce numéro.");
        }
    }

    private static void afficherPersonne(Personne p) {
        System.out.println("Nom: " + p.nom);
        System.out.println("Adresse: " + p.adresse);
        System.out.println("Age: " + p.age);
        System.out.println("Telephone: " + p.telephone);
        System.out.println("----------------------");
    }

    // Getters
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public int getAge() { return age; }
    public String getTelephone() { return telephone; }
}