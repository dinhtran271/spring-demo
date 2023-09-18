package vn.vdef.learn.spring.clothes.Controller;

import vn.vdef.learn.spring.clothes.DTO.Request.OrderRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.OrderResponseDTO;
import vn.vdef.learn.spring.clothes.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "add-order")
    public OrderResponseDTO addOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.addOrder(orderRequestDTO);
    }

    @GetMapping("get-order")
    public OrderResponseDTO getOrder(@RequestParam Long id) {
        return orderService.getOrder(id);
    }

    @DeleteMapping("delete-order")
    public void deleteOrderById(@RequestParam Long id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping("update-order")
    public OrderResponseDTO updateOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.updateOrder(orderRequestDTO);
    }
}
