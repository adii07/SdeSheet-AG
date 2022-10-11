import java.util.*;
class main{

public static void main(String args[]){
	int[] arr=new int[]{10,15,6,5,20,100,35};
	int[] sortedArr=mergerSort(arr,0,arr.length-1);
	for(int val:sortedArr)
		System.out.println(val);
}


public static  int[] mergerSort(int[] arr,int start,int end){

	if(start==end){
		int[] a=new int[1];
		a[0]=arr[start];
		return a;
	}

	int mid=start+(end-start)/2;
	int[] arr1=mergerSort(arr1,start,mid);
	int[] arr2=mergerSort(arr1,mid+1,end);
	int[] arr3=merge(arr1,arr2);
	return arr3;
}

public static int[] merge(int[] arr1,int[] arr2){
	int[] a=new int[arr1.length+arr2.length];
	int i=0,j=0,k=0;
	while(i<arr1.length && j<arr2.length){
		if(arr1[i]<=arr2[j]){
			a[k++]=arr1[i++];
		}else{
			a[k++]=arr2[j++];
		}
	}
	while(i<arr1.length){
		a[k++]=arr1[i++];
	}
	while(j<arr2.length){
		a[k++]=arr2[j++];
	}
	return a;
}	


/*
a,b,c,d,e
n=3

*/
public void linkkedList(Node head){
	Node slow=head;
	Node fast=head;
	int n=3;

	while(n-->0)
		fast=fast.next;


	while(fast!=null){
		fast=fast.next;
		slow=slow.next;
	}

	Ssytem.out.println(slow.val);
}


class Node{
	int val;
	Node next;
}

}

