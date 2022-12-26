package mdp.SI5b.Pahlawanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelStasiun> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);

        data.addAll(DataStasiun.ambilDataPahlawan());
        tampilDataPahlawan();
    }

    private void  tampilDataPahlawan(){
        AdapterStasiun AP = new AdapterStasiun(data, MainActivity.this);

        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        rvPahlawan.setAdapter(AP);
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