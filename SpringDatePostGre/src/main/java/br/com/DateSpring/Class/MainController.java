package br.com.DateSpring.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.DateSpring.Class.UserSpring;
import java.util.ArrayList;
import java.util.List;
import static org.hibernate.criterion.Projections.id;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author marcelo
 */

@RestController
@RequestMapping(path = "/home")

public class MainController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(path="/readAll")
    public Iterable<UserSpring> getAllUsers(){
        return userRepository.findAll();
    }
    
    @PostMapping(path="/create")    
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email){
        
        UserSpring user = new UserSpring();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }
    
//  
    @PutMapping(path="/update/{id}")
    public @ResponseBody String updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String email){
        
        UserSpring userSpring = userRepository.findById(id);
        userSpring.setName(name);
        userSpring.setEmail(email);
        userRepository.save(userSpring);
        return "Updated";
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id){
        
        userRepository.deleteById(id);
        return "Deleted";
    }
    
    @GetMapping(path = "/readUser/{id}")
    public @ResponseBody UserSpring getUser(@PathVariable int id){
        
        UserSpring userSpring = new UserSpring();
        
        if(this.getAllUsers().hashCode() == id){
            userSpring.getId();
            userSpring.getName();
            userSpring.getEmail();
        }
        
        return userSpring;
    }
    
}
