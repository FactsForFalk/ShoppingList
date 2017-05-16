package factsforfalk.theprojectx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>
{
    private static final String TAG = "ViewHolder";

	// Store a member variable for the shopping-lists
	private List<ShoppingList> mShoppingLists;
	// Store the context for easy access
	private Context mContext;

	// Pass in the contact array into the constructor
	public ShoppingListAdapter(Context context, List<ShoppingList> shoppingLists )
	{
		mShoppingLists = shoppingLists;
		mContext = context;
	}

	// Easy access to the context object in the recyclerview
	private Context getContext()
	{
		return mContext;
	}

	// Provide a direct reference to each of the views within a data item
	// Used to cache the views within the item layout for fast access
	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
	{
		// Your holder should contain a member variable
		// for any view that will be set as you render a row
		public TextView nameTextView;
		public TextView descriptionTextView;

        private Context context;

		// We also create a constructor that accepts the entire item row
		// and does the view lookups to find each subview
		public ViewHolder( View itemView )
		{
			// Stores the itemView in a public final member variable that can be used
			// to access the context from any ViewHolder instance.
			super(itemView);

            itemView.setOnClickListener(this);
			itemView.setOnLongClickListener(this);

			nameTextView = (TextView) itemView.findViewById(R.id.shoppinglist_name);
            descriptionTextView = (TextView) itemView.findViewById(R.id.shoppinglist_description);
		}

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position

            Log.d(TAG, "onClick " + getAdapterPosition() + " ");

            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
				Toast.makeText(view.getContext(), "Click: " + nameTextView.getText(), Toast.LENGTH_SHORT).show();
            }
        }

		@Override
		public boolean onLongClick(View view) {
            Log.d(TAG, "onLongClick " + getAdapterPosition() + " ");
			Toast.makeText(view.getContext(), "LongClick: " + nameTextView.getText(), Toast.LENGTH_SHORT).show();
			return true;
		}
	}

	// Usually involves inflating a layout from XML and returning the holder
	@Override
	public ShoppingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		Context context = parent.getContext();
		LayoutInflater inflater = LayoutInflater.from(context);

		// Inflate the custom layout
		View shoppingListItemView = inflater.inflate(R.layout.item_shoppinglist, parent, false);

		// Return a new holder instance
		return new ViewHolder(shoppingListItemView);
	}

	// Involves populating data into the item through holder
	@Override
	public void onBindViewHolder(ShoppingListAdapter.ViewHolder viewHolder, int position)
	{
		// Get the data model based on position
		ShoppingList shoppingList = mShoppingLists.get(position);

		// Set item views based on your views and data model
		TextView textViewName = viewHolder.nameTextView;
        textViewName.setText(shoppingList.getName());

        TextView textViewDescription = viewHolder.descriptionTextView;
        textViewDescription.setText(shoppingList.getDescription());
	}

	// Returns the total count of items in the list
	@Override
	public int getItemCount()
	{
		return mShoppingLists.size();
	}
}
