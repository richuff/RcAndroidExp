package Entity;

public class BillInfo {
    private int id;
    private String date;
    private int type;
    private double amount;
    private String remark;

    public final static int INCOME = 0;
    public final static int COST = 1;
    @Override
    public String toString() {
        return "BillInfo{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", remark='" + remark + '\'' +
                '}';
    }

    public BillInfo(int id, String date, int type, double amount, String remark) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.remark = remark;
    }

    public BillInfo() {
    }

    public BillInfo setId(int id) {
        this.id = id;
        return this;
    }

    public BillInfo setDate(String date) {
        this.date = date;
        return this;
    }

    public BillInfo setType(int type) {
        this.type = type;
        return this;
    }

    public BillInfo setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public BillInfo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getRemark() {
        return remark;
    }
}
