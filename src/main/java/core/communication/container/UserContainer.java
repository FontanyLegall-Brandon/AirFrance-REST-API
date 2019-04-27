package core.communication.container;

import core.data.User;

import java.util.List;

/**
 * Container specific for users
 */
public class UserContainer extends Container<User>{
    public UserContainer() {
    }

    public UserContainer(User... tabOfT) {
        super(tabOfT);
    }

    public UserContainer(List<User> multipleElement) {
        super(multipleElement);
    }
}
