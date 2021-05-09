import java.lang.Exception;

public class Matrix  {

    private int[][] matrix;
    private int size;

    public Matrix(int size) throws Exception {
        if(size <= 0) throw new Exception("\nError! The size of the matrix is given by a positive number.");
        this.size = size;
        this.matrix = new int[size][size];
    }

    public void RandomMatrix() {
        for(int i = 0; i < this.size; i++)
            for(int j = 0; j < this.size; j++)
                this.matrix[i][j] = (int)(Math.random() * (2 * size + 1)) - size;
    }

    public void ShowMatrix() {
        System.out.println();
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++)
                System.out.printf("%d \t", matrix[i][j]);
            System.out.println();
        }
    }

    public void RotateTo90() {
        int[][] buffMatrix = new int[this.size][this.size];
        for(int i = 0, k = 0; i < this.size; i++, k++)
            for(int j = 0, l = size - 1; j < this.size; j++, l--)
                buffMatrix[l][k] = this.matrix[i][j];
        this.matrix = buffMatrix;
    }
    /*public void RotateTo180() {
        RotateTo90();
        RotateTo90();
    }
    public void RotateTo270() {
        RotateTo90();
        RotateTo90();
        RotateTo90();
    }*/
}