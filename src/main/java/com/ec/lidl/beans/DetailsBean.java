package com.ec.lidl.beans;

import java.util.Date;
import java.util.List;

public class DetailsBean {

    private EntityBean buyer;
    private EntityBean supplier;
    private List<LineBean> lines;
    private String invoice_number;
    private String invoice_series;
    private Date invoice_date;
    private String invoice_total_amount;
    private String observations;

    public DetailsBean(EntityBean supplier, EntityBean buyer, List<LineBean> lines, String number, String series, Date date, String invoice_total_amount, String observations) {
        this.supplier = supplier;
        this.buyer = buyer;
        this.lines = lines;
        this.invoice_number = number;
        this.invoice_series = series;
        this.invoice_date = date;
        this.invoice_total_amount = invoice_total_amount;
        this.observations = observations;
    }

    public DetailsBean() {
    }

    public EntityBean getSupplier() {
        return supplier;
    }

    public void setSupplier(EntityBean supplier) {
        this.supplier = supplier;
    }

    public EntityBean getBuyer() {
        return buyer;
    }

    public void setBuyer(EntityBean buyer) {
        this.buyer = buyer;
    }

    public List<LineBean> getLines() {
        return lines;
    }

    public void setLines(List<LineBean> lines) {
        this.lines = lines;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getInvoice_series() {
        return invoice_series;
    }

    public void setInvoice_series(String invoice_series) {
        this.invoice_series = invoice_series;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getInvoice_total_amount() {
        return invoice_total_amount;
    }

    public void setInvoice_total_amount(String invoice_total_amount) {
        this.invoice_total_amount = invoice_total_amount;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
