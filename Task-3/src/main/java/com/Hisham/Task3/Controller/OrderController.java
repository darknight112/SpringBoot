package com.Hisham.Task3.Controller;

import com.Hisham.Task3.Models.Order;
import com.Hisham.Task3.Models.Product;
import com.Hisham.Task3.RequestObject.GetOrderRequestObject;
import com.Hisham.Task3.RequestObject.GetProductRequestObject;
import com.Hisham.Task3.ResponseObject.GetOrderResponse;
import com.Hisham.Task3.ResponseObject.GetProductResponse;
import com.Hisham.Task3.Service.OrderService;
import com.Hisham.Task3.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @PostMapping("api/create_order")
    public ResponseEntity<String> placeOrder(@RequestBody GetOrderRequestObject orderRequest) {
        long productId = orderRequest.getProductId();
        int orderedQuantity = orderRequest.getQuantity();

        // Retrieve the product from the database
        GetProductResponse productResponse = productService.getProductById(productId);

        if (productResponse != null) {
            // Check if there is enough quantity in inventory
            if (productResponse.getQuantity() >= orderedQuantity) {
                // Update the inventory quantity
                int updatedQuantity = productResponse.getQuantity() - orderedQuantity;
                productService.updateProduct(productId, new GetProductRequestObject(
                        productResponse.getName(),
                        productResponse.getPrice(),
                        updatedQuantity
                ));

                // Create the order
                Order order = new Order();

                // Set the associated product
                Product product = new Product();
                product.setName(productResponse.getName());
                product.setPrice(productResponse.getPrice());
                product.setIngredients(productResponse.getIngredients());
                product.setQuantity(productResponse.getQuantity());
                order.setProduct(product);
                Double total = orderRequest.getQuantity()*productResponse.getPrice();

                order.setQuantity(orderedQuantity);
                orderService.saveOrder(order);

                return ResponseEntity.ok("Order placed successfully" +
                        " Total amount:"+ total );
            } else {
                return ResponseEntity.badRequest().body("Insufficient quantity in inventory");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }



//    @PostMapping("api/orders")
//    public void saveOrder (@RequestBody GetOrderRequestObject orderRequestObject) {
//        createOrder(orderRequestObject);
//    }

    @GetMapping("api/orders")
    public List<Order> getOrder () {
        return orderService.getOrder();
    }

    @GetMapping("api/orders/{orderId}")
    public GetOrderResponse createOrder (@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    public void createOrder(GetOrderRequestObject orderRequestObject) {

        Order order = new Order();
        order.setQuantity(orderRequestObject.getQuantity());
        order.setShipping_address("NOT IMPORTANT");
        order.setCreatedDate(new Date());
        order.setIsActive(true);
        orderService.saveOrder(order);
    }

}
