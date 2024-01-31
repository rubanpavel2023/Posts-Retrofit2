package org.example.app.model;

import org.example.app.entity.Post;
import org.example.app.network.ApiClient;
import org.example.app.network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PostModel {

    public Optional<List<Post>> fetchPosts() {

        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<List<Post>> call = service.getPosts();
        Optional<List<Post>> optional;

        try {
            Response<List<Post>> response = call.execute();
            if (((Response<?>) response).isSuccessful()) {
                optional = Optional.ofNullable(response.body());
            } else {
                optional = Optional.empty();
            }
        } catch (IOException ex) {
            optional = Optional.empty();
        }

        return optional;
    }

    public Optional<Post> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getApiService();
        Call<Post> call = service.getPostById(id);
        Optional<Post> optional;

        try {
            Response<Post> response = call.execute();
            if (response.isSuccessful()) {
                optional = Optional.ofNullable(response.body());
            } else {
                optional = Optional.empty();
            }
        } catch (IOException ex) {
            optional = Optional.empty();
        }

        return optional;
    }

}
