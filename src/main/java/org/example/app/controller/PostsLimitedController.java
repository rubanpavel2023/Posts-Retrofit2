package org.example.app.controller;

import okhttp3.Response;
import org.example.app.entity.Post;
import org.example.app.model.PostModel;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.PostsLimitedView;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostsLimitedController {

    PostModel model;
    PostsLimitedView view;

    public PostsLimitedController(PostModel model, PostsLimitedView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostsLimited (){
        view.getOutput(readPostsLimited (Integer.parseInt(view.getData())));
        AppStarter.startApp();
    }
    private String readPostsLimited (int limit) {
        Optional<List<Post>> optional = model.fetchPosts();
        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        }else {
            List <Post>posts = optional.get();
            StringBuilder stringBuilder = getStringBuilder (posts, limit);
            return stringBuilder.toString();
        }
    }

    @NotNull
    private static StringBuilder getStringBuilder (List<Post>posts, int limit) {
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger cnt = new AtomicInteger(0);
        String str;

        for(Post post:posts){
            if (post.getId () <= limit) {
                str = "\n" + cnt.incrementAndGet() + ") POST: userId " + post.getUserId () +
                        ", postId " + post.getId() + ".\nTITLE: " + post.getTitle() +
                        ".\nCONTENT: " + post.getBody() + ".\n";
                stringBuilder.append(str);
            }
        }
        return stringBuilder;
    }
}

