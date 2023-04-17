package demo.controller;

import demo.exception.OrderDoesNotExistException;
import demo.model.dto.OrderDto;
import demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody OrderDto getById(@PathVariable("id") long id) throws OrderDoesNotExistException {
        return orderService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody OrderDto orderDto) {
        orderService.add(orderDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void remove(@RequestBody OrderDto orderDto) {
        orderService.remove(orderDto);
    }
}
