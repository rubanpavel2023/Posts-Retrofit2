package org.example.app.controller;

import org.example.app.entity.Post;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostByIdView;


import java.util.List;
import java.util.Optional;

public class PostByIdController {

    PostModel model;
    PostByIdView view;

    public PostByIdController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostById() {
        view.getOutput(readPostById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readPostById(int id) {
        Optional<Post> optional = model.fetchPostById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Post post = optional.get();
            return "\nPost: PostId " + post.getId() + ", postId " + post.getId() + "." +
                    "\nTITLE: " + post.getTitle() + ". \nCONTENT: " + post.getBody() + ".";
        }
    }

}
