package kimxu.me.PM;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kimxu on 2017/3/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    AppCompatActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;
    }
}
