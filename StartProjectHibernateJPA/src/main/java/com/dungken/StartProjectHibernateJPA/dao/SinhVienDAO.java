package com.dungken.StartProjectHibernateJPA.dao;

import com.dungken.StartProjectHibernateJPA.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien getById(int id);
    public List<SinhVien> getAll();
    public List<SinhVien> getByTen(String ten);
}
