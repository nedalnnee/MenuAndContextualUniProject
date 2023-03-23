package uni.nedalalqutati.menuandcontextualuniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
    }

    private void initListView() {
        list = findViewById(R.id.list_view);
        registerForContextMenu(list);
        list.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItemText = parent.getItemAtPosition(position).toString();

        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView listItem = (TextView) (info.targetView);
        String s = listItem.getText().toString();

        if (item.getItemId() == R.id.show_context) {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.share_context)
            Toast.makeText(getApplicationContext(), "SHARE ME", Toast.LENGTH_SHORT).show();

        return true;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (R.id.option_name == id) {

            Intent intent = new Intent(this, ShowInfoActivity.class);
            intent.putExtra("page", "name");
            startActivity(intent);
        } else if ((R.id.option_number == id)) {
            Intent intent = new Intent(this, ShowInfoActivity.class);
            intent.putExtra("page", "number");
            startActivity(intent);
        } else if ((R.id.option_specialization == id)) {
            Intent intent = new Intent(this, ShowInfoActivity.class);
            intent.putExtra("page", "specialization");
            startActivity(intent);
        } else if ((R.id.option_logout == id)) {
            System.exit(0);
        }

        return true;
    }

}