package Question3;

public class CnChinhThuc extends CongNhan{
    final long luongCoBan=650000L;
    private int heSoLuong;
    private int thamNien;

    public CnChinhThuc(String name, String address, String contract, int heSoLuong, int thamNien) {
        super(name, address, contract);
        this.heSoLuong = heSoLuong;
        this.thamNien = thamNien;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        if(heSoLuong>0&&heSoLuong<15){
            this.heSoLuong=heSoLuong;
        }else this.heSoLuong=0;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }

    @Override
    public String toString() {
        return "CnChinhThuc{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contract='" + contract + '\'' +
                '}';
    }

    @Override
    public long tinhLuong() {
        long phuCap;
        if(getThamNien()>=25){
            phuCap=luongCoBan;
        }else phuCap= (long) (luongCoBan*0.8);

        return luongCoBan*getHeSoLuong()+phuCap;
    }
}
