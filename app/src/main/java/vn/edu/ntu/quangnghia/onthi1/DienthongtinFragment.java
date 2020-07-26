package vn.edu.ntu.quangnghia.onthi1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import vn.edu.ntu.quangnghia.controller.IThongtinController;
import vn.edu.ntu.quangnghia.model.Thongtin;


public class DienthongtinFragment extends Fragment {
    NavController navController;
    IThongtinController controller;
    EditText edtName;
    EditText edtBirthday;
    ImageView imvDate;
    EditText edtPhone;
    EditText edtAddress;
    RadioButton rbSang;
    RadioButton rbChieu;
    RadioButton rbToi;
    RadioGroup rdgGioHoc;
    Spinner spinner1;
    Button btnDK;
    Button btnXemDanhSach;
    String loai;
    EditText edtTime;
    ImageView imvTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dienthongtin, container, false);
        addViews(view);
        getdata();
        return view;
    }

    private void getdata() {
        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog.OnTimeSetListener setListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(hourOfDay)
                                .append(":")
                                .append(minute);
                        edtTime.setText(builder.toString());
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), setListener,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });
        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtBirthday.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rdgGioHoc.getCheckedRadioButtonId();
                loai = spinner1.getSelectedItem().toString();

                RadioButton radioButton = (RadioButton) rdgGioHoc.findViewById(selectedId);
                Thongtin thongtin = new Thongtin();
                thongtin.setName(edtName.getText().toString());
                thongtin.setBirthday(edtBirthday.getText().toString());
                thongtin.setGio(edtTime.getText().toString());
                thongtin.setGioHoc(radioButton.getText().toString());
                thongtin.setLoai(loai);
                thongtin.setPhone(edtPhone.getText().toString());
                controller.addThongtin(thongtin);
                Toast.makeText(DienthongtinFragment.this.getActivity(),"Đã thêm thành công :" ,Toast.LENGTH_SHORT).show();
            }
        });
        btnXemDanhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_dienthongtinFragment_to_danhsachFragment);
            }
        });
    }

    private void addViews(View view) {
        edtName = view.findViewById(R.id.edtName);
        edtBirthday = view.findViewById(R.id.edtBirthday);
        edtTime = view.findViewById(R.id.edtTime);
        imvDate = view.findViewById(R.id.imvDate);
        imvTime = view.findViewById(R.id.imvTime);
        edtPhone = view.findViewById(R.id.edtPhone);
        edtAddress = view.findViewById(R.id.edtAddress);
        rbSang = view.findViewById(R.id.rbSang);
        rbChieu = view.findViewById(R.id.rbChieu);
        rbToi = view.findViewById(R.id.rbToi);
        rdgGioHoc = view.findViewById(R.id.rdgGioHoc);
        spinner1 = view.findViewById(R.id.spinner1);
        btnDK = view.findViewById(R.id.btnDK);
        btnXemDanhSach = view.findViewById(R.id.btnXemDanhSach);

        controller = (IThongtinController) ((MainActivity)getActivity()).getApplication();
        navController = NavHostFragment.findNavController(DienthongtinFragment.this);
        ((MainActivity)getActivity()).navController = navController;

        final String[] loaidv = new String[]{"Lập trình Java","Lập trình Android","lập trình ASP.NET"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DienthongtinFragment.this.getActivity(), R.layout.support_simple_spinner_dropdown_item,loaidv);
        spinner1.setAdapter(arrayAdapter);
    }
}