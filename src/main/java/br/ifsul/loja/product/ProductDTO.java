package br.ifsul.loja.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser maior que zero.")
    private Double price;

    @NotNull(message = "A quantidade é obrigatória.")
    @PositiveOrZero(message = "A quantidade não pode ser negativa.")
    private Integer quantity;

    @NotBlank(message = "A URL da imagem é obrigatória.")
    @Size(max = 30000, message = "A URL da imagem não pode passar de 30000 caracteres")
    private String imageUrl;
}
