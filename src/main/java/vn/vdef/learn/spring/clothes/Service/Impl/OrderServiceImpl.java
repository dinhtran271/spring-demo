package vn.vdef.learn.spring.clothes.Service.Impl;

import vn.vdef.learn.spring.clothes.Constants.ExceptionConstant;
import vn.vdef.learn.spring.clothes.Convert.OrderConvert;
import vn.vdef.learn.spring.clothes.Convert.ProductConvert;
import vn.vdef.learn.spring.clothes.Convert.UserConvert;
import vn.vdef.learn.spring.clothes.DTO.Request.OrderRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Request.ProductRequestDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.OrderResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.ProductResponseDTO;
import vn.vdef.learn.spring.clothes.DTO.Response.UserResponseDTO;
import vn.vdef.learn.spring.clothes.Entity.Order;
import vn.vdef.learn.spring.clothes.Entity.OrderProduct;
import vn.vdef.learn.spring.clothes.Entity.Product;
import vn.vdef.learn.spring.clothes.Entity.User;
import vn.vdef.learn.spring.clothes.Exception.NotFoundException;
import vn.vdef.learn.spring.clothes.Repository.OrderProductRepository;
import vn.vdef.learn.spring.clothes.Repository.OrderRepository;
import vn.vdef.learn.spring.clothes.Repository.ProductRepository;
import vn.vdef.learn.spring.clothes.Repository.UserRepository;
import vn.vdef.learn.spring.clothes.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    OrderConvert orderConvert;
    @Autowired
    ProductConvert productConvert;
    @Autowired
    UserConvert userConvert;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderConvert.toEntity(orderRequestDTO);
        User user = userRepository.getById(orderRequestDTO.getUserNo());
        order.setUser(user);
        order = orderRepository.save(order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (ProductRequestDTO productRequestDTO: orderRequestDTO.getProductRequestDTOS()) {
            OrderProduct orderProduct = new OrderProduct();
            Product product = productConvert.toEntity(productRequestDTO);
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProducts.add(orderProduct);
        }
        order.setOrderProducts(orderProducts);
        orderProducts = orderProductRepository.saveAll(orderProducts);
//      Tra ra data
        Order orderGet = orderRepository.findById(order.getOderNo()).get();
        OrderResponseDTO orderResponseDTO = orderConvert.toDTO(orderGet);
        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        userResponseDTO.setRoleName(user.getRole().getRoleName());
        orderResponseDTO.setUserResponseDTO(userResponseDTO);

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        BigDecimal amountOfMoney = BigDecimal.ZERO;
        for (OrderProduct orderProductGet : orderGet.getOrderProducts()) {
            Product product = productRepository.getById(orderProductGet.getProduct().getProductNo());
            ProductResponseDTO productResponseDTO = productConvert.toDTO(product);
            productResponseDTOList.add(productResponseDTO);
            amountOfMoney = amountOfMoney.add(product.getPrice());
        }
        orderResponseDTO.setProductResponseDTOList(productResponseDTOList);
        orderResponseDTO.setAmountOfMoney(amountOfMoney);

        return orderResponseDTO;
    }

    @Override
    public OrderResponseDTO getOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            OrderResponseDTO orderDTO = orderConvert.toDTO(order);

            List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

            BigDecimal totalAmount = BigDecimal.ZERO;

            for (OrderProduct orderProduct : order.getOrderProducts()) {
                ProductResponseDTO productResponseDTO = productConvert.toDTO(orderProduct.getProduct());
                productResponseDTOList.add(productResponseDTO);

                totalAmount = totalAmount.add(orderProduct.getProduct().getPrice());
            }
            orderDTO.setAmountOfMoney(totalAmount);
            orderDTO.setProductResponseDTOList(productResponseDTOList);
            return orderDTO;
        }
        return new OrderResponseDTO();
    }

    @Transactional
    @Override
    public void deleteOrderById(Long id) {
            orderProductRepository.deleteOrderProductsByOrderNo(id);
            orderRepository.deleteByOrderNo(id);
    }
    @Transactional
    @Override
    public OrderResponseDTO updateOrder(OrderRequestDTO orderRequestDTO) {
        if (orderRequestDTO.getOrderNo() != null && orderRequestDTO.getUserNo() != null) {
            Optional<Order> orderOptional = orderRepository.findById(orderRequestDTO.getOrderNo());
            Optional<User> userOptional = userRepository.findById(orderRequestDTO.getUserNo());

            orderProductRepository.deleteOrderProductsByOrderNo(orderRequestDTO.getOrderNo());
            List<ProductRequestDTO> productRequestDTOList = orderRequestDTO.getProductRequestDTOS();

            List<OrderProduct> orderProducts = new ArrayList<>();
            for (ProductRequestDTO productRequestDTO : productRequestDTOList) {
                Optional<Product> productOptional = productRepository.findById(productRequestDTO.getProductNo());

                if (!orderOptional.isPresent() || !userOptional.isPresent() || !productOptional.isPresent()) {
                    throw new NotFoundException(ExceptionConstant.ORDER_OR_USER_IS_NULL);
                }
                Order order = orderOptional.get();
                User user = userOptional.get();
                order.setUser(user);
                orderRepository.save(order);

                OrderProduct orderProduct = new OrderProduct();
                Product product = productOptional.get();
                orderProduct.setOrder(order);
                orderProduct.setProduct(product);
                orderProducts.add(orderProduct);
            }
                orderProductRepository.saveAll(orderProducts);

                OrderResponseDTO orderResponseDTO = orderConvert.toDTO(orderOptional.get());
                UserResponseDTO userResponseDTO = userConvert.toDTO(userOptional.get());
                orderResponseDTO.setUserResponseDTO(userResponseDTO);
                List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
                BigDecimal total = BigDecimal.ZERO;

                for(OrderProduct orderProduct : orderProducts) {
                    ProductResponseDTO productResponseDTO = productConvert.toDTO(orderProduct.getProduct());
                    productResponseDTOList.add(productResponseDTO);
                    total = total.add(orderProduct.getProduct().getPrice());
                }
                orderResponseDTO.setProductResponseDTOList(productResponseDTOList);
                orderResponseDTO.setAmountOfMoney(total);
                return orderResponseDTO;
            }

        return new OrderResponseDTO();
    }
}
