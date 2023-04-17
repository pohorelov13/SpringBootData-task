package demo.service;

import demo.exception.ProductDoesNotExistException;
import demo.model.dto.ProductDto;
import demo.model.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto getById(Long id) throws ProductDoesNotExistException;

    List<ProductDto> getAll();

}
