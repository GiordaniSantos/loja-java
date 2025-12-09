package br.ifsul.loja.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repository;

    public List<Product> listProducts(){
        return repository.findAll();
    }

    public List<Product> listFavoritesProducts(){
        return repository.findAll();
    }

    public List<Product> listExternalProducts(){
        return repository.findAll();
    }

    public boolean favoriteProduct(Long id){
        //repository.favoriteProduct(id);
        return true;
    }

    public Product createProduct(ProductDTO productDTO){
        Product newProduct = new Product();
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setQuantity(productDTO.getQuantity());
        newProduct.setImageUrl(productDTO.getImageUrl());
        return repository.save(newProduct);
    }

    public boolean deleteProduct(Long id){
        if(!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

}
