package com.cuatroa.retotres.repository;
/**
 * 
 * 
 */
import com.cuatroa.retotres.model.Order;
import com.cuatroa.retotres.repository.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 *  @author Ernesto Trompa 
 *  G18 MINTIC
 * 
 */
@Repository
public class OrderRepository 
{
    /**
     * 
     */
    @Autowired
    /**
     * 
     */
    private OrderCrudRepository orderCrudRepository;
    /**
     * 
     * @return
     */
    public List<Order> getAll() 
    {
        return (List<Order>) orderCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return
     */
    public Optional<Order> getOrder(int id) 
    {
        return orderCrudRepository.findById(id);
    }
    /**
     * 
     * @param order
     * @return
     */
    public Order create(Order order) 
    {
        return orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order
     */
    public void update(Order order) 
    {
        orderCrudRepository.save(order);
    }
    /**
     * 
     * @param order
     */
        public void delete(Order order){
        orderCrudRepository.delete(order);
    }
    public List<Order> getZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
