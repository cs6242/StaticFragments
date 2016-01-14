package edu.westga.staticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {

    private EditText number1Text;
    private EditText number2Text;

    public interface DataEntryListener {
        void onDataEntered(double number1, double number2);
    }

    private DataEntryListener listener;

    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        this.number1Text = (EditText) theView.findViewById(R.id.editText);
        this.number2Text = (EditText) theView.findViewById(R.id.editText2);

        Button multiplyButton = (Button) theView.findViewById(R.id.button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });

        return theView;
    }

    private void multiplyButtonClicked(View v) {
        double number1 = Double.parseDouble(this.number1Text.getText().toString());
        double number2 = Double.parseDouble(this.number2Text.getText().toString());

        listener.onDataEntered(number1, number2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.listener = (DataEntryListener) context;
    }
}
