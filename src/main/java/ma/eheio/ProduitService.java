package ma.eheio;

import java.util.*;

public class ProduitService {
    Map<Long,Produit> produits =new HashMap<Long, Produit>();

    public void ajouterProduit(Produit produit) {
        Long id = produit.getId();
        String nom = produit.getNom();
        double prix = produit.getPrix();
        int qte = produit.getQte();
        Optional<Produit> existingProductById = Optional.ofNullable(produits.get(id));
        Optional<Produit> existingProductByName = produits.values().stream().filter(p -> p.getNom().equals(nom))
                .findFirst();
        try {
            if (existingProductById.isPresent()) {
                throw new IllegalArgumentException("Id du produit existe deja");
            } else if (existingProductByName.isPresent()) {
                throw new IllegalArgumentException("Le nom du produit avec id " + id + " existe deja change le nom.");
            } else if (prix < 0) {
                throw new IllegalArgumentException("Le produit avec id " + id + " doit avoir un prix positif");
            } else if (qte < 0) {
                throw new IllegalArgumentException("Le produit avec id " + id + " doit avoir une quantite positive");
            } else {
                produits.put(id, produit);
                System.out.println("Produit ajoute");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("exeption : " + e.getMessage());
        }

    }
}
