package br.ifsul.loja.externalproduct;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ExternalProductsResponse {

    private List<ExternalProductDTO> products;
    private int total;
    private int skip;
    private int limit;

}
