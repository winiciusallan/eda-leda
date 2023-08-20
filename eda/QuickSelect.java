class QuickSelect {
    public static void main(String[] args) {
        
    }
    
    private static int quickSelect(int[] v, int k) {
        int pivotIndice = partition(v, 0, v.length - 1);

        if (pivotIndice < k - 1) {
            return partition(v, pivotIndice + 1, v.length - 1);
        }
        else if (pivotIndice > k - 1) {
            return partition(v, 0, pivotIndice - 1);
        } else {
            return pivotIndice;
        }
    }
}
