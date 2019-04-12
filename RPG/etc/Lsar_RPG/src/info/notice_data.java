package info;

public class notice_data {
	public notice_data(notice nt_data, notice_content nc_data) {
		super();
		this.nt_data = nt_data;
		this.nc_data = nc_data;
	}
	private notice nt_data;
	private notice_content nc_data;
	public notice getNt_data() {
		return nt_data;
	}
	public void setNt_data(notice nt_data) {
		this.nt_data = nt_data;
	}
	public notice_content getNc_data() {
		return nc_data;
	}
	public void setNc_data(notice_content nc_data) {
		this.nc_data = nc_data;
	}
}
