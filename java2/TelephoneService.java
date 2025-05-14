package java2;

import java.util.ArrayList;

public class TelephoneService {
    private ArrayList<Telephone> listeNumeros = new ArrayList<>();

    public boolean estValide(String numero) {
        return numero.matches("^(77|78|76|70)\\d{7}$");
    }

    public boolean existe(String numero) {
        for (Telephone tel : listeNumeros) {
            if (tel.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }

    public boolean ajouterNumero(String numero) {
        if (estValide(numero) && !existe(numero)) {
            listeNumeros.add(new Telephone(numero));
            return true;
        }
        return false;
    }

    public ArrayList<Telephone> listerNumeros() {
        return listeNumeros;
    }

    public ArrayList<Telephone> rechercher(String motif) {
        ArrayList<Telephone> resultats = new ArrayList<>();
        for (Telephone tel : listeNumeros) {
            if (tel.getNumero().contains(motif)) {
                resultats.add(tel);
            }
        }
        return resultats;
    }
}
