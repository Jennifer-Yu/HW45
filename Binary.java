/*
Jennifer Yu
HW43 -- This or That, Revised
APCS1 pd9
2015-12-08
*/

public class Binary {
    //To search and replace: C-s M-% y:replace, n:skip

    /*=====================================
      INSTANCE VARIABLES
      =====================================*/
    private int _decNum;
    private String _binNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_binNum = "0";
	_decNum = 0;  
    }

    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);  
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_binNum = s;
	_decNum = binToDec(s);
    }

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      =====================================*/
    public static String decToBin( int n ) {
        String bin = "";
        if (n == 0) {
            bin = "0";
        }
        while (n > 0) {
            bin = (n % 2) + bin;
            n = n / 2;
        }
        return bin;
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
	    =====================================*/

    public static String decToBinR( int n ) {
        if (n == 0) {
	    return "";
	}
        else {
	    return decToBinR( n / 2 ) + n % 2;
	}
    }
	
    /*=====================================
      String binToDec(String) -- converts base-10 input to hex
      pre:  s represents non-negative hexadecimal number
      post: returns String of bits
      =====================================*/
    public static int binToDec( String s ) {
	int ans = 0;
	for (int i = 0; i < s.length() ; i++){
	    if ( s.substring(i,i+1).equals("1") ) ans+= Math.pow(2,s.length() - (i + 1));
	}
	return ans;
    }

    /*=====================================
      String binToDecR(String) -- converts base-10 input to hexadecimal, recursively
      pre:  s represents non-negative hexadecimal number
      post: returns String of bits
      =====================================*/
    public static int binToDecR( String s ) { 
	if (s.length() == 1) {
	    return Integer.parseInt(s) * (int)(Math.pow(2,0));
	}
	else {
	    return (Integer.parseInt(s.substring(0,1)) * (int)(Math.pow(2,s.length() - 1))) + binToDecR(s.substring(1));
	}
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hex values
    =============================================*/
    public boolean equals( Object other ) {
	if (!(other instanceof Binary)) //catches an incorrect input error
	    throw new ClassCastException ("\nequals() input not a Binary");
	String theOth = ((Binary)other)._binNum;
	//initialize a string and set it to the hexNum of other
	//other is typecasted to as Binary because we know
	//it will be an instance of class Binary
	return (_binNum.equals(theOth));
	//return t/f if the hexNum of this is equal to other's hexNum
    }

    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
    =============================================*/
    public int compareTo( Object other ) {
	if (!(other instanceof Binary)) //catches an incorrect input error
	    throw new ClassCastException ("\ncompareTo() input not a Binary");
	int othDec = ((Binary)other)._decNum;
	//initialize an int as the decNum of other
	//other is typecasted for the same reason as in the equals method
	if (_decNum > othDec) {
        //if the decNum of this is greater than other's decNum
	    return 1;
	    //return a positive int
	} else if (_decNum == othDec) {
	  //if it is equal
	    return 0;
	    //return 0
	} return -1;
	//else return a negative int
    }


    //main method for testing
    public static void main( String[] args ) {


	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	/*=========================================
	  =========================================*/
    }//end main()

} //end class
