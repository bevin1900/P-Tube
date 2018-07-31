package customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import Interfaces.InputListerner;
import Interfaces.PinBoxListerner;;
import enums.PinBoxState;
import mylocker.bk.com.ptube.R;

public class PinBox extends LinearLayout implements InputListerner {

    private ImageView passImageView1;
    private ImageView passImageView2;
    private ImageView passImageView3;
    private ImageView passImageView4;
    private String    text = "";

    private PinBoxListerner listerner;

    public PinBox(Context context) {
        super(context);
    }

    public PinBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PinBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.passImageView1 = this.findViewById(R.id.passImage1);
        this.passImageView2 = this.findViewById(R.id.passImage2);
        this.passImageView3 = this.findViewById(R.id.passImage3);
        this.passImageView4 = this.findViewById(R.id.passImage4);
    }

    public String getText() {
        return text;
    }

    public void setOnPinBoxListner(PinBoxListerner listerner){
        this.listerner = listerner;
    }

    @Override
    public void onGetInput(String input) {
        if (input.equals(getResources().getString(R.string.number_del))) {
            if (text.length() == 0){
                this.callListener(PinBoxState.discard);
            }
            else{
                text = text.substring(0,text.length()-1);
                this.callListener(PinBoxState.change);
            }
        }
        else{
            if (text.length() == 4){
                this.callListener(PinBoxState.discard);
            }
            else{
                text = text+input;
                this.callListener(text.length()==4?PinBoxState.varify:PinBoxState.change);
            }
        }
    }
    private void callListener(PinBoxState pinBoxState){

        switch (text.length()){
            case 0:
                this.passImageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                break;
            case 1:
                this.passImageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                break;
            case 2:
                this.passImageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                this.passImageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                break;
            case 3:
                this.passImageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_empty));
                break;
            default:
                this.passImageView1.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView3.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                this.passImageView4.setImageDrawable(getResources().getDrawable(R.drawable.ic_pass_fill));
                break;
        }
        this.listerner.pinBox(this,pinBoxState);
    }
}
