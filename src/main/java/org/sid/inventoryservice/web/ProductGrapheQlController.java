package org.sid.inventoryservice.web;

import org.sid.inventoryservice.dto.ProductRequestDTO;
import org.sid.inventoryservice.entity.Category;
import org.sid.inventoryservice.entity.Product;
import org.sid.inventoryservice.repository.CategoryRepository;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
public class ProductGrapheQlController {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductGrapheQlController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @QueryMapping
    public List<Product> productList(){
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return productRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Product %s not found ",id))
        );
    }
    @QueryMapping
    public  List<Category> categories(){
        return categoryRepository.findAll();
    }
    @QueryMapping
    public  Category categoryById(@Argument Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Category % not founf ", id)));
    }
    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO product){
        Category category=categoryRepository.findById(product.categoryId()).orElse(null); /// il va chercher la categorie dans product
        Product productToSave=new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);

    }
    @MutationMapping
    public Product updateProduct(@Argument String id, @Argument ProductRequestDTO product){
        Category category=categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave=new Product();
        productToSave.setId(id);
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }
    @MutationMapping
    public void deleteProduct(@Argument String id) {
        productRepository.deleteById(id);
    }

}
