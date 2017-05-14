package factsforfalk.theprojectx;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvShoppingLists;
    ShoppingListAdapter adapter;
    ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylcer_view);

        // setContentView(R.layout.activity_users);
        // Lookup the recyclerview in activity layout
        rvShoppingLists = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize shoppingLists
        shoppingLists = ShoppingList.createShoppingLists();
        // Create adapter passing in the sample user data
        adapter = new ShoppingListAdapter(this, shoppingLists);
        // Attach the adapter to the recyclerview to populate items
        rvShoppingLists.setAdapter(adapter);
        // Set layout manager to position the items
        rvShoppingLists.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingListAdd.class);
                startActivityForResult(intent, 1); //1: code for adding new shoppinglist
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) { //1: code for adding new shoppinglist
            if (resultCode == RESULT_OK) { //user filled out and submitted form
                String listName = data.getStringExtra("listName");
                String listDescription = data.getStringExtra("listDescription");

                shoppingLists.add(new ShoppingList(0, listName, listDescription, null, null));

                //notify any registered observers that the item reflected at position has been newly inserted,
                //so that the RecyclerView gets updated
                adapter.notifyItemInserted(shoppingLists.size() +1);
            } else {
                System.out.println("result of Intent is not RESULT_OK");
            }
        }
    }
}
