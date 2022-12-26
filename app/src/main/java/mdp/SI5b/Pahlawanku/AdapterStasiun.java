package mdp.SI5b.Pahlawanku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterStasiun extends RecyclerView.Adapter<AdapterStasiun.VHStasiun> {
    private ArrayList<ModelStasiun> dataStasiun;
    private Context ctx;

    public AdapterStasiun(ArrayList<ModelStasiun> dataStasiun, Context ctx) {
        this.dataStasiun = dataStasiun;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VHStasiun onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new VHStasiun(VW);
    }

    @Override
    public void onBindViewHolder(@NonNull VHStasiun holder, int position) {
        ModelStasiun Stasiun = dataStasiun.get(position);

        holder.tvNama.setText(Stasiun.getNama());
        holder.tvTentang.setText(Stasiun.getTentang());
        holder.tvAlamat.setText(Stasiun.getAlamat());
        holder.tvKoordinat.setText(Stasiun.getKoordinat());

        Glide
                .with(ctx)
                .load(Stasiun.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama, xTentang, xfoto, xalamat, xkoordinat;
                xNama = Stasiun.getNama();
                xTentang = Stasiun.getTentang();
                xfoto = Stasiun.getFoto();
                xalamat = Stasiun.getAlamat();
                xkoordinat = Stasiun.getKoordinat();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xfoto);
                kirim.putExtra("xAlamat", xalamat);
                kirim.putExtra("xKoordinat", xkoordinat);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataStasiun.size();
    }

    public class VHStasiun extends RecyclerView.ViewHolder {
        TextView tvNama, tvTentang, tvAlamat, tvKoordinat;
        ImageView ivFoto;

        public VHStasiun(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvKoordinat = itemView.findViewById(R.id.tv_koordinat);

        }
    }
}
