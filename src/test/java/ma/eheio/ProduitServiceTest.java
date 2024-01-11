package ma.eheio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProduitServiceTest {
    ProduitService produitService;
    @Before
    public void setUp() throws Exception {
        this.produitService = new ProduitService();
    }

    @After
    public void tearDown() throws Exception {
        produitService=null;
    }
    @Test
    public void testAjouterProduitSuccess() {
        Produit produit = new Produit(1,"sword",300.00,7);
        produitService.ajouterProduit(produit);
        assertEquals(produit, produitService.produits.get(produit.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterProduitDuplicateId() {
        Produit existingProduct = new Produit(1, "drugs", 200.00, 5);
        produitService.ajouterProduit(existingProduct);

        Produit duplicateProduct = new Produit(1, "azerty", 200.55, 6);

        produitService.ajouterProduit(duplicateProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterProduitDuplicateName() {
        Produit existingProduct = new Produit(1, "dragon", 400.00, 5);
        produitService.ajouterProduit(existingProduct);

        Produit duplicateProduct = new Produit(2, "dragon", 500.00, 6);
        produitService.ajouterProduit(duplicateProduct);
    }
    @Test
    public void testSupprimerProduit() {
        Produit existingProduct = new Produit(1, "kayn", 20.0, 50);
        produitService.ajouterProduit(existingProduct);
        produitService.supprimerProduit(existingProduct);
        assertFalse(produitService.produits.containsValue(existingProduct));
    }
    @Test
    public void testSupprimerProduitNonExiste() {
        Produit nonExistingProduct = new Produit(2, "makaynch", 5.0, 100);
        produitService.supprimerProduit(nonExistingProduct);
        assertFalse(produitService.produits.containsValue(nonExistingProduct));
    }
    @Test
    public void testModifierProduit() {
        Produit existingProduct = new Produit(1, "pc", 1000.0, 10);
        produitService.ajouterProduit(existingProduct);
        Produit nouveauProduit = new Produit(1, "pc jdid", 1200.0, 15);
        produitService.modifierProduit(1L, nouveauProduit);
        Produit modifiedProduct = produitService.produits.get(1L);
        assertEquals(nouveauProduit.getNom(), modifiedProduct.getNom());
        assertEquals(nouveauProduit.getPrix(), modifiedProduct.getPrix(), 0.001);
        assertEquals(nouveauProduit.getQte(), modifiedProduct.getQte());
    }
    @Test
    public void testModifierProduitNonExiste()
    {
        Produit nonExistingProduct = new Produit(1, "wah wah", 50.0, 30);
        produitService.modifierProduit(1L, nonExistingProduct);
        assertNull(produitService.produits.get(1L));
    }
}