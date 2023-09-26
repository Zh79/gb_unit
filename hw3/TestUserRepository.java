package hw3;

import org.junit.jupiter.api.Test;
import seminars.third.tdd.User;
import seminars.third.tdd.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUserRepository {
    @Test
    public void testLogoutUser() {
        User first = new User("John", "admin123", true);
        first.authenticate("John", "admin123");
        User second = new User("Anna", "admin", false);
        second.authenticate("Anna", "admin");
        User third = new User("Jane", "123456", false);
        third.authenticate("Jane", "123456");

        UserRepository userRepository = new UserRepository();

        userRepository.addUser(first);
        userRepository.addUser(second);
        userRepository.addUser(third);

        userRepository.logoutUser();

        assertThat(userRepository.getData().get(0)).isEqualTo(first);
    }
}