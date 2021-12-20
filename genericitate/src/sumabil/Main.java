package sumabil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[][] matrix1 = new Integer[4][4];
        Integer[][] matrix2 = new Integer[4][4];
        Integer[][] matrix3 = new Integer[4][4];
        Integer[][] matrix4 = new Integer[4][4];
        Integer[][] matrix5 = new Integer[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1[i][j] = 1;
                matrix2[i][j] = i;
                matrix3[i][j] = j;
                matrix4[i][j] = i + j;
                matrix5[i][j] = i - j;
            }
        }
        
        MyMatrix matrix1Sumabil = new MyMatrix(matrix1);
        MyMatrix matrix2Sumabil = new MyMatrix(matrix2);
        MyMatrix matrix3Sumabil = new MyMatrix(matrix3);
        MyMatrix matrix4Sumabil = new MyMatrix(matrix4);
        MyMatrix matrix5Sumabil = new MyMatrix(matrix5);
        List<MyMatrix> sumabilMatrixList = new ArrayList<>();
        sumabilMatrixList.add(matrix1Sumabil);
        sumabilMatrixList.add(matrix2Sumabil);
        sumabilMatrixList.add(matrix3Sumabil);
        sumabilMatrixList.add(matrix4Sumabil);
        sumabilMatrixList.add(matrix5Sumabil);

        for (MyMatrix matrix : sumabilMatrixList) {
            matrix.calculateSum();
        }
        System.out.println(matrix1Sumabil.calculateSums(sumabilMatrixList));

        MyVector3 vector1Sumabil = new MyVector3(1, 2, 3);
        MyVector3 vector2Sumabil = new MyVector3(1, 1, 1);
        MyVector3 vector3Sumabil = new MyVector3(3, 2, 1);
        MyVector3 vector4Sumabil = new MyVector3(4, 5, 6);
        MyVector3 vector5Sumabil = new MyVector3(0, 0, 0);
        List<MyVector3> sumabilVectorList = new ArrayList<>();
        sumabilVectorList.add(vector1Sumabil);
        sumabilVectorList.add(vector2Sumabil);
        sumabilVectorList.add(vector3Sumabil);
        sumabilVectorList.add(vector4Sumabil);
        sumabilVectorList.add(vector5Sumabil);

        for (MyVector3 vector : sumabilVectorList) {
            vector.calcualteSum();
        }
        System.out.println(vector1Sumabil.calculateSums(sumabilVectorList));
    }
}
