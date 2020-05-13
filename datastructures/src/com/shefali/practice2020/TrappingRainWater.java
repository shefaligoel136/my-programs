package com.shefali.practice2020;

public class TrappingRainWater {
    public static void trappingWater(int arr[]) {
        int max = 0, temp = 0, sum = 0, max_index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == 0) {
                if (arr[i] == max)
                    break;
                else
                    continue;
            }
            if (arr[i] != max) {
                temp = Math.max(temp, arr[i]);
                if (temp != arr[i])
                    sum = sum + (temp - arr[i]);
            } else {
                max_index = i;
                break;
            }
        }
        System.out.println(sum);
        if (arr[max_index] == max) {
            temp = 0;
            for (int i = arr.length - 1; i > max_index; i--) {
                if (arr[i] < arr[i - 1] && i == arr.length - 1) {
                    if (arr[i] == max)
                        temp = max;
                    else
                        continue;
                }
                temp = Math.max(temp, arr[i]);
                if (temp != arr[i])
                    sum = sum + (temp - arr[i]);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int arr[] = {2,0,2};
        trappingWater(arr);
    }
}
