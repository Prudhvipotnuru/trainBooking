package database;

public class TrainFactory {
	private TrainFactory() {

	}

	public static TrainDAL td;

	public static TrainDAL getTrainDALImpl() {
		if (td == null) {
			td = new PgTrainDAL();
		}
		return td;
	}
}
