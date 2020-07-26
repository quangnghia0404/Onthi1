package vn.edu.ntu.quangnghia.model;

public class Thongtin {
    String Name;
    String Birthday;
    String Phone;
    String GioHoc;
    String Loai;
    String gio;

    public Thongtin() {
    }

    public Thongtin(String name, String birthday, String phone, String gioHoc, String loai, String gio) {
        Name = name;
        Birthday = birthday;
        Phone = phone;
        GioHoc = gioHoc;
        Loai = loai;
        this.gio = gio;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        this.Birthday = birthday;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getGioHoc() {
        return GioHoc;
    }

    public void setGioHoc(String gioHoc) {
        this.GioHoc = gioHoc;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        this.Loai = loai;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }
}
