MyPoint1.java
  - here all information is public, this is the most convenient for
    end users, but limits our ability to change things later in development
	
MyPoint2.java
  - here no direct access to instance variables is provided
  
MyPoint3.java
  - limiting access in MyPoint2.java allows us to change the underlying
    implementation.  MyPoint3.java could easily be substituted for 
	MyPoint2.java, but not for MyPoint1.java
	
----

Grad.java, Student.java
  - these files used to discuss inheritance in lecture, see comments
    in files for more information