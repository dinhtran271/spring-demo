package vn.vdef.learn.spring.clothes.Convert;

import vn.vdef.learn.spring.clothes.DTO.Request.OrderRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.OrderResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConvert {
    public OrderResponseDTO toDTO(Order order) {
        OrderResponseDTO orderDTO = new OrderResponseDTO();
        orderDTO.setOrderNo(order.getOderNo());
        return orderDTO;
    }

    public Order toEntity(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setOderNo(orderRequestDTO.getOrderNo());
        return order;
    }
}
