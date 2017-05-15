package database;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Car;
import exceptions.ErrorMessage;

public class SearchCarDB extends DBAccess {
	List<Car> execute(BigDecimal price, String model, Boolean Avaible) {
		List<Car> cars = new ArrayList<Car>();
		try {
			connect();

			PreparedStatement statement = prepareStatement("SELECT * FROM CARS WHERE PRICE = ? AND MODEL = ? AND AVAILABLE = ?");
			statement.setString(0, "%" + price + "%");
			statement.setString(1, "%" + model + "%");
			statement.setBoolean(2, Avaible);

			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				cars.add(new Car(rs.getBigDecimal("PRICE"), rs.getString("MODEL"), rs.getBoolean("AVAIBLE")));
			}
			
			rs.close();
			disConnect();

		} catch (SQLException e) {
			new ErrorMessage("Search function went wrong");
		}

		return cars;
	}
}


