package org.sbm.police;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email ,sifre;
    private Button kayitbtn;
    private TextView kayitOl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        email =findViewById(R.id.kayitemail);
        sifre=findViewById(R.id.kayitsifre);
        kayitbtn=findViewById(R.id.kayitbtn);
        kayitOl=findViewById(R.id.kayitOl);

        kayitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
        kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void Register() {

        String user=email.getText().toString().trim(); //trim boşlukları kontrol etmek için yine de sorr !
        String pass=sifre.getText().toString().trim();
        if(user.isEmpty()){
            email.setError("Boş geçilemez");
        }
        if(pass.isEmpty()){
            sifre.setError("Boş geçilemez");
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Kayıt Başarısız"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}