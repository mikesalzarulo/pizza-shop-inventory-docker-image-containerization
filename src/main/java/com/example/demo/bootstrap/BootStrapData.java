package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if (productRepository.count() == 0 &  partRepository.count() == 0) {
        Product cheesePizza= new Product("Cheese Pizza",20.0,12);
        Product pepperoniPizza= new Product("Pepperoni Pizza",25.0, 10);
        Product meatLoverPizza= new Product("Meat Lover's Pizza",30.0,8);
        Product vegetarianPizza= new Product("Vegetarian Pizza",26.0,9);
        Product hawaiianPizza= new Product("Hawaiian Pizza",27.50,5);
        productRepository.save(cheesePizza);
        productRepository.save(pepperoniPizza);
        productRepository.save(meatLoverPizza);
        productRepository.save(vegetarianPizza);
        productRepository.save(hawaiianPizza);
        OutsourcedPart dough= new OutsourcedPart();
        dough.setCompanyName("Supremo");
        dough.setName("Dough");
        dough.setInv(10);
        dough.setPrice(8.0);
        dough.setMinInv(1);
        dough.setMaxInv(50);
        outsourcedPartRepository.save(dough);
        OutsourcedPart cheese= new OutsourcedPart();
        cheese.setCompanyName("Galbani");
        cheese.setName("Cheese");
        cheese.setInv(20);
        cheese.setPrice(5.0);
        cheese.setMinInv(2);
        cheese.setMaxInv(35);
        outsourcedPartRepository.save(cheese);
        OutsourcedPart sauce= new OutsourcedPart();
        sauce.setCompanyName("Casina");
        sauce.setName("Sauce");
        sauce.setInv(20);
        sauce.setPrice(6.0);
        sauce.setMinInv(10);
        sauce.setMaxInv(100);
        outsourcedPartRepository.save(sauce);
        OutsourcedPart spinach= new OutsourcedPart();
        spinach.setCompanyName("Del Monte");
        spinach.setName("Spinach");
        spinach.setInv(15);
        spinach.setPrice(5.0);
        spinach.setMinInv(5);
        spinach.setMaxInv(35);
        outsourcedPartRepository.save(spinach);
        OutsourcedPart oliveOil= new OutsourcedPart();
        oliveOil.setCompanyName("Colavita");
        oliveOil.setName("Olive Oil");
        oliveOil.setInv(20);
        oliveOil.setPrice(10.0);
        oliveOil.setMinInv(5);
        oliveOil.setMaxInv(40);
        outsourcedPartRepository.save(oliveOil);
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
