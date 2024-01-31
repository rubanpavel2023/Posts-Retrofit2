package org.example.app.controller;

import org.example.app.entity.Post;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostsView;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


public class PostsController {
    PostModel model;
    PostsView view;

    public PostsController(PostModel model, PostsView view) {
        this.model = model;
        this.view = view;
    }


    public void getPosts() {
        view.getOutput(readPosts());
        AppStarter.startApp();
    }

    private String readPosts() {
        Optional<List<Post>> optional = model.fetchPosts();

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            List<Post> posts = optional.get();
            StringBuilder stringBuilder = getStringBuilder(posts);
            return stringBuilder.toString();
        }

    }

    @NotNull
    private static StringBuilder getStringBuilder(List<Post> posts) {
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger cnt = new AtomicInteger(0);
        String str;

        for (Post post : posts) {
            str = "\n" + cnt.incrementAndGet() + ") POST: userId " + post.getUserId() +
                    ", postId " + post.getId() + ".\nTITLE: " + post.getTitle() +
                    ".\nCONTENT: " + post.getBody() + ".\n";
            stringBuilder.append(str);
        }
        return stringBuilder;

    }
}




    
