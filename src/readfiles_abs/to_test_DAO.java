package readfiles_abs;

import java.util.List;

import com.sms.Physical.Order;
import com.sms.FileIO.Res;

public class to_test_DAO {

	public static void main(String[] args) throws Exception
	{
		DataAccess d = new DataAccessJson(Res.getDesktopFile("dsa2017-data/1e2"));
//		d = new DataAccessXlsx(Res.getDesktopFile("dsa2017-data/1e2"));
//		d = new DataAccessLintex(Res.getDesktopFile("dsa2017-data/1e2"));
		
		List<Order> items = d.readList("orders", Order.class);
		
		items = items.subList(0, 10);
		d.writeList(items, Order.class);
	}

}
