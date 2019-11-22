public class Sorceress extends Hero {

	private final static String name = "Sorceress";
	private final static int hitPoints = 75;
	private final static int attackSpeed = 5;
	private final static double chanceToHit = .7;
	private final static int damageMin = 25;
	private final static int damageMax = 50;
	private final static double chanceToBlock = .3;

	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	public Sorceress() {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);
	}

	public void battleChoices(DungeonCharacter opponent) {
		super.battleChoices(opponent);
		int choice;

		do {
			boolean valid = false;
			while (!valid) {
				System.out.println("1. Attack Opponent");
				System.out.println("2. Increase Hit Points");
				System.out.print("Choose an option: ");
				choice = Keyboard.readInt();
				switch (choice) {
				case 1:
					attack(opponent);
					valid = true;
					break;
				case 2:
					increaseHitPoints();
					valid = true;
					break;
				default:
					System.out.println("Invalid choice, try again!");
				}
			}
			setNumTurns(getNumTurns() - 1);
			if (getNumTurns() > 0)
				System.out.println("Number of turns remaining is: " + getNumTurns());
		} while (getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
	}

	public void increaseHitPoints() {
		int hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: "
				+ getHitPoints() + "\n");
	}
}