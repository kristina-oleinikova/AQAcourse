package helper;

import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {
    public static User getStandartUser() {
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getLockedUser() {
        User user = new User();
        user.setUsername("locked_out_user");
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getProblemUser() {
        User user = new User();
        user.setUsername("problem_user");
        user.setPassword(ReadProperties.password());

        return user;
    }

    public static User getPerformanceGlitchUser() {
        User user = new User();
        user.setUsername("performance_glitch_user");
        user.setPassword(ReadProperties.password());

        return user;
    }
}
