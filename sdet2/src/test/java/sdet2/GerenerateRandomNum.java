package sdet2;

import java.util.Random;

public class GerenerateRandomNum {

	public int GerenerateRandomNumber()  {
      
		Random random = new Random();
		 int randomInt = random.nextInt(1000);
		 System.out.println(randomInt);
		 return randomInt;

	}

}
