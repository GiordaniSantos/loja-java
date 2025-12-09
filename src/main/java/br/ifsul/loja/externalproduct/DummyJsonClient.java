package br.ifsul.loja.externalproduct;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "productsClient", url = "https://dummyjson.com")
public interface DummyJsonClient {

    @GetMapping("/products/category/laptops")
    ExternalProductsResponse getProducts();
}

