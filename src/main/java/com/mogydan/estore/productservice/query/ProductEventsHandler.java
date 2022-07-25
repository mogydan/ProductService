package com.mogydan.estore.productservice.query;

import com.mogydan.estore.productservice.core.data.ProductEntity;
import com.mogydan.estore.productservice.core.data.ProductsRepository;
import com.mogydan.estore.productservice.core.events.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductEventsHandler  {
    private final ProductsRepository repository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(event, entity);
        repository.save(entity);
    }
}
