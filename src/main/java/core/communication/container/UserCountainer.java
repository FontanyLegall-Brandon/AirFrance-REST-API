package core.communication.container;

import core.data.User;

import java.util.List;

public class UserCountainer extends Container<User>{
    public UserCountainer() {
    }

    public UserCountainer(User... tabOfT) {
        super(tabOfT);
    }

    public UserCountainer(List<User> multipleElement) {
        super(multipleElement);
    }
}
