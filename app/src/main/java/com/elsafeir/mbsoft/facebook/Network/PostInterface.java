package com.elsafeir.mbsoft.facebook.Network;

import android.view.View;

import com.elsafeir.mbsoft.facebook.Model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {



    @GET("posts")
    Call<List<PostModel>> getPosts();

}
