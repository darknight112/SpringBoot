package com.Hisham.Task3.Service;

import com.Hisham.Task3.Models.Product;
import com.Hisham.Task3.Reposetory.ProductRepository;
import com.Hisham.Task3.RequestObject.GetProductRequestObject;
import com.Hisham.Task3.ResponseObject.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public GetProductResponse updateProduct(Long productId, GetProductRequestObject updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setIngredients("NOT IMPORTANT");
            product.setQuantity(updatedProduct.getQuantity());
            product.setUpdatedDate(new Date());
            productRepository.save(product);
            return getProductById(productId);
        }
        return null;
    }


    public GetProductResponse getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            GetProductResponse productResponse = new GetProductResponse();
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setIngredients(product.getIngredients());
            productResponse.setQuantity(product.getQuantity());
            return productResponse;
        }
        return null;
    }

    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }



}
