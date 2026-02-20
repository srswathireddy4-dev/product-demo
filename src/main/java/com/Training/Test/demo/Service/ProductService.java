package com.Training.Test.demo.Service;

import com.Training.Test.demo.Model.Product;
import com.Training.Test.demo.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {


      //  return repo.findAll();
        Iterable<Product> iterable = repo.findAll();
        Iterator<Product> iterator = iterable.iterator();
        List<Product> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }

    public Product getProductById(int id) {

        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product prod) {
        // products.add(prod);
        return repo.save(prod);
    }

    public Product updateProduct(int id, Product prod) {

        return repo.save(prod);
    }

    public Product deleteProduct(int id) {
        Product product = repo.findById(id).orElse(null);
        try {
            repo.deleteById(id);
            return product;
        } catch (Exception e) {
            return null;
        }
    }
        // private final Product product;
        //private final Product product;
    /*List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "tata", 5000),
            new Product(2, "mahin", 500)
    )
    );

    public ProductService(Product product) {
        this.product = product;
    }

*/

   /* public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product addProduct(Product prod) {
        products.add(prod);
        return prod;
    }

    public Product updateProduct(int id, Product prod) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setId(prod.getId());
                p.setName(prod.getName());
                p.setPrice(prod.getPrice());
            }
        }
        return null;
    }

    public String deleteProduct(int id) {

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                return "deleted";
            }


        }
        return "Product not found";
    }*/
    }





