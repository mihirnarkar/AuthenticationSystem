package in.mindcraft.auth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (userService.checkUserCredentials(user.getUsername(), user.getPassword())) {
            return "Login successful";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
}

