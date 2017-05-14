package factsforfalk.theprojectx;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShoppingListAdd extends AppCompatActivity
{
	EditText editTextName;
	EditText editTextDescription;
    Button buttonSubmitListConfig;
	Intent intentSubmitShoppinglist;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list_add);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		intentSubmitShoppinglist = new Intent(ShoppingListAdd.this, MainActivity.class);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        buttonSubmitListConfig = (Button) findViewById(R.id.buttonSubmitListConfig);

        buttonSubmitListConfig.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
			if(editTextName.getText().length() < 3) {
				editTextName.setError("Der Name der Liste soll mindestens 3 Zeichen beinhalten.");
			} else {
                intentSubmitShoppinglist.putExtra("listDescription", editTextDescription.getText().length() == 0
                                ? "Keine Beschreibung vorhanden"
                                : editTextDescription.getText().toString());

				intentSubmitShoppinglist.putExtra("listName", editTextName.getText().toString());
                editTextName.setError(null);

                //set result status for intent, that can be read in onActivityResult event
				setResult(Activity.RESULT_OK, intentSubmitShoppinglist);
				finish();
			}
            }
        }));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			// app icon in action bar clicked; goto parent activity.
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
