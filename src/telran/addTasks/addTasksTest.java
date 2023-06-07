package telran.addTasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class addTasksTest {

	@Test
	void maxSubsequenceLength() {
		int[] array = { 0, 9, 2, 7, 5, 1, 1, 1, 5 };
		assertEquals(3, AddTasks.maxSubsequenceLength(array));
	}

	@Test
	void myDecimalToBinaryTest() {
		assertEquals("101", AddTasks.myDecimalToBinary(5));
		assertEquals("110100", AddTasks.myDecimalToBinary(52));
	}

	@Test
	void javaDecimalToBinaryTest() {
		assertEquals("101", Integer.toBinaryString(5));
		assertEquals("110100", Integer.toBinaryString(52));
	}

}
