import java.util.Random;

public class Main {
	public static void main(String[] args) {
		String[] people = {"ZongYeee", "Aping", "BingZhong", "WangNing"};
		Restaurant restaurant = new Restaurant();
		for (int i = 0; i < 4; i++) {
			int random = new Random().nextInt(10);
			try {
				Thread.sleep(random * 1000);
				Guest guest = new Guest(people[i]);
				System.out.println(guest.getName() + " ¶i¤JÀ\ÆU¤F..");
				restaurant.addGuest(guest);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
