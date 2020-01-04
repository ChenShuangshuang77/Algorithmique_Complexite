public class MatrixGraph {
    int size;//number of the vertexs
    //char[] vertexs;
    int[][] matrix;

    public MatrixGraph(int size){
        this.size = size;//size = 100 in this problem
        matrix = new int[size][size];
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

    public int getDegree(int i){//return the degree of vertex i
        int k = 0;
        for(int j:matrix[i-1]){
            if(j == 1)
                k++;
        }
        return k;
    }

}
