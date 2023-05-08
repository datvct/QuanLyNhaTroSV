package enity;

import java.util.Objects;

public class SinhVien {

	private String maSV;
	private String tenSV;
	private boolean gt;
	private String lop;
	private String nganh;
	private String quequan;
	private String sdt;
	private String email;
	public SinhVien(String maSV, String tenSV, boolean gt, String lop, String nganh, String quequan, String sdt,
			String email) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.gt = gt;
		this.lop = lop;
		this.nganh = nganh;
		this.quequan = quequan;
		this.sdt = sdt;
		this.email = email;
	}

	
	public SinhVien(String maSV) {
		this.maSV=maSV;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public boolean getGT() {
		return gt;
	}
	public void setGt(boolean gt) {
		this.gt = gt;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNganh() {
		return nganh;
	}
	public void setNganh(String nganh) {
		this.nganh = nganh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SinhVien(String maSV, String tenSV, String lop, String nganh) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.lop = lop;
		this.nganh = nganh;
	}
	public SinhVien() {
		super();
	}
	
	
	

}