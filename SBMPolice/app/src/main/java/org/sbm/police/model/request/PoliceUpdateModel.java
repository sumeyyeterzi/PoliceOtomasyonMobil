package org.sbm.police.model.request;

import com.google.gson.annotations.SerializedName;

public class PoliceUpdateModel {


    @SerializedName("policeTipi")
    private String policeTipi;

    @SerializedName("policePrim")
    private Integer policePrim;

    @SerializedName("policeDurum")
    private Integer policeDurum;

    public String getPoliceTipi() {
        return policeTipi;
    }

    public void setPoliceTipi(String policeTipi) {
        this.policeTipi = policeTipi;
    }

    public Integer getPolicePrim() {
        return policePrim;
    }

    public void setPolicePrim(Integer policePrim) {
        this.policePrim = policePrim;
    }

    public Integer getPoliceDurum() {
        return policeDurum;
    }

    public void setPoliceDurum(Integer policeDurum) {
        this.policeDurum = policeDurum;
    }

}