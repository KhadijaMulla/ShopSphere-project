// // package com.shopsphere.shop.service;

// // import com.shopsphere.shop.dto.ProductDTO;
// // import com.shopsphere.shop.dto.ProductMapper;
// // import com.shopsphere.shop.entity.Product;
// // import com.shopsphere.shop.repository.ProductRepository;

// // import org.springframework.data.domain.Page;
// // import org.springframework.data.domain.Pageable;
// // import org.springframework.stereotype.Service;

// // import java.util.List;
// // import java.util.Optional;

// // @Service
// // public class ProductService {

// //     private final ProductRepository productRepository;

// //     public ProductService(ProductRepository productRepository) {
// //         this.productRepository = productRepository;
// //     }

// //     public Product addProduct(Product product) {
// //         return productRepository.save(product);
// //     }

// //     public List<ProductDTO> getAllProducts() {

// //         List<Product> products = productRepository.findAll();

// //         return products.stream()
// //                 .map(ProductMapper::toDTO)
// //                 .toList();
// //     }

// //     public Optional<ProductDTO> getProductById(int id) {

// //         Optional<Product> product = productRepository.findById(id);

// //         if (product.isPresent()) {
// //             return Optional.of(ProductMapper.toDTO(product.get()));
// //         }

// //         return Optional.empty();
// //     }

// //     public Product updateProduct(int id, Product product) {

// //         Product existingProduct = productRepository.findById(id).orElse(null);

// //         if (existingProduct != null) {

// //             existingProduct.setName(product.getName());
// //             existingProduct.setDescription(product.getDescription());
// //             existingProduct.setBrand(product.getBrand());
// //             existingProduct.setPrice(product.getPrice());
// //             existingProduct.setQuantity(product.getQuantity());
// //             existingProduct.setImageUrl(product.getImageUrl());
// //             existingProduct.setCategory(product.getCategory());

// //             return productRepository.save(existingProduct);
// //         }

// //         return null;
// //     }

// //     public void deleteProduct(int id) {
// //         productRepository.deleteById(id);
// //     }

// //     public List<Product> searchProducts(String name) {
// //         return productRepository.findByNameContainingIgnoreCase(name);
// //     }

// //     public List<Product> getProductsByBrand(String brand) {
// //         return productRepository.findByBrandIgnoreCase(brand);
// //     }

// //     public List<Product> getProductsByCategory(String category) {
// //         return productRepository.findByCategoryNameIgnoreCase(category);
// //     }

// //     public Page<Product> getProductsWithPagination(Pageable pageable) {
// //         return productRepository.findAll(pageable);
// //     }
// // }
// package com.shopsphere.shop.service;

// import com.shopsphere.shop.dto.ProductDTO;
// import com.shopsphere.shop.dto.ProductMapper;
// import com.shopsphere.shop.entity.Product;
// import com.shopsphere.shop.repository.ProductRepository;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class ProductService {

//     private final ProductRepository productRepository;

//     public ProductService(ProductRepository productRepository) {
//         this.productRepository = productRepository;
//     }

//     public Product addProduct(Product product) {
//         return productRepository.save(product);
//     }

//     public List<ProductDTO> getAllProducts() {

//         List<Product> products = productRepository.findAll();

//         return products.stream()
//                 .map(ProductMapper::toDTO)
//                 .toList();
//     }

//     public Optional<ProductDTO> getProductById(int id) {

//         Optional<Product> product = productRepository.findById(id);

//         if (product.isPresent()) {
//             return Optional.of(ProductMapper.toDTO(product.get()));
//         }

//         return Optional.empty();
//     }

//     public Product updateProduct(int id, Product product) {

//         Product existingProduct = productRepository.findById(id).orElse(null);

//         if (existingProduct != null) {

//             existingProduct.setName(product.getName());
//             existingProduct.setDescription(product.getDescription());
//             existingProduct.setBrand(product.getBrand());
//             existingProduct.setPrice(product.getPrice());
//             existingProduct.setQuantity(product.getQuantity());
//             existingProduct.setImageUrl(product.getImageUrl());
//             existingProduct.setCategory(product.getCategory());

//             return productRepository.save(existingProduct);
//         }

//         return null;
//     }

//     public void deleteProduct(int id) {
//         productRepository.deleteById(id);
//     }

//     public List<ProductDTO> searchProducts(String name) {

//         List<Product> products =
//                 productRepository.findByNameContainingIgnoreCase(name);

//         return products.stream()
//                 .map(ProductMapper::toDTO)
//                 .toList();
//     }

//     public List<ProductDTO> getProductsByBrand(String brand) {

//         List<Product> products =
//                 productRepository.findByBrandIgnoreCase(brand);

//         return products.stream()
//                 .map(ProductMapper::toDTO)
//                 .toList();
//     }

//     public List<ProductDTO> getProductsByCategory(String category) {

//         List<Product> products =
//                 productRepository.findByCategoryNameIgnoreCase(category);

//         return products.stream()
//                 .map(ProductMapper::toDTO)
//                 .toList();
//     }

//     public Page<ProductDTO> getProductsWithPagination(Pageable pageable) {

//         Page<Product> products = productRepository.findAll(pageable);

//         return products.map(ProductMapper::toDTO);
//     }
// }
package com.shopsphere.shop.service;

import com.shopsphere.shop.dto.ProductDTO;
import com.shopsphere.shop.dto.ProductMapper;
import com.shopsphere.shop.entity.Product;
import com.shopsphere.shop.exception.ResourceNotFoundException;
import com.shopsphere.shop.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public ProductDTO getProductById(int id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));

        return ProductMapper.toDTO(product);
    }

    public Product updateProduct(int id, Product product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setCategory(product.getCategory());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {

        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Product not found with id: " + id);
        }

        productRepository.deleteById(id);
    }

    public List<ProductDTO> searchProducts(String name) {

        List<Product> products =
                productRepository.findByNameContainingIgnoreCase(name);

        return products.stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public List<ProductDTO> getProductsByBrand(String brand) {

        List<Product> products =
                productRepository.findByBrandIgnoreCase(brand);

        return products.stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public List<ProductDTO> getProductsByCategory(String category) {

        List<Product> products =
                productRepository.findByCategoryNameIgnoreCase(category);

        return products.stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public Page<ProductDTO> getProductsWithPagination(Pageable pageable) {

        Page<Product> products = productRepository.findAll(pageable);

        return products.map(ProductMapper::toDTO);
    }
}