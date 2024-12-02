package com.example.thulailancuoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {

    private List<SanPham> sanPhamList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTenSanPham, txtGiaBan, txtMau, txtMoTa;
        public ImageView imgSanPham;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTenSanPham = itemView.findViewById(R.id.txtTenSanPham);
            txtGiaBan = itemView.findViewById(R.id.txtGiaBan);
            txtMau = itemView.findViewById(R.id.txtMau);
            txtMoTa = itemView.findViewById(R.id.txtMoTa);
            imgSanPham = itemView.findViewById(R.id.imgSanPham);
        }
    }

    public SanPhamAdapter(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTenSanPham.setText(sanPham.getTenSanPham());
        holder.txtGiaBan.setText(String.valueOf(sanPham.getGiaBan()));
        holder.txtMau.setText(sanPham.getMau());
        holder.txtMoTa.setText(sanPham.getMoTa());

        // Dùng Picasso để tải hình ảnh từ URL lấy từ cơ sở dữ liệu
        String hinhAnhUrl = "http://10.0.2.2:8081/banquanao/img/" +sanPham.getHinhAnh();  // Đây là URL của hình ảnh
        Picasso.get()
                .load(hinhAnhUrl)  // Đặt URL của hình ảnh từ cơ sở dữ liệu
                .into(holder.imgSanPham);  // Gán hình ảnh vào ImageView
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
}
