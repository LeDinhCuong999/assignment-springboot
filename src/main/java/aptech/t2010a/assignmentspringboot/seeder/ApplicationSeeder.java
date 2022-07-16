package aptech.t2010a.assignmentspringboot.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ApplicationSeeder implements CommandLineRunner {

    @Autowired
    CategorySeeder categorySeeder;
    @Autowired
    ProductSeeder productSeeder;
    @Autowired
    OrderSeeder orderSeeder;

    @Autowired
    AccountSeeder accountSeeder;

    @Override
    public void run(String... args) {
        accountSeeder.generate();
        categorySeeder.generate();
        productSeeder.generate();
        orderSeeder.generate();
    }
}
