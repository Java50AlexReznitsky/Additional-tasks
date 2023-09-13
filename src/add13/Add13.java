package add13;

import java.util.NoSuchElementException;

public class Add13 {

	public class ShootingRating {
		static final double RATE_FACTOR = 0.7;
		static final int RANGE = 10;

		public static int rateShooting(int[] shootingResults) {
			int[] lookup = new int[RANGE + 1];
			int border = (int) (shootingResults.length * (1 - RATE_FACTOR));
			int rate = 0;
			for (int hit : shootingResults) {
				if (hit > RANGE && hit < 0) {
					throw new NoSuchElementException();
				}
				lookup[hit]++;
			}
			for (int i = 0; i < lookup.length; i++) {
				while (lookup[i] > 0 && border >= 0) {
					rate = i;
					lookup[i]--;
					border--;
				}
			}
			return rate;
		}
	}

}
