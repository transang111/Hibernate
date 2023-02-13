package Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="chitiethoadon")
public class ChiTietHoaDon {
   @EmbeddedId
   ChiTietHoaDonId chiTietHoaDonId;
   int soluong;
   String giatien;
   
   
   
public ChiTietHoaDon() {
	super();
}
public ChiTietHoaDonId getChiTietHoaDonId() {
	return chiTietHoaDonId;
}
public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
	this.chiTietHoaDonId = chiTietHoaDonId;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public String getGiatien() {
	return giatien;
}
public void setGiatien(String giatien) {
	this.giatien = giatien;
}
   
}
