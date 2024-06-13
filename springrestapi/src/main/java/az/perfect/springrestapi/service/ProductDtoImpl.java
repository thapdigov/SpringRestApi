package az.perfect.springrestapi.service;

import az.perfect.springrestapi.model.Product;
import az.perfect.springrestapi.repository.ProductRepository;
import az.perfect.springrestapi.rest.model.request.ProductDto;
import az.perfect.springrestapi.rest.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductDtoImpl implements ProductDtoInter{

    private final ProductRepository productRepository;

    @Override
    public ProductResponse GetAllProducts() {
        List<Product>plist=productRepository.findAll();
        List<ProductDto>dtoList=new ArrayList<>();
        for(Product p:plist){
            dtoList.add(ConvertDto(p));
        }
        return new ProductResponse(dtoList);
    }

    @Override
    public ProductDto GetProductByid(int id) {
        Product p=productRepository.findById(id).orElseThrow();
        return ConvertDto(p);
    }

    @Override
    public void İnsert(ProductDto productDto) {
        Product p=ConvertEntity(productDto);
        productRepository.save(p);
    }

    @Override
    public void UpdatePut(ProductDto productDto, int id) {
        Product p=productRepository.findById(id).orElseThrow();
        p.setProduct_name(productDto.getProduct_name());
        p.setQuantity(productDto.getQuantity());
        p.setCountry_id(productDto.getCountry_id());
        p.setCategory_id(productDto.getCategory_id());
        productRepository.save(p);
    }

    @Override
    public void UpdatePatch(ProductDto productDto, int id) {
        Product p=productRepository.findById(id).orElseThrow();
        if(productDto.getProduct_name()!=null)
        p.setProduct_name(productDto.getProduct_name());
        if(productDto.getQuantity()>0)
        p.setQuantity(productDto.getQuantity());
        if(productDto.getCountry_id()>0)
        p.setCountry_id(productDto.getCountry_id());
        if(productDto.getCategory_id()>0)
        p.setCategory_id(productDto.getCategory_id());
        productRepository.save(p);

    }

    @Override
    public void DeleteByİd(int id) {
        Product p=productRepository.findById(id).orElseThrow();
        productRepository.delete(p);
    }

    public ProductDto ConvertDto(Product p){
        return ProductDto.builder()
                .product_id(p.getProduct_id())
                .product_name(p.getProduct_name())
                .quantity(p.getQuantity())
                .country_id(p.getCountry_id())
                .category_id(p.getCategory_id())
                .build();
    }
    public Product ConvertEntity(ProductDto p){
        return Product.builder()
                .product_id(p.getProduct_id())
                .product_name(p.getProduct_name())
                .quantity(p.getQuantity())
                .country_id(p.getCountry_id())
                .category_id(p.getCategory_id())
                .build();
    }
}
