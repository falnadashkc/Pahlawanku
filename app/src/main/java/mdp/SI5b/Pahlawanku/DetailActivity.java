package mdp.SI5b.Pahlawanku;

import static mdp.SI5b.Pahlawanku.R.color.lagoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvNama, tvTentang, tvAlamat, tvKoordinat;
    private String yNama, yTentang, yFoto, yAlamat, yKoordinat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(lagoon)));

        ivFoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvKoordinat = findViewById(R.id.tv_koordinat);

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        yTentang = terima.getStringExtra("xTentang");
        yFoto = terima.getStringExtra("xFoto");
        yAlamat = terima.getStringExtra("xAlamat");
        yKoordinat = terima.getStringExtra("xKoordinat");

        tvNama.setText(yNama);
        tvTentang.setText(yTentang);
        tvAlamat.setText(yAlamat);
        tvKoordinat.setText(yKoordinat);
        Glide.with(DetailActivity.this). load(yFoto).into(ivFoto);



    }
}