package com.example.hp.s_100;


public class Order {
    private String name;
    private String full_name;
    private String full_name_2;
    private String e_mail;
    private String phone;
    private String marka_model_auto;
    private String type_engine;
    private String capacity_engine;
    private String type_body;
    private String name_service;
    private String type_payment;

    public Order() {
    }

    public Order(String name, String full_name, String full_name_2, String e_mail,
                 String phone, String marka_model_auto, String type_engine,
                 String capacity_engine, String type_body, String name_service, String type_payment) {
        this.name = name;
        this.full_name = full_name;
        this.full_name_2 = full_name_2;
        this.e_mail = e_mail;
        this.phone = phone;
        this.marka_model_auto = marka_model_auto;
        this.type_engine = type_engine;
        this.capacity_engine = capacity_engine;
        this.type_body = type_body;
        this.name_service = name_service;
        this.type_payment = type_payment;
    }

    /* public String getName() {
        return name;
    }

   public String getFull_name() {
        return full_name;
    }

    public String getFull_name_2() {
        return full_name_2;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getMarka_model_auto() {
        return marka_model_auto;
    }

    public String getType_engine() {
        return type_engine;
    }

    public String getCapacity_engine() {
        return capacity_engine;
    }

    public String getType_body() {
        return type_body;
    }

    public String getName_service() {
        return name_service;
    }

    public String getType_payment() {
        return type_payment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setFull_name_2(String full_name_2) {
        this.full_name_2 = full_name_2;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMarka_model_auto(String marka_model_auto) {
        this.marka_model_auto = marka_model_auto;
    }

    public void setType_engine(String type_engine) {
        this.type_engine = type_engine;
    }

    public void setCapacity_engine(String capacity_engine) {
        this.capacity_engine = capacity_engine;
    }

    public void setType_body(String type_body) {
        this.type_body = type_body;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public void setType_payment(String type_payment) {
        this.type_payment = type_payment;
    }*/
}
