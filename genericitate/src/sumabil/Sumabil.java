package sumabil;

import java.util.List;

public abstract class Sumabil {
    private Integer sum = 0;

    public abstract void addValue(Sumabil value);

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer calculateSums(List<? extends Sumabil> sumabilList) {
        Integer sum = 0;
        for (Sumabil sumabilElem : sumabilList) {
            sum += sumabilElem.getSum();
        }

        return sum;
    }
}