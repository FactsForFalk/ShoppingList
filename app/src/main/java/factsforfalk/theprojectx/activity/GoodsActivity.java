package factsforfalk.theprojectx.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import factsforfalk.theprojectx.R;

public class GoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.recylcer_view);
        RecyclerView rvShoppingLists;
        rvShoppingLists = (RecyclerView) findViewById(R.id.rvContacts);

    }

}
