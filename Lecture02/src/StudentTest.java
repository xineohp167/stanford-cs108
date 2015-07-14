import static org.junit.Assert.*;
import org.junit.*;

public class StudentTest {

	@Test
	public void testCase1() {
		Student st = new Student(18);
		assertEquals(st.getUnits(), 18);
		assertEquals(st.getStress(), 180);
	}
	
	@Test
	public void testCase2() {
		Student st = new Student();
		assertEquals(st.getUnits(), 15);
		st.dropUnits(2);
		assertEquals(st.getUnits(), 13);
		st.dropUnits(10);
		assertEquals(st.getUnits(), 13);
			// dropUnits ignored if number units < 9
	}
	
	
// instead of rebuilding everything for each test, we can instead
// take advantage of instance variables and @Before and @After methods
// we'll use the testStudent for the next three test cases
	Student testStudent;
	
	// this gets called before _every_ test case
	@Before
	public  void setUp() {
		testStudent = new Student(20);
	}
	
	// this gets called after _every_ test case
	@After
	public  void tearDown() {
		// if we wanted to do cleanup after each test, we could
		// do it here
	}
	
	// notice all the actual test methods start with the name "test"
	// (e.g., testCase1, testCase2, testOne).  
	@Test
	public void testOne() {
		assertEquals(testStudent.getStress(), 200);
		testStudent.dropUnits(8);
			// setUp gets called again before every test
			// this change won't carry on to another test
	}
	
	@Test
	public void testTwo() {
		assertEquals(testStudent.getUnits(), 20);
			// testStudent has been reset since testOne
	}
	
	// while we've only been using assertTrue, a wide variety of asserts
	// are available.  see http://kentbeck.github.com/junit/javadoc/latest/
	@Test
	public void testThree() {
		Student newStudent = testStudent;
		
		assertFalse(testStudent.getStress() < 5);
		assertEquals(testStudent,newStudent); // calls equals
		assertSame(testStudent,newStudent);   // checks for ==
		assertNotSame(testStudent, new Student(20));
		assertNotNull(testStudent);
	}
}
