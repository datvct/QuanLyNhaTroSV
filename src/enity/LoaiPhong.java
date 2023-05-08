package enity;

import java.util.Objects;

public class LoaiPhong {
	private String maPhong;
	private String loaiPhong;
	
	public LoaiPhong(String maPhong, String loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
	}
	
	public LoaiPhong(String loaiPhong) {
		super();
		this.loaiPhong = loaiPhong;
	}

	public String getMaPhong() {
		return maPhong;
	}
	
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	public String getLoaiPhong() {
		return loaiPhong;
	}
	
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
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
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return "LoaiPhong [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + "]";
	}
	
	
}
