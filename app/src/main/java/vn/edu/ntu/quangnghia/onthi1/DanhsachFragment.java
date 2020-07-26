package vn.edu.ntu.quangnghia.onthi1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.controller.IThongtinController;
import vn.edu.ntu.quangnghia.model.Thongtin;

public class DanhsachFragment extends Fragment {
    List<Thongtin> listthongtins = new ArrayList<>();
    NavController navController;
    IThongtinController controller;
    RecyclerView rvlistthongtin;
    ThongtinAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danhsach, container, false);
        addViews(view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void addViews(View view) {
        rvlistthongtin = view.findViewById(R.id.rvlistthongtin);
        controller = (IThongtinController) ((MainActivity)getActivity()).getApplication();
        listthongtins = controller.getAllThongtin();
        adapter = new ThongtinAdapter(listthongtins);

        rvlistthongtin.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvlistthongtin.setAdapter(adapter);

        navController = NavHostFragment.findNavController(DanhsachFragment.this);
        ((MainActivity)getActivity()).navController = navController;
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public class thongtinViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPhone,txtBirthday,txtGioHoc,txtLoai,txtGio;
        public thongtinViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtBirthday = itemView.findViewById(R.id.txtBirthday);
            txtLoai = itemView.findViewById(R.id.txtLoai);
            txtGioHoc = itemView.findViewById(R.id.txtGioHoc);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtGio = itemView.findViewById(R.id.txtGio);
        }
        public void bind(Thongtin thongtin)
        {
            txtName.setText("Chúc mừng bạn: " + thongtin.getName());
            txtBirthday.setText("Sinh ngày: "+thongtin.getBirthday());
            txtLoai.setText("Đã đăng ký thành công khóa học: \n"+thongtin.getLoai());
            txtGio.setText("Vào lúc:"+thongtin.getGio());
            txtGioHoc.setText("Giờ học: \n"+thongtin.getGioHoc());
            txtPhone.setText("Chúng tôi sẽ liên lạc với bạn theo SĐT: \n"+thongtin.getPhone());
        }
    }

    public class ThongtinAdapter extends RecyclerView.Adapter<thongtinViewHolder>
    {
        List<Thongtin> listthongtins = new ArrayList<>();

        public ThongtinAdapter(List<Thongtin> listthongtins) {
            this.listthongtins = listthongtins;
        }

        @NonNull
        @Override
        public thongtinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.thongtin,parent,false);
            return new thongtinViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull thongtinViewHolder holder, int position) {
            holder.bind(listthongtins.get(position));
        }

        @Override
        public int getItemCount() {
            return listthongtins.size();
        }
    }
}