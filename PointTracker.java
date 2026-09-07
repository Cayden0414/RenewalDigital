public class PointTracker {
	private int councilPoints;
	private int establishmentPoints;

	public PointTracker() {
		this(0, 0);
	}

	public PointTracker(int councilPoints, int establishmentPoints) {
		this.councilPoints = councilPoints;
		this.establishmentPoints = establishmentPoints;
	}

	public int getCouncilPoints() {
		return councilPoints;
	}

	public int getEstablishmentPoints() {
		return establishmentPoints;
	}

	/**
	 * Add points to the specified target.
	 * @param points the number of points to add (can be negative to subtract)
	 * @param toCouncil true to add to the council, false to add to the establishment
	 */
	public void addPoints(int points, boolean toCouncil) {
		if (toCouncil) {
			councilPoints += points;
		} else {
			establishmentPoints += points;
		}

		checkPointsRequirement(toCouncil);
	}

	/**
	 * Placeholder score check that runs after each point update for the selected side.
	 * TODO: replace the placeholder requirement values with the real game targets.
	 */
	private void checkPointsRequirement(boolean toCouncil) {
		int requiredPoints = toCouncil ? 2 : 2;
		hasReachedPointsRequirement(toCouncil, requiredPoints);
	}

	/**
	 * Determines whether the selected side has reached the specified point requirement.
	 * @param toCouncil true for the council, false for the establishment
	 * @param requiredPoints the threshold to compare against
	 * @return true when the selected side has reached or exceeded the requirement
	 */
	public boolean hasReachedPointsRequirement(boolean toCouncil, int requiredPoints) {
		int currentPoints = toCouncil ? councilPoints : establishmentPoints;
		return currentPoints >= requiredPoints;
	}

	@Override
	public String toString() {
		return "Council: " + councilPoints + ", Establishment: " + establishmentPoints;
	}

}
