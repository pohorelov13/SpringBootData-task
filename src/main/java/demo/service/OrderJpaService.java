package demo.service;

import demo.exception.OrderDoesNotExistException;
import demo.model.dto.OrderDto;
import demo.model.dto.ProductDto;
import demo.model.entity.Order;
import demo.model.entity.Product;
import demo.model.mapper.OrderMapper;
import demo.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderJpaService implements OrderService {
    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    @Override
    public void add(OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        double cost = 0;
        for (Product p : order.getProducts()) {
            p.setOrder(order);
            cost += p.getCost();
        }
        order.setCost(cost);
        order.setDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Override
    public OrderDto getById(Long id) throws OrderDoesNotExistException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderDoesNotExistException("WRONG ID"));
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> all = new ArrayList<>();
        orderRepository.findAll().forEach(all::add);
        return all.stream().map(orderMapper::orderToOrderDto).toList();
    }

    @Override
    public void remove(OrderDto orderDto) {
        orderRepository.delete(orderMapper.orderDtoToOrder(orderDto));
    }

}
