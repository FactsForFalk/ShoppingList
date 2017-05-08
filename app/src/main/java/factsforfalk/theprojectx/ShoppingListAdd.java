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


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping_list_add);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        buttonSubmitListConfig = (Button) findViewById(R.id.buttonSubmitListConfig);

        buttonSubmitListConfig.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*Intent intent = new Intent(ShoppingListAdd.this, ShoppingListAdd.class);
                startActivity(intent);*/

                Intent intent = new Intent(ShoppingListAdd.this, MainActivity.class);
                intent.putExtra("listName", editTextName.getText().toString());
                intent.putExtra("listDescription", editTextDescription.getText().toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
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
