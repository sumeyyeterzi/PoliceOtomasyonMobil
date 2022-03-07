package org.sbm.police;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.sbm.police.model.request.PoliceUpdateModel;
import org.sbm.police.model.response.PoliceModel;
import org.sbm.police.service.IPoliceService;
import org.sbm.police.service.PoliceService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PoliceGuncelleme extends AppCompatActivity {
 PoliceModel updateModel ;
    EditText policeTip;
    EditText policeDurum;
    EditText policePrim;
    Button   btnGuncelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_guncelle); //ekranın çizdirilme anını başlatan metoddur.

      updateModel =(PoliceModel) getIntent().getSerializableExtra("Model"); //cast işlemi yapıldı.
           policeTip=findViewById(R.id.policeTipUpdate);
           policeDurum=findViewById(R.id.policeDurumUpdate);
           policePrim=findViewById(R.id.policePrimUpdate);
           btnGuncelle=findViewById(R.id.butonGuncelle);


           policeTip.setText(updateModel.getPoliceTipi());
           policePrim.setText(updateModel.getPolicePrim().toString());
           policeDurum.setText(updateModel.getPoliceDurum().toString());
           btnGuncelle.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   PoliceUpdateModel policeUpdateModel=new PoliceUpdateModel();
                   policeUpdateModel.setPoliceTipi(policeTip.getText().toString());
                   policeUpdateModel.setPoliceDurum(Integer.parseInt(policeDurum.getText().toString()));
                   policeUpdateModel.setPolicePrim(Integer.parseInt(policePrim.getText().toString()));
                   IPoliceService policeService = PoliceService.getClient().create(IPoliceService.class);
                   Call<Boolean> call=policeService.updatePolice(updateModel.getId(),policeUpdateModel);
                   call.enqueue(new Callback<Boolean>() {
                       @Override
                       public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                           if(response.isSuccessful()) {
                               boolean result = response.body();
                               if (result == true) {
                                   Intent intent = new Intent(getApplicationContext(), PoliceListeActivity.class);
                                   startActivity(intent);

                               } else {
                                   Toast.makeText(PoliceGuncelleme.this, "Ekleme  işlemi başarısız", Toast.LENGTH_SHORT).show();
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
