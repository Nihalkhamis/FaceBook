package com.elsafeir.mbsoft.facebook.UI.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.elsafeir.mbsoft.facebook.Model.PostModel;
import com.elsafeir.mbsoft.facebook.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
//        /** metjod 1 **/
//
//        Intent intent = new Intent(MainActivity.this,PostsAdapter.class);
//        startActivity(intent);
//        finishAffinity();
//
//        /** metjod 2 **/
//        Intent i = new Intent(MainActivity.this,PostsAdapter.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(i);





        RecyclerView recyclerView = findViewById(R.id.Recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setMovieslist(postModels);
            }
        });
    }
//    private void getpermission_Nqme(String  name, int id, Context context){
//        String x = name;
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }



//    private void x(){}
//    public void x(int y){ }
//    public void x(String y){}
}
