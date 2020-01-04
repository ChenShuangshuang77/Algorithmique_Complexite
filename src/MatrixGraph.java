public class MatrixGraph {
    int size;//number of the vertexs
    //char[] vertexs;
    int[][] matrix;

    public MatrixGraph(int size){
        this.size = size;//size = 100 in this problem
        matrix = new int[size][size];//设定图关系矩阵大小
        //this.vertexs=vertexs;

        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                matrix[i][j] = 0;
            }
        }//initialize all the value in the matrix as 0

    }

    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public void setEdge(int i,int j){//i,j are the sequence number of the vertex
        matrix[i-1][j-1] = 1;
        matrix[j-1][i-1] = 1;//the related position should -1
    }

    public boolean existEdge(int i,int j){
        if (matrix[i-1][j-1] == 1)
            return true;
        return false;
    }

}
