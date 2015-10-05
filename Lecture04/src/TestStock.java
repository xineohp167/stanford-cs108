import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestStock{

	public static void main(String[] args) {
		Stock st1 = new Stock("a", 3, 2);
		Stock st2 = new Stock("b", 2, 200);
		Stock st3 = new Stock("c", 1, 3);
		
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(st3);
		stocks.add(st2);
		stocks.add(st1);
		
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}
		Collections.sort(stocks);
		
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}
		
		Collections.sort(stocks, new Stock.StockSortByGrams());
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}

		Collections.sort(stocks, new Stock.StockSortByPricePerGram());
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}
		
		Collections.sort(stocks, new Stock.StockSortByTotalPrice());
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}
		
		Collections.sort(stocks, Stock.StockSortByName);
		for (Stock stock : stocks) {
			System.out.println(stock.getName());
		}
	}
}
