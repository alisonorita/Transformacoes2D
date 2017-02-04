package transformacoes2d.utils;

final public class Matrix {
    private final int M;             // number of rows
    private final int N;             // number of columns
    private final double[][] data;   // M-by-N array

    public double getData(int i, int j) {
        return this.data[i][j];
    }

    // create M-by-N matrix of 0's
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    // create matrix based on 2d array
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }

    // copy constructor
    private Matrix(Matrix A) { this(A.data); }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = Math.random();
        return A;
    }

    // create and return the N-by-N identity matrix
    public static Matrix identity(int N) {
        Matrix I = new Matrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // swap rows i and j
    private void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    // return C = A + B
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // does A = B exactly?
    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
        return true;
    }

    // return C = A * B
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }


    // return x = A^-1 b, assuming A is square and has full rank
    public Matrix solve(Matrix rhs) {
        if (M != N || rhs.M != N || rhs.N != 1)
            throw new RuntimeException("Illegal matrix dimensions.");

        // create copies of the data
        Matrix A = new Matrix(this);
        Matrix b = new Matrix(rhs);

        // Gaussian elimination with partial pivoting
        for (int i = 0; i < N; i++) {

            // find pivot row and swap
            int max = i;
            for (int j = i + 1; j < N; j++)
                if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
                    max = j;
            A.swap(i, max);
            b.swap(i, max);

            // singular
            if (A.data[i][i] == 0.0) throw new RuntimeException("Matrix is singular.");

            // pivot within b
            for (int j = i + 1; j < N; j++)
                b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];

            // pivot within A
            for (int j = i + 1; j < N; j++) {
                double m = A.data[j][i] / A.data[i][i];
                for (int k = i+1; k < N; k++) {
                    A.data[j][k] -= A.data[i][k] * m;
                }
                A.data[j][i] = 0.0;
            }
        }

        // back substitution
        Matrix x = new Matrix(N, 1);
        for (int j = N - 1; j >= 0; j--) {
            double t = 0.0;
            for (int k = j + 1; k < N; k++)
                t += A.data[j][k] * x.data[k][0];
            x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
        }
        return x;
   
    }
    
    public Matrix rotate(Matrix matrixObj, double x, double y) {
        double[][] matrizOperAux = new double[3][3];
        
        matrizOperAux[0][0] = 1;
        matrizOperAux[0][1] = 0;
        matrizOperAux[0][2] = -x;
        matrizOperAux[1][0] = 0;
        matrizOperAux[1][1] = 1;
        matrizOperAux[1][2] = -y;
        matrizOperAux[2][0] = 0;
        matrizOperAux[2][1] = 0;
        matrizOperAux[2][2] = 1;
        Matrix matrizTrans = new Matrix(matrizOperAux);

        Matrix MatrizRes = matrizTrans.times(matrixObj);

        matrizOperAux[0][0] = Math.cos(Math.toRadians(90));
        matrizOperAux[0][1] = -Math.sin(Math.toRadians(90));
        matrizOperAux[0][2] = 0;
        matrizOperAux[1][0] = Math.sin(Math.toRadians(90));
        matrizOperAux[1][1] = Math.cos(Math.toRadians(90));
        matrizOperAux[1][2] = 0;
        matrizOperAux[2][0] = 0;
        matrizOperAux[2][1] = 0;
        matrizOperAux[2][2] = 1;
        Matrix matrizRot = new Matrix(matrizOperAux);

        MatrizRes = matrizRot.times(MatrizRes);

        matrizOperAux[0][0] = 1;
        matrizOperAux[0][1] = 0;
        matrizOperAux[0][2] = x;
        matrizOperAux[1][0] = 0;
        matrizOperAux[1][1] = 1;
        matrizOperAux[1][2] = y;
        matrizOperAux[2][0] = 0;
        matrizOperAux[2][1] = 0;
        matrizOperAux[2][2] = 1;
        matrizTrans = new Matrix(matrizOperAux);

        MatrizRes = matrizTrans.times(MatrizRes);
        
        return MatrizRes;
    }
    
    public Matrix getMatrixTransformacao(int minViewX, int minViewY, 
            int maxViewX, int maxViewY, int minWinX, int minWinY,
            int maxWinX, int maxWinY, Matrix matrizObj) {
        
        double escalaX = ((double) (maxViewX-minViewX)/(double) (maxWinX-minWinX));
        double escalaY = ((double) (maxViewY-minViewY)/(double) (maxWinY-minWinY));
        
        double viewR = ((double) (maxViewX-minViewX)/(double) (maxViewY-minViewY));        
        double winR = ((double)(maxWinX-minWinX)/(double) (maxWinY-minWinY));
        
        double[][] matrizOperAux = new double[3][3];
        
        matrizOperAux[0][0] = escalaX;
        matrizOperAux[0][1] = 0;
        matrizOperAux[0][2] = ((-minWinX*escalaX)+minViewX);
        matrizOperAux[1][0] = 0;
        matrizOperAux[1][1] = escalaY;
        matrizOperAux[1][2] = ((-minWinY*escalaY)+minViewY);
        matrizOperAux[2][0] = 0;
        matrizOperAux[2][1] = 0;
        matrizOperAux[2][2] = 1;
        
        Matrix matrizTrans = new Matrix(matrizOperAux);
        //Matrix matrizResult = matrizTrans.times(matrizObj);
        Matrix matrizResult = matrizObj;
        
        if (winR > viewR) {
            double novoMaxY = ((maxViewX-minViewX)/winR)+minViewY;
            
            matrizOperAux[0][0] = 1;
            matrizOperAux[0][1] = 0;
            matrizOperAux[0][2] = 0;
            matrizOperAux[1][0] = 0;
            matrizOperAux[1][1] = 1;
            matrizOperAux[1][2] = ((maxViewY-novoMaxY)/2);
            matrizOperAux[2][0] = 0;
            matrizOperAux[2][1] = 0;
            matrizOperAux[2][2] = 1;
            
            Matrix matrizTransCentroY = new Matrix( matrizOperAux);
            matrizResult = matrizTransCentroY.times(matrizResult);
            
        } else {
            double novoMaxX = (winR*(maxViewY-minViewY))+minViewX;
            
            matrizOperAux[0][0] = 1;
            matrizOperAux[0][1] = 0;
            matrizOperAux[0][2] = ((maxViewX-novoMaxX)/2);
            matrizOperAux[1][0] = 0;
            matrizOperAux[1][1] = 1;
            matrizOperAux[1][2] = 0;
            matrizOperAux[2][0] = 0;
            matrizOperAux[2][1] = 0;
            matrizOperAux[2][2] = 1;
            
            Matrix matrizTransCentroX = new Matrix(matrizOperAux);
            matrizResult = matrizTransCentroX.times(matrizResult);
        }
        
        return matrizResult;
    }
}
