package fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    Boolean detectVisibleBo = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {


        initailView();
        initailData();
        initailEvnet();


        return inflater.inflate(bindlayout(),container,false);
    }

    protected abstract Integer bindlayout();

    protected abstract void initailView();

    protected abstract void initailData();

    protected void initailEvnet() { }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        detectVisibleBo = menuVisible;

    }

    protected abstract void handler();

}
