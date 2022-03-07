package org.sbm.police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.sbm.police.model.request.PoliceAddModel;
import org.sbm.police.model.request.PoliceUpdateModel;
import org.sbm.police.model.response.PoliceModel;
import org.sbm.police.service.IPoliceService;
import org.sbm.police.service.PoliceService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PoliceEkleme extends AppCompatActivity {

    EditText policeTip;
    EditText policeDurum;
    EditText policePrim;
    Button   btnEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_ekle);


        policeTip=findViewById(R.id.policeTipUpdate);
        policeDurum=findViewById(R.id.policeDurumUpdate);
        policePrim=findViewById(R.id.policePrimUpdate);
        btnEkle=findViewById(R.id.butonEkle);



       btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                PoliceAddModel policeAddModel=new PoliceAddModel();
        policeAddModel.setPoliceTipi(policeTip.getText().toString());
                policeAddModel.setPoliceDurum(Integer.parseInt(policeDurum.getText().toString()));
                policeAddModel.setPolicePrim(Integer.parseInt(policePrim.getText().toString()));
                IPoliceService policeService = PoliceService.getClient().create(IPoliceService.class);
                Call<Boolean> call=policeService.addPolice(policeAddModel);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful()) {
                            boolean result = response.body();
                            if (result == true) {
                                Intent intent = new Intent(getApplicationContext(), PoliceListeActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(PoliceEkleme.this, "Ekleme  işlemi başarısız", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
    }
}
