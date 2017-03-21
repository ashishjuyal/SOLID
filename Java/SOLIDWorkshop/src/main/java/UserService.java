import srp.MailMessage;
import srp.User;

import javax.xml.bind.ValidationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private Connection connection;
    public UserService(Connection connection) {
        this.connection = connection;
    }

    public void register(String email, String password) throws ValidationException {

        if(!email.contains("@")) {
            throw new ValidationException("Email is not valid");
        }
        User user = new User(email, password);
        save(user);
        MailMessage mailMessage = new MailMessage("mysite@nowhere.com", email);
        String subject = "Hello, you are now registered";
        sendEmail(mailMessage, subject);
    }

    public User findByEmail(String email) throws SQLException {
        String sql = "select * from user where email = " + email;
        User user = new User();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
        }
        return user;
    }

    public void save(User user) {
        //this method saves the User in DB
    }

    public void sendEmail(MailMessage mailMessage, String subject) {
        //this method sends the mail
    }
}
