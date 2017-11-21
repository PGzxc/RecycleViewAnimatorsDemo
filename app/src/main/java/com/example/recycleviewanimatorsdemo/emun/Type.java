package com.example.recycleviewanimatorsdemo.emun;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInRightYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * author：Admin
 * date：2017/11/2118:19
 * 编程使我快乐
 */

public enum Type {
    FadeIn(new FadeInAnimator()),
    FadeInDown(new FadeInDownAnimator()),
    FadeInUp(new FadeInUpAnimator()),
    FadeInLeft(new FadeInLeftAnimator()),
    FadeInRight(new FadeInRightAnimator()),
    Landing(new LandingAnimator()),
    ScaleIn(new ScaleInAnimator()),
    ScaleInTop(new ScaleInTopAnimator()),
    ScaleInBottom(new ScaleInBottomAnimator()),
    ScaleInLeft(new ScaleInLeftAnimator()),
    ScaleInRight(new ScaleInRightAnimator()),
    FlipInTopX(new FlipInTopXAnimator()),
    FlipInBottomX(new FlipInBottomXAnimator()),
    FlipInLeftY(new FlipInLeftYAnimator()),
    FlipInRightY(new FlipInRightYAnimator()),
    SlideInLeft(new SlideInLeftAnimator()),
    SlideInRight(new SlideInRightAnimator()),
    SlideInDown(new SlideInDownAnimator()),
    SlideInUp(new SlideInUpAnimator()),
    OvershootInRight(new OvershootInRightAnimator(1.0f)),
    OvershootInLeft(new OvershootInLeftAnimator(1.0f));


    private BaseItemAnimator mAnimator;

    Type(BaseItemAnimator animator) {
        mAnimator = animator;
    }

    public BaseItemAnimator getAnimator() {
        return mAnimator;
    }
}
