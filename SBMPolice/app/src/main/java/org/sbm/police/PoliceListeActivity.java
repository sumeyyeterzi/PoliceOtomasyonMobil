package org.sbm.police;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import org.sbm.police.adapter.PoliceListAdapter;
import org.sbm.police.model.response.PoliceModel;
import org.sbm.police.service.IPoliceService;
import org.sbm.police.service.PoliceService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PoliceListeActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_liste);
        getPoliceler();
FloatingActionButton btn;
btn =findViewById(R.id.butonEkle);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AddClicked();
    }
});
    }
   public void getPoliceler(){
       IPoliceService policeService = PoliceService.getClient().create(IPoliceService.class);
       Call<List<PoliceModel>> call=policeService.getPoliceler();
       call.enqueue(new Callback<List<PoliceModel>>() {
                        @Override
                        public void onResponse(Call<List<PoliceModel>> call, Response<List<PoliceModel>> response) {
                            System.out.println(response.code());
                            if(response.isSuccessful()){
                                List<PoliceModel> policeListesi= response.body();

                                RecyclerView recyclerView = findViewById(R.id.policeRecyclerView);
                                recyclerView.setLayoutManager(new LinearLayoutManager(PoliceListeActivity.this));
                                PoliceListAdapter adapter = new PoliceListAdapter(policeListesi,PoliceListeActivity.this);
                                recyclerView.setAdapter(adapter);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<PoliceModel>> call, Throwable t) {
                            System.out.println(t.getMessage());
                        }
                    }
       );




   }
  public void UpdateClicked(PoliceModel model){

  Intent intent= new Intent(getApplicationContext(),PoliceGuncelleme.class);
      //To pass:
      intent.putExtra("Model", model);
      startActivity(intent);


  }

  public void AddClicked(){
       Intent intent= new Intent(getApplicationContext(),PoliceEkleme.class);

       startActivity(intent);


    }
    public void DeleteClicked(Integer id) {
        IPoliceService policeService = PoliceService.getClient().create(IPoliceService.class);
        Call<Boolean> call = policeService.deletePolice(id);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    boolean result = response.body();
                    if (result == true) {
                       getPoliceler();

                    } else {
                        Toast.makeText(PoliceListeActivity.this, "Silme  işlemi başarısız", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }



        });

    }
    }
