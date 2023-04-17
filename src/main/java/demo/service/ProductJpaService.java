package demo.service;

import demo.exception.ProductDoesNotExistException;
import demo.model.dto.ProductDto;
import demo.model.entity.Product;
import demo.model.mapper.ProductMapper;
import demo.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductJpaService implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;


    @Override
    public ProductDto getById(Long id) throws ProductDoesNotExistException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductDoesNotExistException("WRONG ID"));
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> all = new ArrayList<>();
        productRepository.findAll().forEach(all::add);
        return all.stream().map(productMapper::productToProductDto).toList();
    }

    private ProductDto productToProductDto(Product product) {
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .orderId(product.getOrder().getId())
                .build();
    }

}
