/**
 * 
 */
package com.cuatroa.retotres.service;
/**
 * 
 * 
 */
import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
/**
 *
 *  @author Ernesto Trompa 
 *  G18 MINTIC
 * 
 */
@Service
/**
 * 
 */
public class UserService {
    /**
     * 
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * 
     * @return
     */
    public List<User> getAll() 
    {
        return userRepository.getAll();
    }
    /**
     * 
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) 
    {
        
        return userRepository.getUser(id);
    }
    /**
     * 
     * @param user
     * @return
     */
    public User create(User user) 
    {
        /**
         * 
         */
        Optional<User> userIdMaximo = userRepository.lastUserId();
            if (user.getId() == null) 
            {
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
            }
        /**
         * 
         */
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false)
            {
                return userRepository.create(user);
            }
            else
            {
                return user;
            }
        }
        else
        {
            return user;
        }
        
    }

    /**
     * 
     * @param user
     * @return
     */
    public User update(User user) 
    {
        if (user.getId() != null) 
        {
            /**
             * 
             */
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) 
            {
                if (user.getIdentification() != null) 
                {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) 
                {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) 
                {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) 
                {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) 
                {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null)
                {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) 
                {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepository.update(userDb.get());
                return userDb.get();
            } 
            else 
            {
                return user;
            }
        } 
        else 
        {
            return user;
        }

    }
    /**
     * 
     * @param userId
     * @return
     */
    public boolean delete(int userId) 
    {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * 
     * @param email
     * @return
     */
    public boolean emailExists(String email) 
    {
        return userRepository.emailExists(email);
    }
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(String email, String password) 
    {
        /**
         * 
         */
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) 
        {
            return new User();
        } 
        else 
        {
            return usuario.get();
        }
    }
    /**
     * 
     * @return
     
    public List<ZoneId> getZone() {
        return null;
    }
    */
    public List<User>getByMonthBirthDay(String monthBirthDay){
        return userRepository.getByMonthBirthtDay(monthBirthDay);
    }
}
