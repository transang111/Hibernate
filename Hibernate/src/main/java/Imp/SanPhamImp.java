package Imp;

import java.util.List;

import Entity.SanPham;

public interface SanPhamImp {
    List<SanPham> LayDanhSachSanPhamLiMit(int spBatdau);
    SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham);
    List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc);
    boolean XoaSanPhamTheoMaSanPham(int masanpham);
    
}
