package Question3;

public class CnCongNhat extends CongNhan {
    private int soNgayCong;
    private long donGia;
    private long thuong;

    public CnCongNhat(String name, String address, String contract, int soNgayCong) {
        super(name, address, contract);
        this.soNgayCong = soNgayCong;

    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        if(donGia<=200000){
            this.donGia=donGia;
        }else this.donGia=0;
    }

    public long getThuong() {
        return thuong;
    }

    public long setThuong() {
        if (soNgayCong > 24) {
            this.thuong = 100000;
        } else this.thuong = 50000;
        return this.thuong;
    }

    @Override
    public long tinhLuong() {
        long luong=this.soNgayCong*this.donGia+setThuong();
        return luong;
    }
}
