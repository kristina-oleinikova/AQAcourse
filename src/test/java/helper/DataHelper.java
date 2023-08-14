package helper;

import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {
    public static User getAdminUser() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getStandartUser() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }
}
