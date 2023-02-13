package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int machitietsanpham;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="masanpham")
    SanPham sanpham;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="masize")
    sizesanpham sizesanpham;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mamau")
	MauSanPham mausanpham;
	
	int soluong;
	String ngaynhap;
	
	
	
	public ChiTietSanPham() {
		super();
	}
	public int getMachitietsanpham() {
		return machitietsanpham;
	}
	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public sizesanpham getSizesanpham() {
		return sizesanpham;
	}
	public void setSizesanpham(sizesanpham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public MauSanPham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
}
