package Greedy;

public class Item {
    public double value;
    public double weight;

    public double getRatio() {
        return value / weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getvalue() {
        return value;
    }

    public String toString() {
        return "\n- Đồ vật có trọng lượng: " + weight + ", giá trị : " + value;
    }
}
