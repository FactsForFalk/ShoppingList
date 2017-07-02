package factsforfalk.theprojectx.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import factsforfalk.theprojectx.R;
import factsforfalk.theprojectx.models.ShoppingList;
import factsforfalk.theprojectx.activity.GoodsActivity;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private ArrayList<ShoppingList> selectedItems = new ArrayList<ShoppingList>();
    // Store a member variable for the shopping-lists
    private List<ShoppingList> mShoppingLists;
    // Store the context for easy access
    private Context mContext;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private static final String TAG = "ViewHolder";
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView descriptionTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            nameTextView = (TextView) itemView.findViewById(R.id.shoppinglist_name);
            descriptionTextView = (TextView) itemView.findViewById(R.id.shoppinglist_description);
        }

        private boolean multiSelect = true;

        void selectItem(int item, View v) {
            if (multiSelect) {
                if (selectedItems.contains(mShoppingLists.get(item))) {
                    selectedItems.remove(mShoppingLists.get(item));
                    v.setBackgroundColor(Color.WHITE);
                } else {
                    selectedItems.add(mShoppingLists.get(item));
                    v.setBackgroundColor(Color.LTGRAY);
                }
            }
        }

        @Override
        public void onClick(View v) {
            getContext().startActivity(new Intent(getContext(), GoodsActivity.class));
            Log.d(TAG, "onClick " + getAdapterPosition());
        }

        @Override
        public boolean onLongClick(final View v) {
            selectItem(getAdapterPosition(), v);
            v.startActionMode(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.action_mode, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    for (ShoppingList intItem : selectedItems) {
                        mShoppingLists.remove(intItem);
                    }
                    selectedItems.clear();
                    mode.finish();
                    return true;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                }
            });
            return true;
        }
    }

    // Pass in the contact array into the constructor
    public ShoppingListAdapter(Context context, List<ShoppingList> shoppingLists) {
        mShoppingLists = shoppingLists;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        final View shoppingListItemView = inflater.inflate(R.layout.item_shoppinglist, parent, false);
        // Return a new holder instance
        return new ViewHolder(shoppingListItemView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        ShoppingList shoppingList = mShoppingLists.get(position);

        // Set item views based on your views and data model
        TextView textViewName = viewHolder.nameTextView;
        textViewName.setText(shoppingList.getName());
        TextView textViewDescription = viewHolder.descriptionTextView;
        textViewDescription.setText(shoppingList.getDescription().length() == 0 ? "Keine Beschreibung vorhanden."
                : shoppingList.getDescription());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mShoppingLists.size();
    }

    public void addItem(ShoppingList shoppingList) {
        mShoppingLists.add(shoppingList);
        notifyItemInserted(mShoppingLists.size());
    }

    public void removeItem(int position) {
        mShoppingLists.remove(position);
        notifyItemRemoved(position);
    }
}
