package com.tongle.sheldon.task.sort;

public class InsertSort {
    public static void main(String[] args) {

        int [] arr1 = {1,4,6,9,10};
        int [] arr2 ={2,3,5,7};
        int [] arrNew = new int[arr1.length + arr2.length];
        int small = 0;
        int big = 0;
        for (int i=0;i<arrNew.length;i++){
            if(small<arr1.length && big<arr2.length){
                if(arr1[small]<arr2[big]){
                    arrNew[i] = arr1[small];
                    small++;
                }else{
                    arrNew[i] = arr2[big];
                    big++;
                }
            }else  if(small<arr1.length){
                arrNew[i] = arr1[small];
                small++;
            }else if(big<arr2.length){
                arrNew[i] = arr2[big];
                big++;
            }

            for (int i1 = 0; i1 < arrNew.length; i1++) {
                System.out.print(arrNew[i1] +"\t");
            }
            System.out.println("====================");
        }


    }
}
