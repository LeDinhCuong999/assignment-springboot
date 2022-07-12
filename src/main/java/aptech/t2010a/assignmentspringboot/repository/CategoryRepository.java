package aptech.t2010a.assignmentspringboot.repository;

import aptech.t2010a.assignmentspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
