package demo.model.mapper;

import demo.model.dto.ProductDto;
import demo.model.entity.Product;

public interface ProductMapper {
    ProductDto productToProductDto(Product product);
}
