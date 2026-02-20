package com.Training.Test.demo.Controller;

import com.Training.Test.demo.Model.Product;
import com.Training.Test.demo.Service.ProductService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
       /* List<Product> item= new ArrayList<>();
        item.add(new Product(1,"TV",100));
*/
        List<Product> products=service.getAllProducts();


        return ResponseEntity.ok(products);
    }
    @GetMapping("/getProductById/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
      Product prod=service.getProductById(prodId);
      if(prod==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.ok(prod);

        //return service.getProductById(prodId);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product prod){
        Product product=service.addProduct(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product prod){
        Product product= service.updateProduct(id,prod);
        if(product==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public Product deleteMapping(@PathVariable int id){



        return service.deleteProduct(id);
    }


    /*@Autowired
    private ProductService service;
   @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
   return service.getAllProducts();
}
*/


}
