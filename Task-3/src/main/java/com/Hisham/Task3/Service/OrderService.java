package com.Hisham.Task3.Service;

import com.Hisham.Task3.Models.Order;
import com.Hisham.Task3.Models.Product;
import com.Hisham.Task3.Reposetory.OrderRepository;
import com.Hisham.Task3.Reposetory.ProductRepository;
import com.Hisham.Task3.ResponseObject.GetOrderResponse;
import com.Hisham.Task3.ResponseObject.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }


    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public GetOrderResponse getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            GetOrderResponse orderResponse = new GetOrderResponse();
            orderResponse.setShipping_address("NOT IMPORTANT");
            orderResponse.setQuantity(order.getQuantity());
            return orderResponse;
        }
        return null;
    }


//    public void processOrder(long productId, int orderedQuantity) {
//        // Retrieve the chocolate product from the database
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Chocolate product not found"));
//
//        // Get the current inventory quantity
//        int currentQuantity = chocolate.getQuantity();
//
//        // Calculate the new inventory quantity after the order
//        int updatedQuantity = currentQuantity - orderedQuantity;
//
//        if (updatedQuantity >= 0) {
//            // Update the inventory quantity
//            chocolate.setQuantity(updatedQuantity);
//            chocolateRepository.save(chocolate);
//        } else {
//            throw new IllegalArgumentException("Insufficient quantity in inventory");
//        }
//    }


}
