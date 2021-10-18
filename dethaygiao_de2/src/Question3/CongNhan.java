package Question3;

public abstract class CongNhan {
    protected String name;
    protected String address;
    protected String contract;

    public CongNhan(String name, String address, String contract) {
        this.name = name;
        this.address = address;
        this.contract = contract;
    }
    public abstract long tinhLuong();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contract='" + contract + '\'' +
                '}';
    }
}
