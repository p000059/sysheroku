package br.com.DateSpring.Class;
import org.springframework.data.repository.CrudRepository;
import br.com.DateSpring.Class.UserSpring;

/**
 *
 * @author marcelo
 */


    /**
     *
     */
    public interface UserRepository extends CrudRepository<UserSpring, Integer>{
        
        public UserSpring findById(int id);
    }

