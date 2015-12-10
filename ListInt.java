public interface ListInt {
    
    //public int[] _data;
   // public int _size;
    //public int _lastPos;
    
    
    
    //precond: _data exists and has an array length greater than 0
    //post cond: lastpos incremented, size incremented, data is modified

    void add(int newVal); //adds a newval in the index right after lastpos


    //precond: array _data where the index of the newVal is less than the _size 
    //post cond: the newVal is added to the specified index, _size++
    
    void add(int index, int newVal); //add at index
   
    //precond is that _data has the index in question
    //post cond is modified instace vars:lastpos and size increment accordingly, shift is to the left

    void remove(int index); //removes element at index

    //precond is that _data has been instantiated
    //post cond is an int is returned- nothing modified
    
    int size(); //returns instance var _size

    
    //returns value at index
    int get(int index);
    
    //sets the value at a specified index to newVal
    //post cond is that size is NOT modified, nor is lastpos
    int set(int index, int newVal); 
    
    
    void expand();
}