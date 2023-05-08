package enity;

import java.util.Objects;

public class DichVu {
	private String maDV;
	private String tenDV;
	private float giaDV;

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public float getGiaDV() {
		return giaDV;
	}

	public void setGiaDV(float giaDV) {
		this.giaDV = giaDV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDV, other.maDV);
	}

	public DichVu(String maDV, String tenDV, float giaDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.giaDV = giaDV;
	}

	public DichVu(String tenDV, float giaDV) {
		super();
		this.tenDV = tenDV;
		this.giaDV = giaDV;
	}

	public DichVu() {
		super();
	}

	@Override
	public String toString() {
		return "CT_HD [maDV=" + maDV + ", tenDV=" + tenDV + ", giaDV=" + giaDV + "]";
	}
	 
	
	
}
