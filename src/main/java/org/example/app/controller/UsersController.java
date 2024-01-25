package org.example.app.controller;

import com.google.gson.Gson;
import org.example.app.entity.User;
import org.example.app.entity.UsersResponse;
import org.example.app.model.UserModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UsersView;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersController {

    UserModel model;
    UsersView view;

    public UsersController(UserModel model, UsersView view) {
        this.model = model;
        this.view = view;
    }

    public void getUsers() {
        view.getOutput(readUsers());
        AppStarter.startApp();
    }

    private String readUsers() {
        Optional<Response<UsersResponse>> optional = model.fetchUsers();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            List<User> users = optional.get().body().getData();

            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);

            String str;

            for (User user : users) {
                str = cnt.incrementAndGet() + ") {\"data\":" + user.toString() + ",\"support\":" + Constants.SUPPORT_INFO + "}\n";
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}
