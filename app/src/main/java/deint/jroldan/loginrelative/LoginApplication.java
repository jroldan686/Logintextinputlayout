package deint.jroldan.loginrelative;

import android.app.Application;

import deint.jroldan.loginrelative.modelo.User;

/**
 * Created by usuario on 6/10/16.
 */

/**
 * Class which stores a User in the Application class
 */

public class LoginApplication extends Application {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
