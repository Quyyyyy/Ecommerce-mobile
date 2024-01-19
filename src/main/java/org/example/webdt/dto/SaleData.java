package org.example.webdt.dto;


import java.util.Date;


public class SaleData {
    private int month;
    private Date sales;

    public SaleData() {
    }

    public SaleData(int month, Date sales) {
        this.month = month;
        this.sales = sales;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getSales() {
        return sales;
    }

    public void setSales(Date sales) {
        this.sales = sales;
    }
}
