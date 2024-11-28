package m2p;

import tree.BSTCRUD;

import java.util.Scanner;

public class Test4 {
    public static int getDuplicate(int[] arr){
        int index=0;
        int res=-1;

        while(true){
            if(arr[index]==-1){
                res=index;
                break;
            }
            int temp=arr[index];
            arr[index]=-1;
            index=temp;
        }

        return res;
    }

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node root=null;
    static int res=-1;
    public static Node addInsertNode(Node root,int data){
        if(root==null){
            root=new Node(data);
        }else if(data==root.data){
            res=data;
        }else if(data<root.data){
            root.left=addInsertNode(root.left,data);
        }else{
            root.right=addInsertNode(root.right,data);
        }
        return root;
    }

    public static int getDuplicateTree(int[] arr){
        for(int i=0;i<arr.length;i++){
            root=addInsertNode(root,arr[i]);
            if(res!=-1){
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] inputArr=sc.nextLine().split(" ");
        int[] arr=new int[inputArr.length];
        for(int i=0;i<inputArr.length;i++){
            arr[i]=Integer.parseInt(inputArr[i]);
        }
        int res=getDuplicateTree(arr);
        System.out.println(res);


    }
}









