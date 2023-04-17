package demo.model.mapper;

import demo.model.dto.ProductDto;
import demo.model.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductDto(Product product) {
        if (product == null) return null;
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .orderId(product.getOrder().getId())
                .build();
    }
}
