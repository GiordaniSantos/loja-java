package br.ifsul.loja.product;

import br.ifsul.loja.externalproduct.ExternalProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


public class ProductMapper {

    public static Product externalProductToProduct(ExternalProductDTO dto){
        Product product = new Product();
        product.setImageUrl(dto.getThumbnail());
        product.setQuantity(dto.getStock());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getTitle());
        //product.setId((long) dto.getId());
        return product;
    }
}

