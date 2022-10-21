package com.uam.ecommerce.repository;

import com.uam.ecommerce.model.DetalleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleOrderRepository extends JpaRepository<DetalleOrder,Long> {
}
