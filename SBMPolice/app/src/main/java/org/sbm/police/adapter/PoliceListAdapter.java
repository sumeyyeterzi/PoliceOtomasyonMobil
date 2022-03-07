package org.sbm.police.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sbm.police.MainActivity;
import org.sbm.police.PoliceListeActivity;
import org.sbm.police.R;
import org.sbm.police.model.response.PoliceModel;

import java.util.List;

public class PoliceListAdapter extends RecyclerView.Adapter<PoliceListAdapter.ViewHolder> {
        private List<PoliceModel> mPoliceList;
        private PoliceListeActivity mActivity;

     public PoliceListAdapter(List<PoliceModel> policeList, PoliceListeActivity policeListeActivity ){
        this.mPoliceList=policeList;
        this.mActivity=policeListeActivity;

    }

    @NonNull //boş bırakılamaz anlamına gelmektedir.
    @Override
    public PoliceListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_police_list, parent, false); //tasarımı burada vermiş olduk.
        return new ViewHolder(view); // toluşan tassarımı view holderle harmanlayıp döndürür
    }

    @Override
    public void onBindViewHolder(@NonNull PoliceListAdapter.ViewHolder holder, int position) { //bind ile atama işlemi gerçekleştrilir
        //o pozisyondaki police modeli aldık.
        PoliceModel policeModel = mPoliceList.get(position); //policemodel değişkenine bütün bilgiyi çektik.
        //referansını tanımladığımız viewlerin özellikerlini değiştirdik.
        holder.policeDurum.setText(" Durum: " + policeModel.getPoliceDurum().toString());
        holder.policePrim.setText(" Prim: " + policeModel.getPolicePrim().toString());
        holder.policeTip.setText(" Tip: " + policeModel.getPoliceTipi());

        holder.btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.DeleteClicked(policeModel.getId()); //id ile silmek için burada sadece id değerini yolladık.


            }

        });
        holder.btnGuncelle.setOnClickListener(new View.OnClickListener() { //bu kısımda ise direkt objeyi yolladık.
            @Override
            public void onClick(View view) {

                mActivity.UpdateClicked(policeModel);
            }


        });

    }

    @Override
    public int getItemCount() { //create ve bind işleminin kaç kere yapılacağını belirler.

        return mPoliceList.size();
    }
//görüntü tutucu yani üretilen tasarımdan değğişiklik olanağı sağlar.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView policeTip;
        TextView policeDurum;
        TextView policePrim;
        Button btnSil;
        Button btnGuncelle;


        ViewHolder(View itemView) {
            super(itemView);
            policeTip = itemView.findViewById(R.id.policeTip);
            policeDurum = itemView.findViewById(R.id.policeDurum);
            policePrim = itemView.findViewById(R.id.policePrim);
            btnSil=itemView.findViewById(R.id.butonSil); //görüntüden yakaladık.
            btnGuncelle=itemView.findViewById(R.id.butonGuncelle);




        }

    }

}
