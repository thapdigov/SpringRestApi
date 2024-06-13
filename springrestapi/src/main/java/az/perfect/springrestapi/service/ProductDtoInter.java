package az.perfect.springrestapi.service;


import az.perfect.springrestapi.rest.model.request.ProductDto;
import az.perfect.springrestapi.rest.model.response.ProductResponse;

import java.util.List;

public interface ProductDtoInter {
    ProductResponse GetAllProducts();
    ProductDto GetProductByid(int id);

    void İnsert(ProductDto productDto);

    void UpdatePut(ProductDto productDto,int id);

    void UpdatePatch(ProductDto productDto,int id);

    void DeleteByİd(int id);
}
