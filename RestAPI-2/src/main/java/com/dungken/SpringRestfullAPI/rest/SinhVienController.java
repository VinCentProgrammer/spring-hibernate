package com.dungken.SpringRestfullAPI.rest;

import com.dungken.SpringRestfullAPI.entity.ErrorResponse;
import com.dungken.SpringRestfullAPI.entity.SinhVien;
import com.dungken.SpringRestfullAPI.exception.SinhVienException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController {
    private List<SinhVien> danhsach;

    @PostConstruct
    public void createDanhSach() {
        this.danhsach = new ArrayList<SinhVien>();
        danhsach.add(new SinhVien(1, "Nguyen Van A", "Nam", "IT", 9.8));
        danhsach.add(new SinhVien(2, "Nguyen Thi B", "Nu", "Data", 9));
        danhsach.add(new SinhVien(3, "Nguyen Van C", "Nam", "AI", 7.9));
        danhsach.add(new SinhVien(4, "Nguyen Van D", "Nam", "Blockchain", 10));
        danhsach.add(new SinhVien(5, "Nguyen Thi E", "Nu", "SE", 9.5));
    }

    @GetMapping("/danhsach")
    public List<SinhVien> danhSach() {
        return this.danhsach;
    }

    // Path Variable

    @GetMapping("/{id}")
    public SinhVien getSinhVienId(@PathVariable int id) {
        SinhVien sinhVien = null;
        for (SinhVien sv: danhsach) {
            if(sv.getId() == id) {
                sinhVien = sv;
                break;
            }
        }
        if(sinhVien == null) {
            throw new SinhVienException("Khong tim thay sinh vien co id la: " + id);
        } else {
            return sinhVien;
        }
    }

    @GetMapping("/index/{index}")
    public SinhVien getSinhVienByIndex(@PathVariable int index) {
        SinhVien sinhVien = null;
        try{
            sinhVien = danhsach.get(index);
        }catch (IndexOutOfBoundsException e) {
            throw new SinhVienException("Khong tim thay sinh vien co index la: " + index);
        }
        return sinhVien;
    }


}
