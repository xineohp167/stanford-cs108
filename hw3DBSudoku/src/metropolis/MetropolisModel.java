package metropolis;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

/* 
 * CS108 Student: This file will be used to help the staff grade your assignment.
 * You can modify this file as much as you like, provided three restrictions:
 * 1) Do not change the class/file name
 * 		- The class/file name should be MetropolisModel
 * 2) Do not modify the MetropolisControl interface
 * 3) MetropolisModel must implement the MetropolisControl interface
 * 		- You can modify MetropolisModel to inherit/implement any additional class/interface
 */
public class MetropolisModel extends AbstractTableModel implements
		MetropolisControl {

	private int rowsCount = 0;
	private int colCount = 0;
	private ResultSet lastResults = null;

	public ResultSet search(String metropolis, String continent,
			String population, boolean populationLargerThan, boolean exactMatch) {
		ResultSet rs = null;
		try {
			Connection con = MyDBInfo.getConnection();
			String query = createSearchQuery(metropolis, continent, population,
					populationLargerThan, exactMatch);

			PreparedStatement preparedStatement = con.prepareStatement(query);
			int position = 1;

			if (!metropolis.isEmpty())
				preparedStatement.setString(position++,
						decoratePercentSign(metropolis, exactMatch));
			if (!continent.isEmpty())
				preparedStatement.setString(position++,
						decoratePercentSign(continent, exactMatch));
			if (!population.isEmpty())
				preparedStatement.setString(position, population);

			rs = preparedStatement.executeQuery();

			setTableState(rs);

			System.out.println("After " + preparedStatement
					+ "\nFound Records: " + rowsCount); // for debug

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void add(String metropolis, String continent, String population) {
		try {
			Connection con = MyDBInfo.getConnection();

			String query = "INSERT INTO metropolises VALUES(?,?,?);";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, metropolis);
			preparedStatement.setString(2, continent);

			// fast hack for empty strings in population field
			if (population.isEmpty())
				preparedStatement.setNull(3, Types.BIGINT);
			else
				preparedStatement.setString(3, population);

			preparedStatement.executeUpdate();

			search(metropolis, continent, population, true, true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String createSearchQuery(String metropolis, String continent,
			String population, boolean populationLargerThan, boolean exactMatch) {
		String query = "SELECT * FROM metropolises";

		if (!metropolis.isEmpty() || !continent.isEmpty()
				|| !population.isEmpty()) {
			query += " WHERE";

			String operatorForStr = exactMatch ? "=" : "LIKE";
			String operatorForInt = exactMatch ? operatorForStr
					: populationLargerThan ? ">" : "<";

			query += metropolis.isEmpty() ? "" : " metropolis "
					+ operatorForStr + " ?";
			query += continent.isEmpty() ? "" : decorateAND(" continent "
					+ operatorForStr + " ?", !metropolis.isEmpty());
			query += population.isEmpty() ? "" : decorateAND(" population "
					+ operatorForInt + " ?", !metropolis.isEmpty()
					|| !continent.isEmpty());
		}

		query += ";";

		return query;

	}

	private String decorateAND(String input, boolean needAndKeyword) {
		return decorateWith(input, " AND", needAndKeyword, true, false);
	}

	private String decoratePercentSign(String population, boolean isExactMatch) {
		return decorateWith(population, "%", !isExactMatch, true, true);
	}

	private String decorateWith(String input, String decorator,
			boolean needDecoration, boolean left, boolean right) {
		if (!needDecoration)
			return input;
		return (left ? decorator : "") + input + (right ? decorator : "");
	}

	private void setTableState(ResultSet rs) throws SQLException {
		lastResults = rs;
		ResultSetMetaData rsmd = rs.getMetaData();
		colCount = rsmd.getColumnCount();
		rs.last();
		rowsCount = rs.getRow();
		fireTableStructureChanged();
	}

	@Override
	public int getRowCount() {
		return rowsCount;
	}

	@Override
	public int getColumnCount() {
		return colCount;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String name = "";
		try {
			ResultSetMetaData rsmd = lastResults.getMetaData();
			name = rsmd.getColumnName(columnIndex + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object result = null;
		try {
			if (lastResults != null) {
				lastResults.absolute(rowIndex + 1);
				result = lastResults.getObject(columnIndex + 1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}