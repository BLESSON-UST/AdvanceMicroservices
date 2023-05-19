package com.ust.BookService.Controller;

import com.ust.BookService.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    @Autowired
    Environment environment;

    @GetMapping("/data")
    public String getBookData()
    {
        return "data of BOOK SERVICE, Running at port: " +
                environment.getProperty("local.server.port");
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id)
    {
        return new Book(id,"head first java",105.50);
    }

    @GetMapping("/all")
    public List<Book> getAll()
    {
        return List.of(
                new Book(501,"head first java",479.47),
                new Book(502,"spring in action",340.74),
                new Book(503,"hibernate in action",355.75)

        );
    }

    @GetMapping("/entity")
    public ResponseEntity<String> getEntityData()
    {
        return new ResponseEntity<String>(
                "hello from bookcontroller", HttpStatus.OK);
    }
}
