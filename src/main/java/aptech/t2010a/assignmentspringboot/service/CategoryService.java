package aptech.t2010a.assignmentspringboot.service;

import aptech.t2010a.assignmentspringboot.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


}
