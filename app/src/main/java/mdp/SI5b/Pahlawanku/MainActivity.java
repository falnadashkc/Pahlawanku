package mdp.SI5b.Pahlawanku;

import static mdp.SI5b.Pahlawanku.R.color.lagoon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    Button btnlokasi;
    private RecyclerView rvStasiun;
    private ArrayList<ModelStasiun> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnlokasi = findViewById(R.id.btn_lokasi);
        rvStasiun = findViewById(R.id.rv_stasiun);
        rvStasiun.setHasFixedSize(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(lagoon)));

        data.addAll(DataStasiun.ambilDataStasiun());
        tampilDataStasiun();
    }

    private void  tampilDataStasiun(){
        AdapterStasiun AP = new AdapterStasiun(data, MainActivity.this);

        rvStasiun.setLayoutManager(new LinearLayoutManager(this));
        rvStasiun.setAdapter(AP);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_about){
            Intent about = new Intent(MainActivity.this, About.class);
            startActivity(about);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}