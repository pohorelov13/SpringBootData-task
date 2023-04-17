package demo.service;

import demo.exception.OrderDoesNotExistException;
import demo.model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void add(OrderDto orderDto);

    OrderDto getById(Long id) throws OrderDoesNotExistException;

    List<OrderDto> getAll();

    void remove(OrderDto orderDto);
}
