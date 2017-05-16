package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import domain.Car;

class InsetCarDB extends DBAccess {
	void execute(Car car) throws SQLException {
		connect();
		PreparedStatement statement = prepareStatement("INSERT INTO CARS (PRICE, MODEL, AVAILABLE) VALUES(?,?,TRUE)");
		
		statement.setBigDecimal(0, car.getPrice());
		statement.setString(1, car.getModel());
		
		statement.execute();
		disConnect();
	}
}
