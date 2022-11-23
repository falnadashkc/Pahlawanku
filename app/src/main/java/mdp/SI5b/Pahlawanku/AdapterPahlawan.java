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

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.VHPahlawan> {
    private ArrayList<ModelPahlawan> dataPahlawan;
    private Context ctx;

    public AdapterPahlawan(ArrayList<ModelPahlawan> dataPahlawan, Context ctx) {
        this.dataPahlawan = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VHPahlawan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new VHPahlawan(VW);
    }

    @Override
    public void onBindViewHolder(@NonNull VHPahlawan holder, int position) {
        ModelPahlawan pahlawan = dataPahlawan.get(position);

        holder.tvNama.setText(pahlawan.getNama());
        holder.tvTentang.setText(pahlawan.getTentang());

        Glide
                .with(ctx)
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama, xTentang, xfoto;
                xNama = pahlawan.getNama();
                xTentang = pahlawan.getTentang();
                xfoto = pahlawan.getFoto();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xfoto);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public class VHPahlawan extends RecyclerView.ViewHolder {
        TextView tvNama, tvTentang;
        ImageView ivFoto;

        public VHPahlawan(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivFoto = itemView.findViewById(R.id.iv_foto);
        }
    }
}
