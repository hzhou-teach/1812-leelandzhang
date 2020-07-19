package Week5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class convention2_silver 
{//My usual Arrays.sort doesn't work for 2d arrays so I just 
//searched a sorting algorithm that guarantees O(nlogn)
	public static void mergeSort(long[][] array, int low, int high) 
	{
	    if (high <= low) return;
	    int mid = (low+high)/2;
	    mergeSort(array, low, mid);
	    mergeSort(array, mid+1, high);
	    merge(array, low, mid, high);
	}
	public static void merge(long[][] array, int low, int mid, int high)
	{
	    long leftArray[][] = new long[mid - low + 1][3];
	    long rightArray[][] = new long[high - mid][3];
	    for (int i = 0; i < leftArray.length; i++)
	    {
	        leftArray[i][0] = array[low + i][0];
	        leftArray[i][1] = array[low + i][1];
	        leftArray[i][2] = array[low + i][2];
	    }
	    for (int i = 0; i < rightArray.length; i++)
	    {
	        rightArray[i][0] = array[mid + i + 1][0];
	        rightArray[i][1] = array[mid + i + 1][1];
	        rightArray[i][2] = array[mid + i + 1][2];
	    }
	    int leftIndex = 0;
	    int rightIndex = 0;
	    for (int i = low; i < high + 1; i++) 
	    {
	        if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
	            if (leftArray[leftIndex][0] < rightArray[rightIndex][0]) 
	            {
	               array[i][0] = leftArray[leftIndex][0];
	               array[i][1] = leftArray[leftIndex][1];
	               array[i][2] = leftArray[leftIndex][2];
	               leftIndex++;
	            } 
	            else 
	            {
	                array[i][0] = rightArray[rightIndex][0];
	                array[i][1] = rightArray[rightIndex][1];
	                array[i][2] = rightArray[rightIndex][2];
	                rightIndex++;
	            }
	        } else if (leftIndex < leftArray.length) 
	        {
	            array[i][0] = leftArray[leftIndex][0];
	            array[i][1] = leftArray[leftIndex][1];
	            array[i][2] = leftArray[leftIndex][2];
	            leftIndex++;
	        } else if (rightIndex < rightArray.length) 
	        {
	            array[i][0] = rightArray[rightIndex][0];
	            array[i][1] = rightArray[rightIndex][1];
	            array[i][2] = rightArray[rightIndex][2];
	            rightIndex++;
	        }
	    }
	}
	public static void main(String args[]) throws IOException
	{
		//Scanner sc = new Scanner(new File("convention2.in"));
		//PrintWriter pr=new PrintWriter(new FileWriter("convention2.out"));
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[][] times=new long[n][3];
		long[] temp=new long[n];
		for(int i=0; i<n; i++)
		{
			long x=sc.nextLong();
			times[i][0]=x;
			temp[i]=x;
			times[i][1]=sc.nextLong();
			times[i][2]=n-i;//seniority
		}
		sc.close();
		mergeSort(times,0,n-1);
		long[] wait=new long[n];
		int count=0;
		long senior=0;
		int seniorp=0;
		long time=0;
		long max=0;
		int pos=0;
		for(int i=0; i<n; i++)
		{
			if(i!=n-1&&times[i][0]==times[i+1][0]&&time<times[i][0])
			{
				pos=i+1;
				count++;
				if(senior<times[i][2])
				{
					senior=times[i][2];
					seniorp=i;
				}
			}
			else
			{
				if(count>0)
				{
					times[seniorp][0]=times[n-1][0]+1;
					for(int j=pos; j>=pos-count;j--)
					{
						wait[j]+=times[seniorp][1];
					}
					count=0;
					time+=times[seniorp][1];
				}
				else if(time<times[i][0])
				{
					times[i][0]=times[n-1][0]+1;
					time+=times[i][1];
				}
				else
				{
					for(int j=0; j<n;j++)
					{
						if(times[j][0]>time&&times[j][0]!=times[n-1][0]+1)
							break;
						if(times[j][0]==times[n-1][0]+1)
							continue;
						if(senior<times[j][2])
						{
							senior=times[j][2];
							seniorp=j;
						}
					}
					times[seniorp][0]=times[n-1][0]+1;
					for(int j=0; j<n;j++)
					{
						if(times[j][0]>time&&times[j][0]!=times[n-1][0]+1)
							break;
						if(times[j][0]==times[n-1][0]+1)
							continue;
						wait[j]+=times[seniorp][1];
					}
					time+=times[seniorp][1];
				}
			}
		}
	}
}
