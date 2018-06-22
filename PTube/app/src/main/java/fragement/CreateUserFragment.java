package fragement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Interfaces.InputListerner;
import mylocker.bk.com.ptube.R;

public class CreateUserFragment extends Fragment implements InputListerner{

    public CreateUserFragment() {
    }
    public static CreateUserFragment newInstance() {
        CreateUserFragment fragment = new CreateUserFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_user, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InputFragment inputFragment = (InputFragment) this.getChildFragmentManager().findFragmentById(R.id.create_input_fragement);
        inputFragment.setOnClickListner(this);
    }
    @Override
    public void onGetInput(String input) {
        Log.d("BevinListerner",input);
    }
}