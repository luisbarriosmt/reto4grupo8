/**
 * 
 */
package com.cuatroa.retotres.service;
/**
 * 
 */
import com.cuatroa.retotres.model.Order;
import com.cuatroa.retotres.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 *  @author Ernesto Trompa 
 *  G18 MINTIC
 * 
 */
@Service
public class OrderService 
{
    /**
     * 
     */
    @Autowired
    /**
     * 
     */
    private OrderRepository orderRepository;
    /**
     * 
     * @return
     */
    public List<Order> getAll() 
    {
        return orderRepository.getAll();
    }
    /**
     * 
     * @param id
     * @return
     */
    public Optional<Order> getOrder(int id) 
    {
        return orderRepository.getOrder(id);
    }
    /**
     * 
     * @param order
     * @return
     */
    public Order create(Order order){
        if(order.getId()!= null){
            return orderRepository.create(order);
        }else{
            return order;
        }
    }
    public Order update(Order order) 
    {
        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) 
            {
                if (order.getStatus() != null) 
                {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } 
            else 
            {
                return order;
            }
        } 
        else 
        {
            return order;
        }
    }
    /**
     * 
     * @param id
     * @return
     */
    public boolean delete(int id) 
    {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * 
     * @param zona
     * @return
     */
    public List<Order> getZone(String zone){
        return orderRepository.getZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }

}
