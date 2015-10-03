import static org.junit.Assert.*;
import org.junit.*;

public class StudentTest {

	@Test
	public void testStudentUnitsAndStress() {
		Student st = new Student(18);
		assertEquals(18, st.getUnits());
		assertEquals(180, st.getStress());
	}
	
	@Test
	public void defaultUnitsShouldBe15() {
		Student st = new Student();
		assertEquals(15, st.getUnits());
		st.dropUnits(2);
		assertEquals(13, st.getUnits());
		
		// dropUnits ignored if number units < 9
		st.dropUnits(10);
		assertEquals(13, st.getUnits());
	}
	
	
// instead of rebuilding everything for each test, we can instead
// take advantage of instance variables and @Before and @After methods
// we'll use the testStudent for the next three test cases
	private Student testStudent;
	
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
		assertEquals(200, testStudent.getStress());
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
		assertNotEquals(new Student(21), testStudent);
		assertSame(testStudent,newStudent);   // checks for ==
		assertNotSame(testStudent, new Student(20));
		assertNotNull(testStudent);
	}
}
