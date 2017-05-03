package factsforfalk.theprojectx;

import java.util.ArrayList;

/**
 * Created by Martin on 02.05.2017.
 */

public class Market
{
	private String mName;

	public Market( String name )
	{
		mName = name;
	}

	public String getName()
	{
		return mName;
	}

	public static ArrayList<Market> createContactsList(int numContacts)
	{
		ArrayList<Market> markets = new ArrayList<Market>();

		markets.add(new Market("Netto"));
		markets.add(new Market("Rewe"));
		markets.add(new Market("Lidl"));
		markets.add(new Market("Obi"));
		markets.add(new Market("Wan"));
		markets.add(new Market("Kanobi"));
		markets.add(new Market("Penny"));
		markets.add(new Market("Penny"));
		markets.add(new Market("Penny"));
		markets.add(new Market("Netto"));
		markets.add(new Market("Netto"));

		return markets;
	}
}