public class MatrixGraph {
    int size;//number of the vertexs
    //char[] vertexs;
    int[][] matrix;
    int degreMax;
    int numberEdge;

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

    public void setEdge(int i,int j,int value){
        //i,j are the sequence number of the vertex
        matrix[i-1][j-1] = value;
        matrix[j-1][i-1] = value;//the related position should -1
    }

    public boolean existEdge(int i,int j){
        if (matrix[i-1][j-1] == 1)
            return true;
        return false;
    }

    //return the degree of vertex i
    public int getDegree(int i){
        int k = 0;
        for(int j:matrix[i-1]){
            if(j == 1)
                k++;
        }
        return k;
    }

    public int calculateDegreeMax(){
        for(int i = 0;i < size;i++){
            if(getDegree(i+1)>degreMax)
                degreMax = getDegree(i+1);
        }
        return degreMax;
    }

    public int calculateNumberEdge(){
        for(int i = 0;i < size;i++){
                for(int j = i+1;j < size;j++)
                    if(matrix[i][j] == 1)
                        numberEdge++;
        }
        return numberEdge;
    }

}
