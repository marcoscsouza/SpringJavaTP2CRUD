package br.com.marcoscsouza.Tp2.services;

import br.com.marcoscsouza.Tp2.Repositories.ProductRepository;
import br.com.marcoscsouza.Tp2.controllers.ProductController;
import br.com.marcoscsouza.Tp2.dtos.ProductRecordDto;
import br.com.marcoscsouza.Tp2.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = productRepository.findAll();
        if (!productList.isEmpty()) {
            for (Product product : productList) {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    public ResponseEntity<Object> findById(UUID id) {
        Optional<Product> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productO.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());

    }

    public ResponseEntity<Product> save(ProductRecordDto productRecordDto) {
        var  productModel = new Product();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    public ResponseEntity<Object> update(UUID id, ProductRecordDto productRecordDto) {
        Optional<Product> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found.");
        }
        var product = productO.get();
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
    }

    public ResponseEntity<Object> delete(UUID id) {
        Optional<Product> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found.");
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("product deleted.");
    }


}
