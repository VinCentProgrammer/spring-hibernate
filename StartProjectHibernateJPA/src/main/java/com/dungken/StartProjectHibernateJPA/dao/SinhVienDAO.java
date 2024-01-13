package com.dungken.StartProjectHibernateJPA.dao;

import com.dungken.StartProjectHibernateJPA.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);
    public SinhVien getById(int id);
    public List<SinhVien> getAll();
    public List<SinhVien> getByTen(String ten);
    public void update(SinhVien sinhVien);
    public int updateAllByTen(String ten);
    public void delete(int id);
    public int deleteByTen(String ten);
}
