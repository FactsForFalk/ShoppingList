package factsforfalk.theprojectx;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recylcer_view);

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
