package vn.edu.ntu.quangnghia.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.model.Thongtin;

public class ThongtinController  extends Application implements IThongtinController {
    List<Thongtin> listthongtins = new ArrayList<>();

    public ThongtinController()
    {
        listthongtins.add(new Thongtin("Nguyễn Hồng Phấn","11/12/2020","0772465715","Sáng","Lập trình Android","07:22"));
        listthongtins.add(new Thongtin("Nguyễn Thanh Bình","12/12/2020","0772465715","Chiều","Lập trình Java","11:12"));
    }

    @Override
    public List<Thongtin> getAllThongtin() {
        return listthongtins;
    }

    @Override
    public void addThongtin(Thongtin thongtin) {
        listthongtins.add(thongtin);
    }
}
