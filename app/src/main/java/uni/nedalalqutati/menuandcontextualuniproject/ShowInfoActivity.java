package uni.nedalalqutati.menuandcontextualuniproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ShowInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        String page = getIntent().getExtras().getString("page");
        switch (page) {
            case "name":
                ft.replace(R.id.frameLayout, new NameFragment());
                break;
            case "number":
                ft.replace(R.id.frameLayout, new NumberFragment());

                break;
            case "specialization":
                ft.replace(R.id.frameLayout, new SpecializationFragment());

                break;
        }
        ft.commit();


    }
}