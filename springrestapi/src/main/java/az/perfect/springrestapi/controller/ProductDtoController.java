package az.perfect.springrestapi.controller;

import az.perfect.springrestapi.rest.model.request.ProductDto;
import az.perfect.springrestapi.rest.model.response.ProductResponse;
import az.perfect.springrestapi.service.ProductDtoInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductDtoController {
    private final ProductDtoInter productDtoInter;

    @GetMapping("all")
    public ProductResponse getallproducts() {
        return productDtoInter.GetAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable("id") int id) {
        return productDtoInter.GetProductByid(id);
    }

    @PostMapping
    public void insert(@RequestBody ProductDto productDto) {
        productDtoInter.İnsert(productDto);
    }
    @PutMapping("/{id}")
    public void updatePut(@RequestBody ProductDto p, @PathVariable("id") int id){
        productDtoInter.UpdatePut(p,id);
    }

    @PatchMapping("/{id}")
    public void updatePatch(@RequestBody ProductDto p, @PathVariable("id") int id){
        productDtoInter.UpdatePatch(p,id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        productDtoInter.DeleteByİd(id);

    }
}
