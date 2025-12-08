package br.ifsul.loja.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping("/")
    public String home() {
        return "layout";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = service.listProducts();
        model.addAttribute("products", products);
        return "pages/list-products";
    }

    @GetMapping("products/favorites")
    public String listFavorites(Model model) {
        List<Product> products = service.listFavoritesProducts();
        model.addAttribute("products", products);
        return "pages/favorites";
    }

    @GetMapping("products/new")
    public String newProduct(Model model) {
        return "pages/new-product";
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.deleteProduct(id));
    }

    @PostMapping("/products/{id}/favorite")
    public ResponseEntity<Boolean> favoriteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.favoriteProduct(id));
    }

    /*
        @PostMapping("/products")
        public String saveProduct(@ModelAttribute Product product, Model model) {
            model.addAttribute("mensagem", "Produto cadastrado: " + produto.getNome());
            return "pages/favorites";
        }
*/
}
