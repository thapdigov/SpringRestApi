package az.perfect.springrestapi.rest.model.request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private int product_id;
    private String product_name;
    private int quantity;
    private int category_id;
    private int country_id;
}
