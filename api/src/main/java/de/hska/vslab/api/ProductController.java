package de.hska.vslab.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @GetMapping
    public Response getProduct() {
        // Login user
        // TODO return category
        return Response.ok().build();
    }

}
