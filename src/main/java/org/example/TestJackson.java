import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.UserInfoDto;

public class TestJackson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"username\": \"Adarsh1234\", \"password\": \"jha@123456\"}";
        UserInfoDto dto = mapper.readValue(json, UserInfoDto.class);
        System.out.println("Username: " + dto.getUsername());
        System.out.println("Password: " + dto.getPassword());
    }
}
