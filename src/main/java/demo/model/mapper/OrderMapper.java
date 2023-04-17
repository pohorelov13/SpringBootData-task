package demo.model.mapper;

import demo.model.dto.OrderDto;
import demo.model.entity.Order;

public interface OrderMapper {

    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);

}
