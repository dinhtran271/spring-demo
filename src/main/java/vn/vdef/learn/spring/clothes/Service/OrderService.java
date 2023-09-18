package vn.vdef.learn.spring.clothes.Service;

import vn.vdef.learn.spring.clothes.DTO.Request.OrderRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrder(Long id);

    void deleteOrderById(Long id);

    OrderResponseDTO updateOrder(OrderRequestDTO orderRequestDTO);
}
