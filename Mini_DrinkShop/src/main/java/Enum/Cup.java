package Enum;

public enum Cup {
	Small,
	Medium,
	Large,
	ExtraLarge;
	
	public double getPrice(Cup cup) {
		switch (cup) {
		case Small:
			return 10;
		case Medium:
			return 15;
		case Large:
			return 20;
		case ExtraLarge:
			return 25;
		default:
			return 0;
		}
	}
	
	public String getDetail(Cup cup) {
		switch (cup) {
		case Small:
			return " (S)";
		case Medium:
			return " (M)";
		case Large:
			return " (L)";
		case ExtraLarge:
			return " (XL)";
		default:
			return "";
		}
	}
}
