package org.sbm.police;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.sbm.police.model.response.PoliceModel;
import org.sbm.police.service.IPoliceService;
import org.sbm.police.service.PoliceService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  private FirebaseAuth mAuth;
  private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth= FirebaseAuth.getInstance();
        btnLogout=findViewById(R.id.btnlogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             logout();
            }
        });

    }
    @Override
 public void onStart(){
        super.onStart();
     FirebaseUser currentUser=mAuth.getCurrentUser();
     if(currentUser== null){
         startActivity(new Intent(MainActivity.this,LoginActivity.class));
     }
 }
    public void logout() {

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this,LoginActivity.class)) ;
    }


}