package com.example.recycleviewanimatorsdemo.emun;

import android.content.Context;

import com.example.recycleviewanimatorsdemo.adapter.MainAdapter;
import com.example.recycleviewanimatorsdemo.bean.DataUtils;

import java.util.ArrayList;
import java.util.Arrays;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

/**
 * author：Admin
 * date：2017/11/2119:43
 * 编程使我快乐
 */

public enum AdapterType {
    AlphaIn {
        @Override public AnimationAdapter get(Context context) {
            MainAdapter adapter = new MainAdapter(context, new ArrayList<>(Arrays.asList(DataUtils.data)));
            return new AlphaInAnimationAdapter(adapter);
        }
    },
    ScaleIn {
        @Override public AnimationAdapter get(Context context) {
            MainAdapter adapter = new MainAdapter(context, new ArrayList<>(Arrays.asList(DataUtils.data)));
            return new ScaleInAnimationAdapter(adapter);
        }
    },
    SlideInBottom {
        @Override public AnimationAdapter get(Context context) {
            MainAdapter adapter = new MainAdapter(context, new ArrayList<>(Arrays.asList(DataUtils.data)));
            return new SlideInBottomAnimationAdapter(adapter);
        }
    },
    SlideInLeft {
        @Override public AnimationAdapter get(Context context) {
            MainAdapter adapter = new MainAdapter(context, new ArrayList<>(Arrays.asList(DataUtils.data)));
            return new SlideInLeftAnimationAdapter(adapter);
        }
    },
    SlideInRight {
        @Override public AnimationAdapter get(Context context) {
            MainAdapter adapter = new MainAdapter(context, new ArrayList<>(Arrays.asList(DataUtils.data)));
            return new SlideInRightAnimationAdapter(adapter);
        }
    };

    public abstract AnimationAdapter get(Context context);
}
