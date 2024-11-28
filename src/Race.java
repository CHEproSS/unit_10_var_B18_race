import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Race {
    private List<Car> cars;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public void addCar(int position, int speed) {
        cars.add(new Car(position, speed));
    }

    public int countOvertakes() {
        Collections.sort(cars, Comparator.comparingInt(Car::getPosition));

        int[] speeds = cars.stream().mapToInt(Car::getSpeed).toArray();

        return countInversions(speeds);
    }

    private int countInversions(int[] array) {
        return mergeSortAndCount(array, 0, array.length - 1);
    }

    private int mergeSortAndCount(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int inversions = 0;

        inversions += mergeSortAndCount(array, left, mid);
        inversions += mergeSortAndCount(array, mid + 1, right);

        inversions += mergeAndCount(array, left, mid, right);

        return inversions;
    }

    private int mergeAndCount(int[] array, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        System.arraycopy(array, left, leftArray, 0, mid - left + 1);
        System.arraycopy(array, mid + 1, rightArray, 0, right - mid);

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
                swaps += (leftArray.length - i);
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }

        return swaps;
    }
}