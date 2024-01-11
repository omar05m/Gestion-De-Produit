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
}