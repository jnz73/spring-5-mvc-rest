package it.gianni.spring5mvcrest.bootstrap;


import it.gianni.spring5mvcrest.domain.Category;
import it.gianni.spring5mvcrest.domain.Customer;
import it.gianni.spring5mvcrest.repositories.CategoryRepository;
import it.gianni.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();


    }

    private void loadCategories() {

        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category data loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {

        Customer c1 = new Customer();
        c1.setFirstname("john");
        c1.setLastname("doe");

        Customer c2 = new Customer();
        c2.setFirstname("jane");
        c2.setLastname("doe");

        Customer c3 = new Customer();
        c3.setFirstname("bill");
        c3.setLastname("clinton");

        Customer c4 = new Customer();
        c4.setFirstname("frank");
        c4.setLastname("smith");

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);

        System.out.println("Customer data loaded = " + customerRepository.count());
    }
}
