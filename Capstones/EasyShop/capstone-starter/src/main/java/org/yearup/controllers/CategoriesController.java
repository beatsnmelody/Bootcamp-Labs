package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;
import java.util.Optional;

// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoriesController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;


    // create an Autowired controller to inject the categoryDao and ProductDao

    // add the appropriate annotation for a get action
    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        // find and return all categories
        return new ResponseEntity<>(categoryDao.getAllCategories(), HttpStatus.OK);
    }

    // add the appropriate annotation for a get action
    @GetMapping("{categoryId}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Optional<Category>> getById(@PathVariable int categoryId)
    {
        // get the category by id
        return new ResponseEntity<>(categoryDao.getById(categoryId), HttpStatus.OK);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId)
    {
        // get a list of product by categoryId
        return new ResponseEntity<>(productDao.listByCategoryId(categoryId), HttpStatus.OK);
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> addCategory (@RequestBody Category category)
    {
        // insert the category
        var categoryToCreate = categoryDao.create(category);
        return new ResponseEntity<>(categoryToCreate, HttpStatus.CREATED);
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @PutMapping("{categoryId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> updateCategory(@PathVariable int categoryId, @RequestBody Category category)
    {
        // update the category by id
        try {
            var categoryToUpdate = categoryDao.getById(categoryId);

            if (categoryToUpdate.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            categoryDao.update(categoryId, category);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @DeleteMapping("{categoryId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable int categoryId)
    {
        // delete the category by id
        try {
            var categoryToDelete = categoryDao.getById(categoryId);

            if (categoryToDelete.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            categoryDao.delete(categoryId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }
}
