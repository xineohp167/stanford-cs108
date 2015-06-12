Hello.java
  -- this very simple program demonstrates some key principles of
     programming regular (non-CS106) Java
	 
	 - the function/method that will be executed first is:
	 
	     public static void main(String[] args)
		 
	 - to print information use:
	 
	      System.out.println("Hello");
		  
	   or

	      System.err.println("Hello");
		  
	   I generally use System.out if what I'm printing represents the true
	   output of the program and System.err if I'm printing debugging information
	   or other status reports appropriate for administrators, but not for
	   most end-users
	   
----

The following examples demonstrate Call by Reference vs. Call By Value

CallByValueExample.java -- in this example incrementing a parameter does nothing,
   parameters are passed by value and so only the value of x is passed into the
   method increment
   
CallByValueExample2.java -- in this case we are passing in an object, which is 
   a reference type.  While we can't change what the parameter refers to, we can
   change the values inside the object which is being referred to
   
CallByValueChange.java -- This example shows that we can't really change the object
   itself to refer to a different object, this is what a true call-by-reference
   would allow.

----

MyPoint.java -- this example provides several key points

  - MyPoint includes a copy constructor, which can be used to create new
    objects with the same values as an existing object.
	
  - The equals method compares the values of an object rather than the object
    itself.  (We'll see a fancier, better version of equals once we've gone
	over inheritance).
	
CopyingExamples.java
  -- this illustrates the difference between creating a clone with MyPoint's copy
     constructor vs. simply using assignment with =
	
----

StringComparison.java
  - Two strings with the same character are not == but they are .equals.

Student.java
  - this example illustrates a wide range of points, see the comments inside
    the file for further information
	
MultiDimensionalExample.java
  - this example (inspired by an official Sun example) shows how Java arrays
    of arrays work.  Notice the different arrays within cartoons have 
	different lengths.
	

	
	
	   