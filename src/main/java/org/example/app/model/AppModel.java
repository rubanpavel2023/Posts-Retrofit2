package org.example.app.model;

import org.example.app.controller.PostsController;
import org.example.app.controller.PostByIdController;
import org.example.app.controller.PostsLimitedController;
import org.example.app.view.PostByIdView;
import org.example.app.view.PostsLimitedView;
import org.example.app.view.PostsView;


public class AppModel {

    public void readPosts() {
        PostModel model = new PostModel();
        PostsView view = new PostsView();
        PostsController controller =
                new PostsController(model, view);
        controller.getPosts();
    }

    public void readPostById() {
        PostModel model = new PostModel();
        PostByIdView view = new PostByIdView();
        PostByIdController controller =
                new PostByIdController(model, view);
        controller.getPostById();
    }

    public void readPostsLimited() {
        PostModel model = new PostModel();
        PostsLimitedView view = new PostsLimitedView();
        PostsLimitedController controller =
                new PostsLimitedController(model, view);
        controller.getPostsLimited();
    }
}



