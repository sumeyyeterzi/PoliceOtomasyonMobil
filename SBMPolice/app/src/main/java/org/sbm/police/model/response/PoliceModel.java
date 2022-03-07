package org.sbm.police.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PoliceModel implements Serializable {

    @SerializedName("id")
    @Expose // izin vermek ya da vermemek için kullanılır. karar yapısı gibi de düşünülebilir .
    private Integer id;
    @SerializedName("policeTipi")
    @Expose
    private String policeTipi;
    @SerializedName("policePrim")
    @Expose
    private Integer policePrim;
    @SerializedName("policeDurum")
    @Expose
    private Integer policeDurum;
    @SerializedName("olusturmaTarihi")
    @Expose
    private String olusturmaTarihi;
    @SerializedName("guncellemeTarihi")
    @Expose
    private String guncellemeTarihi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getOlusturmaTarihi() {
        return olusturmaTarihi;
    }

    public void setOlusturmaTarihi(String olusturmaTarihi) {
        this.olusturmaTarihi = olusturmaTarihi;
    }

    public String getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(String guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

}