package br.com.DateSpring.Class;
import org.springframework.data.repository.CrudRepository;
import br.com.DateSpring.Class.UserSpring;
import org.springframework.data.domain.Sort;


/**
 *
 * @author marcelo
 */


    /**
     *
     */
    public interface UserRepository extends CrudRepository<UserSpring, Integer>{
        
        public UserSpring findById(int id);
        public Iterable<UserSpring> findAll(Sort sort);
    }

