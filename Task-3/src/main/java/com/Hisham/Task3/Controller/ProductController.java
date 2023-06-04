package com.Hisham.Task3.Controller;

import com.Hisham.Task3.Models.Product;
import com.Hisham.Task3.RequestObject.GetProductRequestObject;
import com.Hisham.Task3.ResponseObject.GetProductResponse;
import com.Hisham.Task3.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("api/products")
    public void saveProduct (@RequestBody GetProductRequestObject productRequestObject) {
        createProduct(productRequestObject);
    }

    @GetMapping("api/products")
    public List<Product> getProduct () {
        return productService.getProduct();
    }

    @GetMapping("api/products/{productId}")
    public GetProductResponse createProduct (@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/api/products/{productId}")
    public ResponseEntity<GetProductResponse> updateProduct(@PathVariable Long productId, @RequestBody GetProductRequestObject updatedProduct) {
        GetProductResponse response = productService.updateProduct(productId, updatedProduct);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("api/products/delete/{productId}")
    public void deleteProduct (@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }


    public void createProduct(GetProductRequestObject productRequestObject) {

        Product product = new Product();
        product.setName(productRequestObject.getName());
        product.setIngredients("Not Important");
        product.setQuantity(productRequestObject.getQuantity());
        product.setPrice(productRequestObject.getPrice());
        product.setCreatedDate(new Date());
        product.setIsActive(true);
        productService.saveProduct(product);
    }
}
