package com.uam.ecommerce.controller;

import com.uam.ecommerce.model.Order;
import com.uam.ecommerce.service.IServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class ControllerOrder {
    @Autowired
    private IServiceOrder serviceOrder;

    @GetMapping("/list")
    public List<Order> getAll(){
        return serviceOrder.listAll();
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return serviceOrder.saveOrder(order);
    }
}
