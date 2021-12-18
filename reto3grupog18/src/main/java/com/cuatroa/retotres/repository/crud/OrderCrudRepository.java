/**
 * 
 */
package com.cuatroa.retotres.repository.crud;
/**
 * 
 */
import com.cuatroa.retotres.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 *  @author Ernesto Trompa 
 *  G18 MINTIC
 * 
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> 
{
    List<Order> findBySalesManZone(String zone);
    List<Order> findBySalesManId(Integer id);
    List<Order> findBySalesManIdAndStatus(Integer id, String status);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
    
}

