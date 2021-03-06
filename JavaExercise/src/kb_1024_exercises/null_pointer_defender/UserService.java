package kb_1024_exercises.null_pointer_defender;

import kb_1024_exercises.null_pointer_defender.my_exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author n2god on 17/11/2019
 * @project PrivateProjects
 */
public class UserService {

    private List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public User getuserByLoginReturnsNull (String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Users with login: " + login + " not found.");
    }

    public User getUserByLoginReturnsDefaultObject (String login) {
        for(User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return User.DEFAULT_USER;
    }

    public Optional<User> getUserByLoginReturnsOptional(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return Optional.of(user);   //zwraca obiekt
            }
        }
        return Optional.empty();
    }

    public Optional<User> getUserByLoginReturnsOptionalUsingStreams(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }


}
