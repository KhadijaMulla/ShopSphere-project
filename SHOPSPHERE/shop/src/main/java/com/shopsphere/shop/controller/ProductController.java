// // package com.shopsphere.shop.controller;

// // import com.shopsphere.shop.dto.ProductDTO;
// // import com.shopsphere.shop.entity.Product;
// // import com.shopsphere.shop.service.ProductService;

// // import jakarta.validation.Valid;

// // import org.springframework.data.domain.Page;
// // import org.springframework.data.domain.Pageable;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;
// // import java.util.Optional;

// // @RestController
// // @RequestMapping("/products")
// // public class ProductController {

// //     private final ProductService productService;

// //     public ProductController(ProductService productService) {
// //         this.productService = productService;
// //     }

// //     @PostMapping
// //     public Product addProduct(@Valid @RequestBody Product product) {
// //         return productService.addProduct(product);
// //     }

// //     @GetMapping
// //     public List<ProductDTO> getAllProducts() {
// //         return productService.getAllProducts();
// //     }

// //     @GetMapping("/{id}")
// //     public Optional<ProductDTO> getProductById(@PathVariable int id) {
// //         return productService.getProductById(id);
// //     }

// //     @PutMapping("/{id}")
// //     public Product updateProduct(
// //             @PathVariable int id,
// //             @Valid @RequestBody Product product) {

// //         return productService.updateProduct(id, product);
// //     }

// //     @DeleteMapping("/{id}")
// //     public void deleteProduct(@PathVariable int id) {
// //         productService.deleteProduct(id);
// //     }

// //     @GetMapping("/search")
// //     public List<Product> searchProducts(@RequestParam String name) {
// //         return productService.searchProducts(name);
// //     }

// //     @GetMapping("/brand")
// //     public List<Product> getProductsByBrand(@RequestParam String brand) {
// //         return productService.getProductsByBrand(brand);
// //     }

// //     @GetMapping("/category")
// //     public List<Product> getProductsByCategory(@RequestParam String category) {
// //         return productService.getProductsByCategory(category);
// //     }

// //     @GetMapping("/page")
// //     public Page<Product> getProductsWithPagination(Pageable pageable) {
// //         return productService.getProductsWithPagination(pageable);
// //     }
// // }
// package com.shopsphere.shop.controller;

// import com.shopsphere.shop.dto.ProductDTO;
// import com.shopsphere.shop.entity.Product;
// import com.shopsphere.shop.service.ProductService;

// import jakarta.validation.Valid;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/products")
// public class ProductController {

//     private final ProductService productService;

//     public ProductController(ProductService productService) {
//         this.productService = productService;
//     }

//     @PostMapping
//     public Product addProduct(@Valid @RequestBody Product product) {
//         return productService.addProduct(product);
//     }

//     @GetMapping
//     public List<ProductDTO> getAllProducts() {
//         return productService.getAllProducts();
//     }

//     @GetMapping("/{id}")
//     public Optional<ProductDTO> getProductById(@PathVariable int id) {
//         return productService.getProductById(id);
//     }

//     @PutMapping("/{id}")
//     public Product updateProduct(
//             @PathVariable int id,
//             @Valid @RequestBody Product product) {

//         return productService.updateProduct(id, product);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteProduct(@PathVariable int id) {
//         productService.deleteProduct(id);
//     }

//     @GetMapping("/search")
//     public List<ProductDTO> searchProducts(@RequestParam String name) {
//         return productService.searchProducts(name);
//     }

//     @GetMapping("/brand")
//     public List<ProductDTO> getProductsByBrand(@RequestParam String brand) {
//         return productService.getProductsByBrand(brand);
//     }

//     @GetMapping("/category")
//     public List<ProductDTO> getProductsByCategory(@RequestParam String category) {
//         return productService.getProductsByCategory(category);
//     }

//     @GetMapping("/page")
//     public Page<ProductDTO> getProductsWithPagination(Pageable pageable) {
//         return productService.getProductsWithPagination(pageable);
//     }
// }
package com.shopsphere.shop.controller;

import com.shopsphere.shop.dto.ProductDTO;
import com.shopsphere.shop.entity.Product;
import com.shopsphere.shop.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @Valid @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

    @GetMapping("/brand")
    public List<ProductDTO> getProductsByBrand(@RequestParam String brand) {
        return productService.getProductsByBrand(brand);
    }

    @GetMapping("/category")
    public List<ProductDTO> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/page")
    public Page<ProductDTO> getProductsWithPagination(Pageable pageable) {
        return productService.getProductsWithPagination(pageable);
    }
}