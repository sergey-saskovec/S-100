package com.example.hp.s_100.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.s_100.R;

public class SupportFragment extends Fragment {


    public SupportFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout relativelayout = (RelativeLayout) inflater.inflate(R.layout.fragment_support, container, false);
        final Spinner theme_support = (Spinner) relativelayout.findViewById(R.id.theme_support);
        final EditText suggestion = (EditText) relativelayout.findViewById(R.id.suggestion);
        final EditText support_e_mail = (EditText) relativelayout.findViewById(R.id.support_e_mail);
        Button btn_support = (Button) relativelayout.findViewById(R.id.btn_support);

        btn_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (suggestion.getText().length() == 0 || support_e_mail.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Заполните все поля", Toast.LENGTH_LONG).show();
                } else {


                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    // Кому
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[]{getString(R.string.send_email_support)});
                    // Зачем
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                            theme_support.getSelectedItem().toString());
                    // О чём
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            suggestion.getText().toString() + "\nОтправитель: " + support_e_mail.getText().toString());

                    getActivity().startActivity(Intent.createChooser(emailIntent,
                            "Отправка письма..."));

                }
            }
        });

        return relativelayout;

    }

}
