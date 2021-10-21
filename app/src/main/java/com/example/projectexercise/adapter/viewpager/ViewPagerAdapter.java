package com.example.projectexercise.adapter.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projectexercise.ui.functionpage.ArrangeFragment;
import com.example.projectexercise.ui.functionpage.MessageFragment;
import com.example.projectexercise.ui.functionpage.ProcessFragment;


public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :
                return new ArrangeFragment();
            case 1:
                return new ProcessFragment();
            default:
                return new MessageFragment();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}