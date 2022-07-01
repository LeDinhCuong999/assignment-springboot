package aptech.t2010a.assignmentspringboot.service;

import aptech.t2010a.assignmentspringboot.entity.Product;
import aptech.t2010a.assignmentspringboot.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


}
