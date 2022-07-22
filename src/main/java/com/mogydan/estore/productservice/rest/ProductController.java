package com.mogydan.estore.productservice.rest;

import com.mogydan.estore.productservice.command.CreateProductCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(createProductRestModel.getTitle())
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .build();

        return commandGateway.sendAndWait(createProductCommand);
    }

    @GetMapping
    public String getProduct() {
        return "HTTP Get is handled";
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP Put is handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP Delete is handled";
    }
}
