package fragement;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Interfaces.InputListerner;
import Interfaces.PinBoxListerner;
import customView.PinBox;
import enums.PinBoxState;
import mylocker.bk.com.ptube.R;

public class CreateUserFragment extends Fragment implements PinBoxListerner {

    private InputFragment  inputFragment;
    private LinearLayout   scroolLayout;

    private LinearLayout    enterLayout;
    private PinBox          enterPinBox;

    private LinearLayout    confirmLayout;
    private PinBox          confirmPinBox;

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

        inputFragment   =   (InputFragment) this.getChildFragmentManager().findFragmentById(R.id.create_input_fragement);
        scroolLayout    =   view.findViewById(R.id.linear_layout_scrool);

        enterLayout     =   view.findViewById(R.id.linear_layout_1);
        enterPinBox     =   view.findViewById(R.id.enter_pin_box);

        confirmLayout   =   view.findViewById(R.id.linear_layout_2);
        confirmPinBox   =   view.findViewById(R.id.confirm_pin_box);

        enterPinBox.setOnPinBoxListner(this);
        confirmPinBox.setOnPinBoxListner(this);

        inputFragment.setOnClickListner(enterPinBox);




        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    scroolLayout.setTranslationX(scroolLayout.getMeasuredWidth()/4);
                }
            });
        }
    }

    @Override
    public void pinBox(PinBox pinBox, PinBoxState pinBoxState) {

        if (pinBoxState == PinBoxState.varify){
            if (pinBox.equals(enterPinBox)){

                ObjectAnimator animAX = ObjectAnimator.ofFloat(scroolLayout, "translationX", -scroolLayout.getWidth()/4);
                ObjectAnimator animAA = ObjectAnimator.ofFloat(enterLayout, "alpha", 0);
                ObjectAnimator animBA = ObjectAnimator.ofFloat(confirmLayout, "alpha", 1);

                AnimatorSet allAnimation = new AnimatorSet();
                allAnimation.playTogether(new ObjectAnimator[]{animAX,animAA,animBA});
                allAnimation.setDuration(1000);
                allAnimation.start();
                inputFragment.setOnClickListner(confirmPinBox);
            }
            else{

            }
        }
    }
}