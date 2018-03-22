package spring5mvcrest.bootstrap;


import spring5mvcrest.domain.Category;
import spring5mvcrest.domain.Customer;
import spring5mvcrest.domain.Vendor;
import spring5mvcrest.repositories.CategoryRepository;
import spring5mvcrest.repositories.CustomerRepository;
import spring5mvcrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;
    VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();


    }

    private void loadVendors() {
        Vendor v1 = new Vendor();
        v1.setName("ACEA srl");
        Vendor v2 = new Vendor();
        v2.setName("ENI srl");
        Vendor v3 = new Vendor();
        v3.setName("Telecom srl");
        Vendor v4 = new Vendor();
        v4.setName("FIAT srl");
        Vendor v5 = new Vendor();
        v5.setName("Rai spa");
        Vendor v6 = new Vendor();
        v6.setName("AUTOSTRADE spa");
        vendorRepository.save(v1);
        vendorRepository.save(v2);
        vendorRepository.save(v3);
        vendorRepository.save(v4);
        vendorRepository.save(v5);
        vendorRepository.save(v6);

        System.out.println("Vendor data loaded = " + vendorRepository.count());

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
