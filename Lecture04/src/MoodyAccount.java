import java.awt.Color;

public abstract class MoodyAccount extends Account implements Moodable {
	
	public MoodyAccount(double balance) {
		super(balance);
	}

	public Color getMood() {
		if (balance < 0)
			return Color.red;
		if (balance < 50)
			return Color.yellow;
		if (balance > 1000)
			return Color.green;
		return Color.blue;
	}
}
