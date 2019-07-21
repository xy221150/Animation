package wxy.demo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image;
    private Button alpha,scale,translate,rotate,frame;
    private LinearLayout layout;
    private AnimationDrawable animationDrawable;
    private AlphaAnimation alphaAnimation;
    private ScaleAnimation scaleAnimation;
    private TranslateAnimation translateAnimation;
    private RotateAnimation rotateAnimation;
    private AnimationSet animationSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        initDate();
    }

    private void initDate() {
        alpha.setOnClickListener(this);
        scale.setOnClickListener(this);
        translate.setOnClickListener(this);
        rotate.setOnClickListener(this);
        frame.setOnClickListener(this);
    }

    private void init() {
        animationDrawable=new AnimationDrawable();//帧动画
        animationDrawable.addFrame(getDrawable(R.mipmap.ic_launcher),100);
        animationDrawable.addFrame(getDrawable(R.mipmap.ic_launcher_round),100);
        animationDrawable.setOneShot(false);//循环

        alphaAnimation=new AlphaAnimation(0,1);//渐变

        // fromX 缩放开始x位置,  toX 缩放结束x位置,  fromY 缩放开始y位置,  toY 缩放结束y位置,  pivotX 缩放起点x坐标,  pivotY 缩放起点y坐标
        scaleAnimation=new ScaleAnimation(0,1,0,1,50,50);//缩放

        // fromXDelta 平移开始x位置,  toXDelta 平移结束x位置,  fromYDelta 平移开始y位置,  toYDelta 平移结束y位置
        layout.measure(0,0);
        int ToX=layout.getMeasuredWidth()/2-(layout.getPaddingLeft()+layout.getPaddingRight());//获取LinearLayout一半宽度
        translateAnimation=new TranslateAnimation(0,ToX,0,0);//平移

        // fromDegrees 旋转开始角度,  toDegrees 旋转结束角度,  pivotX 旋转起点x坐标,  pivotY 旋转起点y坐标
        rotateAnimation=new RotateAnimation(0,360,50,50);//旋转

    }

    private void initView() {
        image=findViewById(R.id.image);
        alpha=findViewById(R.id.alpha);
        scale=findViewById(R.id.scale);
        translate=findViewById(R.id.translate);
        rotate=findViewById(R.id.rotate);
        frame=findViewById(R.id.frame);
        layout=findViewById(R.id.layout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alpha:
                animationSet=new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(2000);
                image.startAnimation(animationSet);
                break;
            case R.id.scale:
                animationSet=new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(2000);
                image.startAnimation(animationSet);
                break;
            case R.id.translate:
                animationSet=new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.setDuration(2000);
                image.startAnimation(animationSet);
                break;
            case R.id.rotate:
                animationSet=new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.setDuration(2000);
                image.startAnimation(animationSet);
                break;
            case R.id.frame:
                if (!animationDrawable.isRunning()){
                    image.setBackground(animationDrawable);
                    animationDrawable.start();
                }else{
                    animationDrawable.stop();
                }
                break;
        }
    }
}
