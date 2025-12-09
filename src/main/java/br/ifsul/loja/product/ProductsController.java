package br.ifsul.loja.product;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("title", "Todos os produtos");
        model.addAttribute("products", products);
        model.addAttribute("endpointUpdate", "/products");
        model.addAttribute("removeButton", true);
        return "pages/list-products";
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.deleteProduct(id));
    }

    @GetMapping("products/favorites")
    public String listFavorites(Model model) {
        List<Product> products = service.listFavoritesProducts();
        model.addAttribute("title", "Produtos favoritos");
        model.addAttribute("products", products);
        model.addAttribute("endpointUpdate", "products/favorites");
        model.addAttribute("removeButton", false);
        return "pages/list-products";
    }

    @GetMapping("products/external")
    public String listExternalProducts(Model model) {
        List<Product> products = service.listExternalProducts();
        model.addAttribute("title", "Produtos externos");
        model.addAttribute("products", products);
        model.addAttribute("endpointUpdate", "products/external");
        model.addAttribute("removeButton", false);
        return "pages/list-products";
    }

    @PostMapping("/products/{id}/favorite")
    public ResponseEntity<Boolean> favoriteProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.favoriteProduct(id));
    }

    @GetMapping("products/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "pages/new-product";
    }

    @PostMapping("/products")
    public String saveProduct(
            @Valid @ModelAttribute("product") ProductDTO productDto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Existem erros no formulário. Corrija-os e tente novamente.");
            return "pages/new-product";
        }
        Product productSaved = service.createProduct(productDto);
        model.addAttribute("message", "Produto cadastrado: " + productSaved.getDescription());
        model.addAttribute("product", productSaved);
        return "pages/result";
    }


}
