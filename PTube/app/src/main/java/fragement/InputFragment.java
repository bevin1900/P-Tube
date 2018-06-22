package fragement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import Interfaces.InputListerner;
import mylocker.bk.com.ptube.R;

public class InputFragment extends Fragment implements View.OnClickListener {

    private InputListerner listerner;

    public InputFragment() {
    }
    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button0).setOnClickListener(this);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        view.findViewById(R.id.button4).setOnClickListener(this);
        view.findViewById(R.id.button5).setOnClickListener(this);
        view.findViewById(R.id.button6).setOnClickListener(this);
        view.findViewById(R.id.button7).setOnClickListener(this);
        view.findViewById(R.id.button8).setOnClickListener(this);
        view.findViewById(R.id.button9).setOnClickListener(this);
        view.findViewById(R.id.buttondel).setOnClickListener(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                this.listerner.onGetInput(getString(R.string.number_0));
                break;
            case R.id.button1:
                this.listerner.onGetInput(getString(R.string.number_1));
                break;
            case R.id.button2:
                this.listerner.onGetInput(getString(R.string.number_2));
                break;
            case R.id.button3:
                this.listerner.onGetInput(getString(R.string.number_3));
                break;
            case R.id.button4:
                this.listerner.onGetInput(getString(R.string.number_4));
                break;
            case R.id.button5:
                this.listerner.onGetInput(getString(R.string.number_5));
                break;
            case R.id.button6:
                this.listerner.onGetInput(getString(R.string.number_6));
                break;
            case R.id.button7:
                this.listerner.onGetInput(getString(R.string.number_7));
                break;
            case R.id.button8:
                this.listerner.onGetInput(getString(R.string.number_8));
                break;
            case R.id.button9:
                this.listerner.onGetInput(getString(R.string.number_9));
                break;
            case R.id.buttondel:
                this.listerner.onGetInput(getString(R.string.number_del));
                break;
        }
    }
    public void setOnClickListner(InputListerner listerner){
        this.listerner = listerner;
    }
}
