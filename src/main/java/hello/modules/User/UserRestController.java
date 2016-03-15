package hello.modules.User;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gfisher on 3/14/2016.
 */
public class UserRestController {
    private UserService service;

    /*@RequestMapping(value = EndpointConstants.USER_ENDPOINT, method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(value = EndpointConstants.USER_ENDPOINT, method = RequestMethod.POST)
    public User addUser(@RequestBody User user) throws Exception {
        return service.addUser(user);
    }

    @RequestMapping(value = EndpointConstants.USER_ENDPOINT, method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) throws Exception {
        return service.updateUser(user);
    }

    @RequestMapping(value = EndpointConstants.USER_SEARCH_ENDPOINT+"/{lastName}", method = RequestMethod.GET)
    public List<User> searchUsersByLastName(@PathVariable String lastName){
        return service.searchUserByLastName(lastName);
    }*/

    /*@RequestMapping("/users")
    public HttpEntity<User> user(@RequestBody(required = false) User user) {
        user.add(linkTo(methodOn(UserRestController.class).user(user)).withSelfRel());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }*/
}
