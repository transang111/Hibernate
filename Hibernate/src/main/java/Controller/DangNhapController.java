package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.NhanVien;
import Service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	@Autowired
	NhanVienService nhanvienservice;
    
	@GetMapping
	public String Defaul() {
		
		return "dangnhap";
	}
	
	@PostMapping
	public  String DangKy(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau,ModelMap map) {
		boolean checkmail=validate(email);
		if(checkmail) {
			if(matkhau.equals(nhaplaimatkhau)) {
				NhanVien nhanVien= new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setTendangnhap(email);
				nhanVien.setMatkhau(matkhau);
				
				boolean ktthem=nhanvienservice.ThemNhanVien(nhanVien);
				if(ktthem) {
					map.addAttribute("kiemtradangnhap", "Tạo Tài Khoản Thành Công!");
				}else {
					map.addAttribute("kiemtradangnhap", "Tạo Tài Khoản Thất Bại!");
				}
			}else {
				map.addAttribute("kiemtradangnhap", "Mật Khẩu Trùng Khớp");
			}
		}else {
			map.addAttribute("kiemtradangnhap", "Vui Lòng nhập đúng định dạng Email!");
		}
		return "dangnhap";
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		    return matcher.find();
		}
	
}
