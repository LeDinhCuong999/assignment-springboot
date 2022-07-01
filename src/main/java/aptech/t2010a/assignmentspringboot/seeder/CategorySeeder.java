package aptech.t2010a.assignmentspringboot.seeder;

import aptech.t2010a.assignmentspringboot.entity.Category;
import aptech.t2010a.assignmentspringboot.repository.CategoryRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class CategorySeeder {

    public static List<Category> categories;
    public static final int NUMBER_OF_CATEGORY = 20;

    @Autowired
    CategoryRepository categoryRepository;

    public void generate() {
        log.debug("------------Seeding category-------------");
        Faker faker = new Faker();
        categories = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CATEGORY; i++) {
            categories.add(Category.builder()
                    .id(UUID.randomUUID())
                    .name(faker.name().name())
                    .build());
        }
        categoryRepository.saveAll(categories);
        log.debug("--------------End of seeding category-------------");
    }

}