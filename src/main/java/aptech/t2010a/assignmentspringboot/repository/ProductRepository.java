package aptech.t2010a.assignmentspringboot.repository;

import aptech.t2010a.assignmentspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {


}
