package sumabil;

public class MyVector3 extends Sumabil {
    private Integer x;
    private Integer y;
    private Integer z;

    public MyVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MyVector3() {
    }

    public void calcualteSum() {
        this.setSum(x + y + z);
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public void addValue(Sumabil value) {
        this.setSum(this.getSum() + value.getSum());
    }
}
