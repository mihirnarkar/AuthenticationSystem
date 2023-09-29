package in.mindcraft.auth2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        // Use jdbcTemplate to execute the SQL query
        // You should also use password hashing for security
        // For this example, I'm using plaintext passwords for simplicity
        
        List<Map<String,Object>> result = jdbcTemplate.queryForList(sql, user.getUsername(), user.getPassword());

        if (!result.isEmpty()) {
            return "Login successful";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
}
