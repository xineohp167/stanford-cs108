=====

These examples show Swing use of Model View Controller (MVC)

TextExample.java - two JTextFields are connected by sharing 
  a Document (Swing's equivalent of an MVC Model)
  
TextExampleFancy.java - the same Document is used to update three
  JTextFields.  However, the third JTextField gives status reports,
  rather than mirroring the text.  This is done by adding a 
  DocumentListener which updates the third JTextField
  
ButtonExample.java - even the Swing buttons have models underlying
  them.  Here we have a menu item and a checkbox button share a
  button model.  When one is updated the other is also automatically
  updated.
  
=====

SimpleTable.java - We can create a JTable backed by an Array of Arrays
  (i.e., the Java equivalent of a 2-Dimensional Array) for the data.  
  There are several approaches to getting the JTable including headers 
  to show up properly in the window.
  
SimpleTableModel.java - Explicitly creating a table model will give us
  more flexibility.  In our first example with an explicit table model,
  we simply copy an array of arrays along with a header array into the
  table model.  We'll see more complex examples momentarily.
  
  The simplest approach is to base our table model on AbstractTableModel.
  
  Note we override getColumnCount, getRowCount, and getValueAt as 
  required if AbstractTableModel subclasses.  We will also typically 
  want to override getColumnName, although it is not required.
  
=====

FakeTableModel.java - We can change where the underlying data in our
  TableModel is.  In the previous example it came from an Array of Arrays.
  In this example, we don't actually store the data, instead we generate
  it dynamically.
  
=====

When data in the underlying model is changed, we need a way of telling 
any views that are based on the model, that they need to update themselves.
To illustrate this we have two examples

---

NoFiringTableModel.java - In this first example we create two tables based
  on the same table model.  If we modify the contents of one JTable (try
  clicking on a data cell and changing it's contents), the other JTable 
  won't know that it needs to redraw itself.  So the contents of the two 
  tables won't be in synch until something forces the other JTable to redraw.

---

In this multi-class example, we show how the fireXXX methods of the
AbstractTableModel class can be used to notify all JTables associated with
a model to redraw themselves.

TableFrame.java - this is the executable class of the example.  It sets
  up a frame with multiple JTables all based on a BasicTableModel (see below)
  along with buttons to add and remove rows and columns.
  
BasicTableModel.java - stores data in a List of Lists.  Provides methods to
  allow adding and removing of rows and columns.  Notice that we call 
  the fireXXX methods as rows are added or removed or if columns are added.
  This tells the corresponding JTables that they need to update themselves.
  
  This model also provides a means to load data from or save data to a file.
  
====

Here is another multi-class example.  As with FakeTableModel this example is
designed to highlight the flexibility of table models.  Here we have two
table models, the BasicTableModel used in the previous example and a new
CensorTableModel.

CensorFrame.java - this is the executable class of the example.  It sets up
  two JTables, one based on a BasicTableModel and a second based on a 
  CensorTableModel which has an underlying copy of the same BasicTableModel
  object used by the other JTable.
  
CensorTableModel.java - this model has an underlying BasicTableModel, which
  stores the actual data.  However, when a client asks for the value of
  a particular cell it sometimes censors the results, depending on censor
  criteria set by the client.  This file contains two possible implementations
  of a table model which censors.
