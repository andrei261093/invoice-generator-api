package com.ec.lidl.beans;

public class EntityBean {

    private String name;
    private String address;
    private String cif;
    private String account;
    private String bank;
    private String regCom;

    public EntityBean(String name, String address, String cif, String account, String bank, String regCom) {
        this.name = name;
        this.address = address;
        this.cif = cif;
        this.account = account;
        this.bank = bank;
        this.regCom = regCom;
    }

    public EntityBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getRegCom() {
        return regCom;
    }

    public void setRegCom(String regCom) {
        this.regCom = regCom;
    }
}
