package in.mindcraft.auth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public boolean checkUserCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);
        
        // Check if the user exists and if the provided password matches the stored password
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        
        return false;
    }

}
