/**
 * 
 */
package com.cuatroa.retotres.repository.crud;
/**
 * 
 */
import com.cuatroa.retotres.model.Chocolate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 *  @author Ernesto Trompa 
 *  G18 MINTIC
 * 
 */
public interface ChocolateCrudRepository extends MongoRepository<Chocolate, String> 
{
    public List<Chocolate>findByPrice(double price);

    public List<Chocolate>findByDescriptionContainingIgnoreCase(String description);

}
