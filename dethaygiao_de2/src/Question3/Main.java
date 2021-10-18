package Question3;

public class Main {
    public static void main(String[] args) {
        CnChinhThuc cnChinhThuc=new CnChinhThuc("A","asd","Chinh thuc",3,5);
        System.out.println(cnChinhThuc.tinhLuong());
        CnCongNhat cnCongNhat=new CnCongNhat("B","saf","sdf",30);
        cnCongNhat.setDonGia(150000);
        System.out.println(cnCongNhat.tinhLuong());
        System.out.println(cnChinhThuc);
        System.out.println(cnCongNhat);
    }
}
