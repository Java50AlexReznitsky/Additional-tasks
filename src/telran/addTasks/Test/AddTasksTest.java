package telran.addTasks.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import telran.addTasks.AddTask_4;

public class AddTasksTest {
	@Test
	void hasValidBracketsTest() {
		String str1 = "aaaaaa (sdfsdfdsf[dfd(f)f] zcvzxcv {{[ghjk]}} asd )";
		String str2 = ")dfgswfgsf(";
		String str3 = "[werwert(wertwrtw] wertrt)";
		assertTrue(AddTask_4.hasValidBrackets(str1));
		assertFalse(AddTask_4.hasValidBrackets(str2));
		assertFalse(AddTask_4.hasValidBrackets(str3));
	}
}
