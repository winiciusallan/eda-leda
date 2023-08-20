class BinarySearchResursive {
    public static void main(String[] args) {
        
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(binarySearch(arr, 11, 0, arr.length - 1));
    }

    public static int binarySearch(int[] v, int n, int left, int right) {
        
        if (left > right) {
            return -1;
        }
        
        int meio = (right + left) / 2;

        if (v[meio] == n) {
            return meio;
        }
        else if (v[meio] < n) {
            return binarySearch(v, n, meio + 1, right);
        }
        else {
            return binarySearch(v, n, left, meio - 1);
        }
    }
    
}
