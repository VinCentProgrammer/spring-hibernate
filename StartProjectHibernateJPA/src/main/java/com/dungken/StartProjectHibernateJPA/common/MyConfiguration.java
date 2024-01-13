package com.dungken.StartProjectHibernateJPA.common;

import com.dungken.StartProjectHibernateJPA.dao.SinhVienDAO;
import com.dungken.StartProjectHibernateJPA.dao.SinhVienDAOImpl;
import com.dungken.StartProjectHibernateJPA.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                inMenu();
                int luaChon = sc.nextInt();
                sc.nextLine();
                if (luaChon == 1) {
                    // Goi phuong thuc them sinh vien
                    themSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 2) {
                    // Goi phuong thuc lay sinh vien
                    timSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 3) {
                    // Goi phuong thuc tim sinh vien theo ten
                    timSinhVienTheoTen(sinhVienDAOImpl);
                } else if (luaChon == 4) {
                    // Goi phuong thuc lay tat ca sinh vien
                    layTatCaSinhVien(sinhVienDAOImpl);
                }
            }
        };
    }

    private void layTatCaSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        List<SinhVien> sinhViens = sinhVienDAOImpl.getAll();
        if (!sinhViens.isEmpty()) {
            sinhViens.forEach(
                    System.out::println
            );
        } else {
            System.out.println("Khong co sinh vien trong he thong!");
        }
    }

    private void timSinhVienTheoTen(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        List<SinhVien> sinhViens = sinhVienDAOImpl.getByTen(ten);
        if (!sinhViens.isEmpty()) {
            sinhViens.forEach(
                    System.out::println
            );
        } else {
            System.out.println("Khong co sinh vien co ten tren!");
        }
    }

    public void inMenu() {
        System.out.println("MENU:\n" +
                "1. Them sinh vien\n" +
                "2. Tim sinh vien\n" +
                "3. Tim sinh vien theo ten\n" +
                "4. Hien thi tat ca sinh vien\n" +
                "Nhap lua chon: "
        );
    }

    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin sinh vien: \n");
        System.out.print("Nhap ho dem: ");
        String ho_dem = sc.nextLine();
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap email: ");
        String email = sc.nextLine();

        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        sinhVienDAOImpl.save(sinhVien);
    }

    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        int id = sc.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Khong tim thay!");
        } else {
            System.out.println(sinhVien);
        }
    }
}
