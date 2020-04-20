package pl.coderslab.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {


        int[] A = {1, 2};
        solution(A);

    }


//    public static int solution(int[] A) {
//        boolean onlyNegativeValue = true;
//        for (int i = 1; i < A.length + 1; i++) {
//            int finalI = i;
//            boolean missingElement = IntStream.of(A).anyMatch(x -> x == finalI);
//            if (!missingElement) {
//                return finalI;
//            }
//            if (A[i] > 0) {
//                onlyNegativeValue = false;
//            }
//        }
//
//        if (onlyNegativeValue) {
//            return 1;
//        } else {
//            return A.length + 2;
//        }
//    }


    public static int solution(int[] A) {



        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

        list.sort((o1, o2) -> o1-o2);

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
            if (!list.contains(i)){
                return i;
            }
        }

        //
//        if (sorted==null){
//            return 1;
//        } else{
//            for (int i = 0; i <sorted. ; i++) {
//
//            }
//        }
//
//        boolean onlyNegativeValue = true;
//        for (int i = 0; i < A.length ; i++) {
//            int finalI = i+1;
//            boolean missingElement = IntStream.of(A).anyMatch(x -> x == finalI);
//            if (!missingElement) {
//                return finalI;
//            }
//            if (A[i] > 0) {
//                onlyNegativeValue = false;
//            }
//        }
//
//        if (onlyNegativeValue) {
//            return 1;
//        } else {
//            return A.length + 1;
//        }

        return 0;
    }
}
