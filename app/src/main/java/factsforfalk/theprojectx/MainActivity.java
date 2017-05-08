package factsforfalk.theprojectx;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
	ArrayList<ShoppingList> shoppingLists;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recylcer_view);

		// setContentView(R.layout.activity_users);
		// Lookup the recyclerview in activity layout
		RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

		// Initialize markets
		shoppingLists = ShoppingList.createShoppingLists();
		// Create adapter passing in the sample user data
		MarketAdapter adapter = new MarketAdapter(this, shoppingLists);
		// Attach the adapter to the recyclerview to populate items
		rvContacts.setAdapter(adapter);
		// Set layout manager to position the items
		rvContacts.setLayoutManager(new LinearLayoutManager(this));
		// That's all!

		FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
		floatingActionButton.setOnClickListener((new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, ShoppingListAdd.class);
				startActivity(intent);
			}
		}));
	}

}
