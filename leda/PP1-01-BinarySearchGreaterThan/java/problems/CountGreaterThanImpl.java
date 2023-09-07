package problems;

public class CountGreaterThanImpl implements CountGreaterThan{

	public int countGreater(Integer[] array, Integer x){
        return countGreaterWithBinarySearch(array, x, 0, array.length - 1);
    }

    private int countGreaterWithBinarySearch(Integer[] arr, int x, int left, int right) {
        int meio = (right + left) / 2;
        int greaters = 0;

        if (left <= right) {
            if (arr[meio] == x || arr[meio] < x) {
                greaters = countGreaterWithBinarySearch(arr, x, meio + 1, right);
            } else if (arr[meio] > x) {
                greaters = (right - meio + 1) + countGreaterWithBinarySearch(arr, x, left, meio - 1); 
            }
        }
        
        return greaters;
    }
}
