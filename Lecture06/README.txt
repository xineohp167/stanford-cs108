=====

BasicSwing.java - basic starter file for using Swing
BetterSwing.java - improved starter file for Swing with
  multi-threading support.  We'll use this later in the quarter
  
LookNFeel.java
  - shows how to set the Look and Feel of a Java GUI application
  
Face.java
  - basic drawing component

=====

SimpleSetup.java - we can put all our setup in public static void main
  as in this file, but as examples get more complex, we're better off
  moving items into the constructor as in the Converter.java file

Converter.java - event handling using the frame class itself as
  the event handler
  
ConverterAnonymous.java - event handling using an anonymous class

=====

TwoWayConverter.java - without anonymous classes, we need a way of 
  distinguishing which button was pressed
  
TwoWayConverterAnonymous - seperate anonymous classes distinguish 
  between button presses automatically
  
TwoWayConverterMultiway.java - the Command String can be used to
  determine what caused an ActionEvent.  In contrast to the
  getSource method used in TwoWayConverter.java, we can setup
  our controls so that different controls generate the same
  Command String.
  
=====

Mouse1.java - When we subclass an interface like MouseMotionListener we
  must implement all methods listed in the interface.
  
Mouse2.java - Swing provides adapter classes which implement all methods
  in their corresponding interface.  When using an adapter class, we only
  override the methods that we are interested in, the adapter class handles
  events we are not interested in.
  
=====
  
Mouse3.java - Notice we can register more than one listener for a particular
  event.  In this case, when the mouse is moved, both MouseMotionListeners
  will be called.
