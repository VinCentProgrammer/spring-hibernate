package com.dungken.SpringRestfullAPI.entity;

// POJO
public class SinhVien {
    private int id;
    private String hoTen;
    private String gioiTinh;
    private String nganhHoc;
    private double diemTB;

    public SinhVien() {
    }

    public SinhVien(int id, String hoTen, String gioiTinh, String nganhHoc, double diemTB) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.nganhHoc = nganhHoc;
        this.diemTB = diemTB;
    }

    // Jackson

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
}
