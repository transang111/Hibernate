package Imp;

import Entity.NhanVien;

public interface NhanVienImp {
    boolean KiemTraDangNhap(String email,String matkhau);
    boolean ThemNhanVien(NhanVien nhanvien);
}
