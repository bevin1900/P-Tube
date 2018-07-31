package fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mylocker.bk.com.ptube.R;

public class LoginUserFragment extends Fragment {

    public LoginUserFragment() {
    }
    public static LoginUserFragment newInstance() {
        LoginUserFragment fragment = new LoginUserFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_user, container, false);
    }
}