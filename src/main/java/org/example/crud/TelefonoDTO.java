package org.example.crud;

public class TelefonoDTO {
    private String marca;
    private String modelo;
    private String sisOperativo;
    private double sizePantalla;
    private int memoriaRAM;
    private int almacenamiento;
    private boolean camara;
    private int resolucionCamara;
    private boolean smartphone;
    private String imei;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSisOperativo() {
        return sisOperativo;
    }

    public void setSisOperativo(String sisOperativo) {
        this.sisOperativo = sisOperativo;
    }

    public double getSizePantalla() {
        return sizePantalla;
    }

    public void setSizePantalla(double sizePantalla) {
        this.sizePantalla = sizePantalla;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public boolean isCamara() {
        return camara;
    }

    public void setCamara(boolean camara) {
        this.camara = camara;
    }

    public int getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(int resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public boolean isSmartphone() {
        return smartphone;
    }

    public void setSmartphone(boolean smartphone) {
        this.smartphone = smartphone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
