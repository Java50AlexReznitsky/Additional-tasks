package add13.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import add13.Add13.ShootingRating;

class Add13_tests {
	int[] shResults = {4,3,6,7,2,9,9,4,10,8};

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals(4,ShootingRating.rateShooting(shResults));
	}

}
