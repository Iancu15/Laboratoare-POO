package sumabil;

public class MyMatrix extends Sumabil {
    Integer[][] matrix = new Integer[4][4];

    public MyMatrix(Integer[][] matrix) {
        try {
            // asa merge si daca primesc matrice mai mare de [4][4], doar iau ce am nevoie
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    this.matrix[i][j] = matrix[i][j];
                }
            }
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Matricea trb sa aiba min 4 linii si 4 coloane");
        }
    }

    public void calculateSum() {
        Integer sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum += matrix[i][j];
            }
        }

        this.setSum(sum);
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void addValue(Sumabil value) {
        this.setSum(this.getSum() + value.getSum());
    }
}
