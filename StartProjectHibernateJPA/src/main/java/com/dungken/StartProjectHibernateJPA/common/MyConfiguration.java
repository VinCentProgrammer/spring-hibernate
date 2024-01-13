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
                    themSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 2) {
                    timSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 3) {
                    timSinhVienTheoTen(sinhVienDAOImpl);
                } else if (luaChon == 4) {
                    layTatCaSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 5) {
                    capNhapSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 6) {
                    capNhapSinhVienTatCaTheoTen(sinhVienDAOImpl);
                } else if (luaChon == 7) {
                    xoaSinhVienTheoId(sinhVienDAOImpl);
                } else if (luaChon == 8) {
                    xoaSinhVienTheoTen(sinhVienDAOImpl);
                }
            }
        };
    }

    private void xoaSinhVienTheoTen(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten can xoa: ");
        String ten = sc.nextLine();

        int rows = sinhVienDAOImpl.deleteByTen(ten);
        if(rows>0) {
            System.out.println("Da xoa tat ca sinh vien co ten " + ten);
        } else {
            System.out.println("Khong co sinh vien nao co ten " + ten + " can xoa!");
        }
    }

    private void xoaSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        int id = sc.nextInt();
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(id);
        SinhVien sinhVienResult = sinhVienDAOImpl.getById(id);
        if(sinhVienResult == null) {
            System.out.println("Khong co sinh vien co ID can xoa");
        } else {
            sinhVienDAOImpl.delete(id);
            System.out.println("Da xoa sinh vien co ID " + id + " thanh cong!");
        }
    }

    private void capNhapSinhVienTatCaTheoTen(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten can cap nhat: ");
        String ten = sc.nextLine();

        int rows = sinhVienDAOImpl.updateAllByTen(ten);
        System.out.println("Co " + rows + " da thay doi!");
    }

    private void capNhapSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id: ");
        int id = sc.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if(sinhVien == null) {
            System.out.println("Khong co sinh vien can cap nhat!");
        } else {
            // Nhap thong tin sinh vien cap nhat
            sc.nextLine();
            System.out.print("Nhap ho dem: ");
            String ho_dem = sc.nextLine();
            System.out.print("Nhap ten: ");
            String ten = sc.nextLine();
            System.out.print("Nhap email: ");
            String email = sc.nextLine();
            sinhVien.setTen(ten);
            sinhVien.setHoDem(ho_dem);
            sinhVien.setEmail(email);
            sinhVienDAOImpl.update(sinhVien);
        }
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
                "5. Cap nhat sinh vien theo ID\n" +
                "6. Cap nhat tat ca sinh vien theo ten\n" +
                "7. Xoa sinh vien theo ID\n" +
                "8. Xoa sinh vien theo Ten\n" +
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
