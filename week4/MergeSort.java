package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <E extends Comparable<E>> void mergesort(List<E> list) {
    	if (list.size() < 2) {
    		return;
    	}
    	
    	int mid = list.size() / 2;
    	List<E> right = new ArrayList<E>(list.subList(0, mid));
    	List<E> left = new ArrayList<E>(list.subList(mid, list.size()));
    	
    	mergesort(left);
    	mergesort(right);
    	merge(left, right, list);
    	
    }
    
    public static <E extends Comparable<E>> void merge(List<E> left, List<E> right, List<E> list) {
    	int leftIndex = 0;
    	int rightIndex = 0;
    	int listIndex = 0;
    	
        while (leftIndex < left.size() && rightIndex < right.size()) {
        	if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
            	list.set(listIndex++, left.get(leftIndex++));
            } else {
            	list.set(listIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            list.set(listIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            list.set(listIndex++, right.get(rightIndex++));
        }
    	
    }
}
