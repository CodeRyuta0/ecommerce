package com.uam.ecommerce.service;

import com.uam.ecommerce.model.DetalleOrder;
import com.uam.ecommerce.model.Order;
import com.uam.ecommerce.repository.IDetalleOrderRepository;
import com.uam.ecommerce.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpServiceOrder implements IServiceOrder{

    @Autowired
    private IOrderRepository repoOrder;

    @Autowired
    private IDetalleOrderRepository repoDet;

    @Override
    public List<Order> listAll() {
        return repoOrder.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        List<DetalleOrder> detalles = order.getDetalles();
        order.setDetalles(null);
        Order o = repoOrder.save(order);
        for (DetalleOrder det : detalles) {
            det.setIdOrder(o.getId());
        }
        repoDet.saveAll(detalles);
        o.setDetalles(detalles);
        return o;
    }

}
