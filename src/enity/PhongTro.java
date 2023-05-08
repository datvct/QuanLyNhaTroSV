package enity;

import java.util.Objects;

public class PhongTro {
	private String maPhong;
	private String tenPhong;
	private LoaiPhong loaiPhong;
	private double giaThue;
	private String dienTich;
	private String tinhTrang;
	private NhaTro nt;
	
	public PhongTro(String maPhong, String tenPhong, LoaiPhong loaiPhong, double giaThue, String dienTich,
			String tinhTrang, NhaTro mTro) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.giaThue = giaThue;
		this.dienTich = dienTich;
		this.tinhTrang = tinhTrang;
		this.nt = mTro;
	}
	
	
	
	public PhongTro(String maPhong,double giaThue ,String tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.giaThue= giaThue;
		this.tinhTrang = tinhTrang;
	}


	
	public PhongTro() {
		super();
	}


	public PhongTro(String maPhong, String tenPhong, double giaThue ,String tinhTrang) {
		this.maPhong= maPhong;
		this.tenPhong = tenPhong;
		this.giaThue = giaThue;
		this.tinhTrang = tinhTrang;
	}
	public PhongTro(String maPhong, double giaThue) {
		this.maPhong= maPhong;
		this.giaThue = giaThue;
	}
	
	public PhongTro(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}

	public String getDienTich() {
		return dienTich;
	}

	public void setDienTich(String dienTich) {
		this.dienTich = dienTich;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public NhaTro getMTro() {
		return nt;
	}

	public void setMTro(NhaTro mTro) {
		this.nt = mTro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongTro other = (PhongTro) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return "PhongTro [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong + ", giaThue="
				+ giaThue + ", dienTich=" + dienTich + ", tinhTrang=" + tinhTrang + ", mTro=" + nt + "]";
	}

	public PhongTro(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
	}

	
	
	
	
	
}
