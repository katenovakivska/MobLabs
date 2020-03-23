package com.example.mob2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class OptionsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_options, container, false);
        Button button =  view.findViewById(R.id.get_formula_button);
        // задаем обработчик кнопки

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                RadioButton circle = view.findViewById(R.id.circle);
                RadioButton rectangle = view.findViewById(R.id.rectangle);
                CheckBox perimeter = view.findViewById(R.id.perimeter);
                CheckBox square = view.findViewById(R.id.square);

                if (!(perimeter.isChecked()) && !(square.isChecked())){

                    Toast myToast = Toast.makeText(view.getContext(), "Select almost one measurement", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else if (rectangle.isChecked() || circle.isChecked() || (rectangle.isChecked() && circle.isChecked())) {
                    String result = "";
                    result += "Selected measurement: \n";
                    if (perimeter.isChecked() && circle.isChecked()) {
                        result += "P = 2*Pi*R\n";
                    }
                    if (perimeter.isChecked() && rectangle.isChecked()) {
                        result += "P = 2*(a + b)\n";
                    }
                    if (square.isChecked() && rectangle.isChecked()) {
                        result += "S = a*b\n";
                    }
                    if (square.isChecked() && circle.isChecked()) {
                        result += "S = Pi*R^2\n";
                    }
                    updateTextBox(result);
                }
                    else{
                        Toast myToas = Toast.makeText(view.getContext(), "Select more..", Toast.LENGTH_SHORT);
                        myToas.show();
                    }

                }


        });
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    private void updateTextBox(String result) {

        // Посылаем данные Activity
        mListener.onFragmentInteraction(result);
    }
}
