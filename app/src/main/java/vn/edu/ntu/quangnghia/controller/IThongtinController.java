package vn.edu.ntu.quangnghia.controller;

import java.util.List;

import vn.edu.ntu.quangnghia.model.Thongtin;

public interface IThongtinController {
    public List<Thongtin> getAllThongtin();
    public void addThongtin(Thongtin thongtin);
}
