package com.example.newnote;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.newnote.databinding.CreateNewNoteBinding;

import java.security.cert.CRLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CreateNewNote extends Fragment {

    CreateNewNoteBinding binding ;
    ArrayList<String> stringTags = new ArrayList<>();
    ArrayList<String> stringWeeks = new ArrayList<>();
    int demptuTags = 0;
    int demptuweeks = 0;

    public static CreateNewNote newInstance() {

        Bundle args = new Bundle();

        CreateNewNote fragment = new CreateNewNote();

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.create_new_note,container,false);

        binding = DataBindingUtil.inflate(inflater,R.layout.create_new_note,container,false);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Work");
        arrayList.add("Friend");
        arrayList.add("Family");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,arrayList);
        binding.spiner.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);







        binding.etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date();
            }
        });
        binding.etHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Time();
            }
        });

        binding.tvrightTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings = {"Family","Game","Android","VTC","Friend"};
                boolean[] booleans = {false,false,false,false,false};
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Thong bao")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if (b){
                                    Toast.makeText(getContext(),strings[i],Toast.LENGTH_LONG).show();
                                    stringTags.add(strings[i]);
                                    demptuTags++;
                                }
                            }
                        })

                        .setPositiveButton("Oki", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String kstring = "";
                                int dem = 0;
                                for(int k = 0 ; k < stringTags.size();k++){
                                    kstring += stringTags.get(k) ;
                                    dem++;
                                    if(dem <demptuTags){
                                        kstring+=",";
                                    }
                                }
                                binding.tvrightTags.setText(kstring);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        binding.tvRightWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strings = {"MonDay","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                boolean[] booleans = {false,false,false,false,false,false,false};
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Thong bao")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if (b){
                                    Toast.makeText(getContext(),strings[i],Toast.LENGTH_LONG).show();
                                    stringWeeks.add(strings[i]);
                                    demptuweeks++;
                                }
                            }
                        })

                        .setPositiveButton("Oki", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String kstring = "";
                                int dem = 0;
                                for(int k = 0 ; k < stringWeeks.size();k++){
                                    kstring += stringWeeks.get(k) ;
                                    dem++;
                                    if(dem <demptuweeks){
                                        kstring+=",";
                                    }
                                }
                                binding.tvRightWeeks.setText(kstring);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"Click Cancel",Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
        binding.btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tune();
            }
        });



        return  binding.getRoot();
    }

    private void Save(){
        PopupMenu popupMenu = new PopupMenu(getActivity(),binding.btnSave);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.show();

    }
    private void Tune(){
        PopupMenu popupMenu = new PopupMenu(getActivity(),binding.btnTune);
        popupMenu.getMenuInflater().inflate(R.menu.menu_tune, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.id2:
                                String[] stringss = {"Nexus Tune","Winphone tune","Peep tune","Nokia tune","Etc"};
                                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                                       .setSingleChoiceItems(stringss, 0, new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialogInterface, int i) {
                                               Toast.makeText(getContext(),stringss[i],Toast.LENGTH_LONG).show();
                                           }
                                       })


                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getContext(),"Oki",Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(getContext(),"Cancel",Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .create();
                                alertDialog.show();
                        break;
                    case R.id.id1:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();

    }
    private  void Date(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                binding.etDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam,thang , ngay);
        datePickerDialog.show();
    }

    private void Time() {
        Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    calendar.set(0,0,0,i,i1);
                    binding.etHours.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },gio,phut,true);
        timePickerDialog.show();
    }
}
