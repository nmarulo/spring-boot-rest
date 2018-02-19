package red.softn.springboot.softnspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import red.softn.springboot.softnspringboot.db.entities.User;
import red.softn.springboot.softnspringboot.exceptions.UserNotExistsException;
import red.softn.springboot.softnspringboot.repositoies.UserRepository;

import java.util.Objects;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @PostMapping
    @ResponseBody
    public String saveUser(@RequestBody User user) {
        if (Objects.isNull(user.getId())) {
            this.userRepository.save(user);
            
            return "Guardado";
        }
        
        throw new UserNotExistsException("No se puede crear el usuario");
    }
    
    @PutMapping
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        if (!userExists(user.getId())) {
            throw new UserNotExistsException("El usuario no existe");
        }
        
        this.userRepository.save(user);
        
        return "Actualizado";
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id) {
        if (userExists(id)) {
            this.userRepository.delete(id);
            
            return "Borrado";
        }
        
        throw new UserNotExistsException("El usuario no existe");
    }
    
    private boolean userExists(Integer id) {
        return Objects.nonNull(this.userRepository.findOne(id));
    }
}
