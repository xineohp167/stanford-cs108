package metropolis;

import java.sql.ResultSet;

public interface MetropolisControl {
	
	/**
	 * Searches the Metropolis data-set for the provided search parameters.
	 * Returns the query results as a java.sql.ResultSet
	 * 
	 * @param metropolis
	 *            value of the metropolis field
	 * @param continent
	 *            value of the continent field
	 * @param population
	 *            value of the population field
	 * @param populationLargerThan
	 *            True if "Population Larger Than" has been selected
	 * @param exactMatch
	 *            True if "Exact Match" has been selected
	 * 
	 * @return resultSet Results for the given query
	 */
	public ResultSet search(String metropolis, String continent,
			String population, boolean populationLargerThan, boolean exactMatch);

	/**
	 * Adds the entry to the Metropolis data-set.
	 * 
	 * @param metropolis
	 *            value of the metropolis field
	 * @param continent
	 *            value of the continent field
	 * @param population
	 *            value of the population field
	 */
	public void add(String metropolis, String continent, String population);

}
