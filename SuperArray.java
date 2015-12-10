/*
  Team StealYoManz -- Olivia Gallager and Jennifer Yu (Dilligent Swagga OG and Jennie J Slice a.k.a. Smug Hood are back at it yo)
  APCS1 pd9
  HW42 -- Array of Titanium
  2015-12-06
*/
//let me ponder that question ^^ ?

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements ListInt {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

    //we changed  size --> lastPos because a size could be 3 and the array could be 100 elements and you would only get thru the
    //first 3 even if the significant points were spaced out.
   
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }



		
    //double capacity of this SuperArray
    public void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index

    public int set( int index, int newVal ) 
    { 
 	int temp = _data[index]; //saves original value at index
	_data[index] = newVal; //index set to new value
	return temp; //returns old value
    }

    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    //creates a new temporary array, increments its length
    public void add( int newVal ) { 
		int len = _data.length+1;
		int [] temp = new int[len]; //creates new array with greater length by 1
		temp[_lastPos+1]=newVal; //changes the int after the last meaningful into new value
		for (int a = 0; a < _lastPos+1 ; a++) {
	    	temp[a] = _data[a];
		}
		_size+=1;
		_lastPos= _lastPos + 1;
		_data=temp;
    }



    //inserts an item at index
    //shifts existing elements to the right
    //if an element is before target, remains same, at target, does nothing
    public void add( int index, int newVal ) { 
    	int len = _data.length + 1;
    	int [] temp = new int[len];
    	
    	if (index < _size) {//very important!
    	
    	for (int a = 0; a <= _lastPos ; a ++) {
	    	if (a==index) {
				temp[a] = newVal;
	    	}
	    	else if(a < index) {
				temp[a] = _data[a];
	    	}
	    	else {
				temp[a]=_data[a+1];//once it crosses the entry point, it has to shift, but before that it doesn't have to
	    	}
	    _size+=1;//nested zeros become significant
    	}
    	_data=temp;
    }
    else {
    	System.out.println("error index out of range for significant values ");
    }
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) { 
	int[] temp = new int[_data.length-1];
	if (index <= _lastPos) { //otherwise would not need to remove because it would be 0
	    for (int ctr =0; ctr < index; ctr ++) {
		temp[ctr] = _data[ctr];
	    }
	    for (int ctr1 = index+1; ctr1 <=  _lastPos; ctr1 ++) {
		temp[ctr1-1] = _data[ctr1];
	    }
	    _size -= 1; //meaningful ints reduced by 1
	    _lastPos -= 1; //shifted to left so _lastPos reduced by 1
	}
	_data = temp; 
    }


    //return number of meaningful items in _data
    public int size() { 
    	return _size;
    	//able to do this because all add functions increment _size as significant things are added
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	ListInt og = new SuperArray();
	SuperArray curtis = (SuperArray)og;
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    //curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
	System.out.println("Should still be empty because nothing was ADDED\n");

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}
	System.out.println("Should print nothing because curtis has nothing significant yet :(\n");
	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);
	System.out.println("lmao should be empty also \n");
	
	ListInt mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	System.out.println("Should be [5,4,3,2,1]");

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	System.out.println("Should be [5,4,3,1]");
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	System.out.println("Should be [5,4,3]");

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("Should be [5,4,3] because index thres dont exist son");
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("Should be [5,5,88,0,0,0]");
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("Should be [5,77,0,0,0,0,0,0,0]");	


    }//end main
		
}//end class