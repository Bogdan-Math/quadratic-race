package race.logic;

public enum Difficulty {
	easy,
	normal,
	hard;

	public static Difficulty modeToDifficulty(Mode mode) {
		if (mode == Mode.EASY) return easy;
		if (mode == Mode.NORMAL) return normal;
		if (mode == Mode.HARD) return hard;
		throw new RuntimeException("What is this mode: " + mode);
	}
}
