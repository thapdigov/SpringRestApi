package az.perfect.springrestapi.rest.model.response;

import az.perfect.springrestapi.rest.model.request.ProductDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    List<ProductDto>dtoList;
}
