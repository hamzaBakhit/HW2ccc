package com.company;


import java.util.Scanner;

import static com.company.BubbleSort.bubbleSort;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements of the array: ");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // Selection sort
        long startTime = System.nanoTime();
        SelectionSort.selectionSort(arr);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        Info selectionInfo = new Info("selection",timeElapsed);
        System.out.println("Selection sort: " + timeElapsed + "ns");

        // Insertion sort
        startTime = System.nanoTime();
        InsertionSort.insertionSort(arr);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        Info insertionInfo = new Info("insertion",timeElapsed);
        System.out.println("Insertion sort: " + timeElapsed + "ns");

        // Bubble sort
        startTime = System.nanoTime();
        BubbleSort.bubbleSort(arr);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        Info bubbleInfo = new Info("bubble",timeElapsed);
        System.out.println("Bubble sort: " + timeElapsed + "ns");

        // Merge sort
        startTime = System.nanoTime();
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        Info mergeInfo = new Info("merge",timeElapsed);
        System.out.println("Merge sort: " + timeElapsed + "ns");

//         Quick sort
        startTime = System.nanoTime();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        Info quickInfo = new Info("quick",timeElapsed);
        System.out.println("Quick sort: " + timeElapsed + "ns");

        // Heap sort
        startTime = System.nanoTime();
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        Info heapInfo = new Info("heap",timeElapsed);
        System.out.println("Heap sort: " + timeElapsed + "ns");


        Info firstAlgorithm ;
        Info secondAlgorithm ;
        Info thirdAlgorithm ;
        Info forthAlgorithm;
        Info bestAlgorithm;
        if (selectionInfo.time< insertionInfo.time){
            firstAlgorithm =new Info(selectionInfo.algorithmName, selectionInfo.time);
        }else{
            firstAlgorithm = new Info(insertionInfo.algorithmName,insertionInfo.time);
        }

        if (bubbleInfo.time< mergeInfo.time){
            secondAlgorithm = new Info(bubbleInfo.algorithmName, bubbleInfo.time);
        }else{
            secondAlgorithm = new Info(mergeInfo.algorithmName, mergeInfo.time);
        }

        if (quickInfo.time< heapInfo.time){
            thirdAlgorithm =new Info(quickInfo.algorithmName, quickInfo.time);;
        }
        else{
            thirdAlgorithm =new Info(heapInfo.algorithmName,heapInfo.time);;
        }

        if (firstAlgorithm.time< secondAlgorithm.time){
            forthAlgorithm =new Info(firstAlgorithm.algorithmName,firstAlgorithm.time);;
        }
        else{
            forthAlgorithm =new Info(secondAlgorithm.algorithmName,secondAlgorithm.time);;
        }

        if (thirdAlgorithm.time<forthAlgorithm.time){
            bestAlgorithm =new Info(thirdAlgorithm.algorithmName,thirdAlgorithm.time);;
        }
        else{
            bestAlgorithm =new Info(forthAlgorithm.algorithmName,forthAlgorithm.time);;
        }

        System.out.println("The best algorithm is: "+bestAlgorithm.algorithmName+" <==> "+bestAlgorithm.time);

    }

    static class Info{
        String algorithmName;
        long time;

        public Info(String algorithmName, long time) {
            this.algorithmName = algorithmName;
            this.time = time;
        }
    }
}