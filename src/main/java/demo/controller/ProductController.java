package demo.controller;

import demo.exception.ProductDoesNotExistException;
import demo.model.dto.ProductDto;
import demo.model.entity.Product;
import demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ProductDto getById(@PathVariable("id") long id) throws ProductDoesNotExistException {
        return productService.getById(id);
    }

}
