package com.elsafeir.mbsoft.facebook.Network;

import com.elsafeir.mbsoft.facebook.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {

    private static final String BaseURL = "https://jsonplaceholder.typicode.com/";

    private PostInterface postInterface;

    private static PostsClient INSTANCE;

    public PostsClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {

        if(null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }


    public Call<List<PostModel>> getPosts(){

     return postInterface.getPosts();
    }
}
