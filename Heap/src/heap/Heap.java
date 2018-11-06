/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author rodrigo
 */
public class Heap {
    
    private int capacity = 12;
    private int[] list;
    private int heapSize = 0;
    private int[] listSort;
    private int j = 0;

    public int[] getList() {
        return list;
    }
    
    public int[] getSort(){
        return listSort;
    }

    public Heap(int cap) {
        this.capacity = cap;
        list = new int[capacity];
        listSort = new int[capacity];
    }
    
    public int top(){
        return list[1];
    }
    
    public int getParent(int index){
        return list[(index)/2];
    }
    
    public int getLeft(int index){
        return list[2*index];
    }
    public int getRight(int index){
        return list[2*index +1];
    }
    
    public int getParentIndex(int index){
        return (index)/2;
    }
    
    public int getLeftIndex(int index){
        return 2*index;
    }
    public int getRightIndex(int index){
        return 2*index +1;
    }
    
    public int size(){
        return heapSize;
    }
    
    public boolean isLeaf(int index){
        return getLeftIndex(index) > heapSize && getRightIndex(index) > heapSize;
    }
    
    public boolean isFull(){
        return heapSize == list.length -2;
    }
    
    public void doubleArray(){
        int[] temp = new int[list.length*2];
        
        for(int i = 1 ; i < list.length -1; i++){
            temp[i] = this.list[i];
        }
        
        this.list = temp;
        
    }
    
    public void insert(int value){
        
        if(isFull()){
            doubleArray();
        }
        if(size() < 1){
            this.list[1] = value;
            this.heapSize = this.heapSize +1;
        }
        else{
            this.heapSize = this.heapSize +1;
            this.list[this.heapSize] = value;
            upHead();
        }
    }
    
    public void remove(){
        if(size() < 2){
            listSort[j++] = this.list[1];
            this.list[1] = 0;
            this.heapSize = this.heapSize - 1;
        }
        else if(size()< 3){
            
            if(this.list[1] < this.list[2]){
                listSort[j++] = this.list[1];
                this.list[1] = this.list[2];
                
            }
           
            else{
                listSort[j++] = this.list[2];
            }
            
            this.list[2] = 0;
            heapSize--;;
            
        }
        else{
            //System.out.println("Minimo: " + this.list[1]);
            listSort[j++] = this.list[1];
            this.list[1] = list[heapSize];
            this.list[heapSize] = 0;
            downHeap(1);
            heapSize--;
        }
    }
    
    public void upHead(){
        
        int fix = list[heapSize];
        int i = 1;
        int parent;
        int temp = heapSize;
        
        while(fix < list[heapSize/(2*i)]){          
            parent = list[heapSize/(2*i)];
            list[temp] = parent;
            list[heapSize/(2*i)] = fix;
            temp = heapSize/(2*i);
            i++;
            
        }
        
    }
    
    public void downHeap(int node){
        int temp;
        int li = getLeftIndex(node);
        int ri = getRightIndex(node);
        if(isLeaf(node)){
            return;
        }
        if(list[ri] < list[node] || list[li] < list[node]){
            if(list[ri] < list[li] && list[ri] != 0){
                temp = list[node];
                list[node] = list[ri];
                list[ri] = temp;
                downHeap(ri);    
            }
            else if(list[li] != 0){
               
                temp = list[node];
                list[node] = list[li];
                list[li] = temp;
                downHeap(li);
                
            }
              
        }
       // else if(list[li] < list[node]){
        //    if(list[ri] > list[li]){
         //       temp = list[node];
           //     list[node] = list[li];
             //   list[li] = temp;
               // downHeap(li);
            //}
                    
    
    }
   
}
