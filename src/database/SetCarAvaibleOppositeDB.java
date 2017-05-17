package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Car;

class SetCarAvaibleOppositeDB extends DBAccess{
	void execute(Car car) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("UPDATE CARS SET AVAILABLE = NOT AVAILABLE WHERE MODEL = ? AND PRICE = ?");

		statement.setString(1, car.getModel());
		statement.setBigDecimal(2, car.getPrice());

		statement.execute();
		disConnect();
	}
}
