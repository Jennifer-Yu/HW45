//Team  Diligent Swagga OG and Jennie J Slice a.k.a. Smug Hood-- Olivia Gallager and Jennifer Yu
//APCS1 pd9
//HW41 -- In America, the Driver Sits on the Left
//2015-12-04

public class Rational implements Comparable {

    //instance vars
    private int num;
    private int den;
    
    //default constructor
    public Rational() {
	num = 0;
	den = 1;
    }
    
    //overloaded constructor
    public Rational (int x, int y) {
	this();
	if (y==0) {
	    System.out.println("Error: divide by zero");
	}
	else {
	    num = x;
	    den = y;
	}
    }
    
    public static int gcd(int a, int b) {
	if (b == 0) return a;
	//if b > a, they will flip
	return gcd(b, a%b);
    }

    public void reduce() {
	int gcd = gcd(num, den);
	if (gcd != 1) {//already reduced as much as possible
	    num /= gcd; //updates num
	    den /= gcd; //updates den
	}
    }

    public String toString() {
	reduce();
	String frac = "Fractional form: " + num  + "/" + den + "\n";
	String dec  = "Decimal form: " + floatValue() + "\n";
	return frac + dec;
    }
    
    public double floatValue() {
	return num * 1.0 / den;
    } 
    
    public void multiply (Rational og) {
	num *= og.num; //updates num
	den *= og.den; //updates den
    }
    
    public void divide(Rational og) {
	if (og.num == 0) {
	    System.out.println("Error: divide by zero");//undefined much?
	}
	else {
	    num *= og.den; //updates num
	    den *= og.num; //updates den
	}
    	//when dividing r by s, r is multiplied by reciprocal of s
    }

    public void add(Rational og) {
	int gcd = gcd(den, og.den);
	int x = den / gcd;//x and y are scale factors so both numbers can share a common denom
	int y = og.den / gcd;
        num = num * y + og.num * x;
	den *= y;
    }

    public void subtract(Rational og) {
	int gcd = gcd(den, og.den);
	int x = den / gcd;
	int y = og.den / gcd;
	num = num * y - og.num * x;//same algo as add but with -
	den *= y;
    }
    
    //re: add() and subract()
    /* by multiplying the num and den of one factor by the den/gcd of 
       the other we are essentially finding the lcm of both denominators */

    public int compareTo(Object og) {
    	boolean retVal = (this instanceof Rational);
    	boolean ret2 = (og instanceof Rational);
    	if (retVal && ret2 ) {
		double d1 = floatValue();
		double d2 =  ((Rational)og).floatValue();
		if (d1 == d2) return 0;
		if (d1 > d2) return 1;
		return -1;
    	}
    	else {
    		return 2;
    	}
    }
    
    /*
    equals
	Takes 1 Object as input X
	Returns true if input is of class Rational and of equal value to calling instance of Rational
Returns false otherwise
    */
    
    
    public boolean equals(Object og) {
    	//return (this.compareTo(og) == 0);
    	//First, check for aliasing.
    	boolean retVal = this == og;
	//Next, if this and input Object are different objects,
        if ( !retVal )
	//...check to see if input Object is a Tile
	retVal = og instanceof Rational 
	//...and that its state variables match those of this Tile
	    && (1.0*this.num)/this.den == (1.0*((Rational)og).num)/((Rational)og).den;
	return retVal;
    	
    }
    
    public static void main(String[] args) {
   
	Rational r = new Rational();
	Rational s = new Rational(8, 18);
	Rational t = new Rational(4, 6);
	Rational v = new Rational(7, 21);
	Rational w = new Rational(7, 21);
/*
	System.out.println("~~--------------------------------~~");
	
	System.out.println("Testing toString(): \n");
	System.out.println();
	System.out.println("Rational r:");
	System.out.println(r);
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational t:");
	System.out.println(t);
	System.out.println("Rational v:");
	System.out.println(v);
	
	System.out.println("~~--------------------------------~~");

	System.out.println("Testing multiply(): ");
	System.out.println();
	System.out.println("s * v");
	System.out.println();
	System.out.println("BEFORE:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);
	s.multiply(v);
	System.out.println("AFTER:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);

	System.out.println("~~--------------------------------~~");

	System.out.println("Testing divide(): ");
	System.out.println();
	System.out.println("v / s");
	System.out.println();
	System.out.println("BEFORE:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);
	v.divide(s);
	System.out.println("AFTER:");
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.println("Rational v:");
	System.out.println(v);
	
	System.out.println("~~--------------------------------~~");

	System.out.println("Testing add(): ");
	System.out.println();
	System.out.println("r + t");
	System.out.println();
	System.out.println("BEFORE:");
	System.out.println("Rational r:");
	System.out.println(r);
	System.out.println("Rational t:");
	System.out.println(t);
	r.add(t);
	System.out.println("AFTER:");
	System.out.println("Rational r:");
	System.out.println(r);
	System.out.println("Rational t:");
	System.out.println(t);
	
	System.out.println("~~--------------------------------~~");

	System.out.println("Testing subtract(): ");
	System.out.println();
	System.out.println("t - r");
	System.out.println();
	System.out.println("BEFORE:");
	System.out.println("Rational t:");
	System.out.println(t);
	System.out.println("Rational r:");
	System.out.println(r);
	t.subtract(r);
	System.out.println("AFTER:");
	System.out.println("Rational t:");
	System.out.println(t);
	System.out.println("Rational r:");
	System.out.println(r);
	*/
	System.out.println("~~--------------------------------------------~~");

	System.out.println("Testing compareTo(): ");
	System.out.println();
	System.out.println("Rational r:");
	System.out.println(r);
	System.out.println("Rational w:");
	System.out.println(w);
	System.out.print("compare r and w: ");
	System.out.print(r.compareTo(w) + "\n\n");
	
	//what how does compareTo function when numbers are equal? floats are weird
	Rational apple = new Rational(3,9);
	Rational banana = new Rational(1,3);
	System.out.println("Testing compareTo(): ");
	System.out.println();
	System.out.println("Rational apple:");
	System.out.println(apple);
	System.out.println("Rational banana:");
	System.out.println(banana);
	System.out.println("compare apple and banana: ");
	System.out.println(apple.compareTo(banana) + "\n\n");
	
	System.out.println("Rational v:");
	System.out.println(v);
	System.out.println("Rational w:");
	System.out.println(w);
	System.out.print("compare v and w: ");
	System.out.print(v.compareTo(w) + "\n\n");
	
	System.out.println("Rational t:");
	System.out.println(t);
	System.out.println("Rational s:");
	System.out.println(s);
	System.out.print("compare t and s: ");
	System.out.print(t.compareTo(s) + "\n\n");

        
	System.out.println("~~--------------Testing equals()------------------~~");
	
        Object a = new Rational (1,7);
        Object b = new Rational (2,14);
        Object c = new Rational (3,14);
        Object d = new Rational (1,7);
 
         
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(b.equals(c));

        System.out.println("~~--------------------------------~~");
	
    }
  
}
