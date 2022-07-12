package aptech.t2010a.assignmentspringboot.api;


import aptech.t2010a.assignmentspringboot.entity.Product;
import aptech.t2010a.assignmentspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/products")
@CrossOrigin(value = "*")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product Product){
        productRepository.save(Product);
        return Product;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable UUID id){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            Product Product = optionalProduct.get();
            productRepository.delete(Product);
        }
        return false;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Product updateById(@RequestBody Product updateProduct, @PathVariable UUID id){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updateProduct.getName());
            existingProduct.setDetail(updateProduct.getDetail());
            existingProduct.setThumbnails(updateProduct.getThumbnails());
            existingProduct.setPrice(updateProduct.getPrice());
            existingProduct.setStatus(updateProduct.getStatus());
            productRepository.save(existingProduct);
        }
        return null;
    }
}