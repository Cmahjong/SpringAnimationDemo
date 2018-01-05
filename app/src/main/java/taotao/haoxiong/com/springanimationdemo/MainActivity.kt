package taotao.haoxiong.com.springanimationdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val springAnimationX = SpringAnimation(img, DynamicAnimation.TRANSLATION_X)
        val springAnimationY = SpringAnimation(img, DynamicAnimation.TRANSLATION_Y)
        val springAnimationScaleX = SpringAnimation(img, DynamicAnimation.SCALE_X)


        springAnimationY.setStartVelocity(5000f)//初速度
        springAnimationX.setStartVelocity(5000f)
        springAnimationScaleX.setStartVelocity(10f)
//        springAnimationY.setMaxValue(700f)//最大值（设置动画的最大值。动画不会超过它们的最大值。 当达到最大值时，动画是否会结束）
//        springAnimationX.setMaxValue(700f)//最大值（设置动画的最小值。动画不会超出它们的最小值。 当达到最小值时，动画是否会结束）
//
//        springAnimationY.setMinValue(0f)//最小值（设置动画的最小值。动画不会超出它们的最小值。 当达到最小值时，动画是否会结束）
//        springAnimationX.setMinValue(0f)//最小值（设置动画的最小值。动画不会超出它们的最小值。 当达到最小值时，动画是否会结束）
//        springAnimationScaleX.addUpdateListener { animation, value, velocity ->
//            springAnimationScaleX.
//        }
        val force = SpringForce(100f)//最终位置(要在设置的最大值和最小值中间)
        val force1 = SpringForce(1f)//最终位置(SCALE最终缩放的倍数（0-1）)
        force.stiffness = SpringForce.STIFFNESS_VERY_LOW //刚度 刚度越小弹性越好
        force.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY //阻尼系数 越小弹性越好

        springAnimationY.spring = force
        springAnimationX.spring = force
        springAnimationScaleX.spring = force1

        buttom.setOnClickListener {
            //            springAnimationY.cancel()
//            springAnimationY.setStartValue(0f)//初始值(要在设置的最大值和最小值中间)
//            springAnimationY.start()
//
//            springAnimationX.cancel()
//            springAnimationX.setStartValue(0f)//初始值(要在设置的最大值和最小值中间)
//            springAnimationX.start()

            springAnimationScaleX.cancel()
            springAnimationScaleX.setStartValue(0f)//初始值(要在设置的最大值和最小值中间)
            springAnimationScaleX.start()

        }
        buttom1.setOnClickListener {
            startActivity(Intent(this, ScaleActivity::class.java))

        }
        buttom2.setOnClickListener {
            startActivity(Intent(this, AlphaActivity::class.java))
        }
        buttom3.setOnClickListener {
            startActivity(Intent(this, RotationActivity::class.java))
        }
    }
}
