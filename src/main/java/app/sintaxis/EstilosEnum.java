package app.sintaxis;

import java.awt.Color;

public enum EstilosEnum {
	normalStyle(Color.WHITE),
	keywordStyle(new Color(0x569CD6)),
	commentStyle(new Color(0x6A9955)),
	stringStyle(new Color(0xCE9178)),
	numberStyle(new Color(0xB5CEA8)),
	functionStyle(new Color(0xDCDCAA));

	private final Color color;

	EstilosEnum(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
