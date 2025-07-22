package pages;

import java.util.Random;

import com.microsoft.playwright.Page;

public class PageHelper {

	public void randomMouseMove(Page page) {
		int viewportWidth = page.viewportSize().width;
        int viewportHeight = page.viewportSize().height;

        Random random = new Random();
        int randomMovements = random.nextInt(7);

        for (int i = 0; i < randomMovements; i++) { // Perform n random movements
            int randomX = random.nextInt(viewportWidth);
            int randomY = random.nextInt(viewportHeight);

            System.out.println(i + " : Moving mouse to: (" + randomX + ", " + randomY + ")");
            page.mouse().move(randomX, randomY);
            page.waitForTimeout(500); // Add a small delay between movements
        }

		
	}
}
