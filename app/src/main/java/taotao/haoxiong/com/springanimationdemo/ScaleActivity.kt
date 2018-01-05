package taotao.haoxiong.com.springanimationdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import kotlinx.android.synthetic.main.activity_scale.*

class ScaleActivity : AppCompatActivity() {
    val scaleAnimationX: SpringAnimation by lazy {
        SpringAnimation(img, DynamicAnimation.SCALE_X)
    }
    val scaleAnimationY: SpringAnimation by lazy {
        SpringAnimation(img, DynamicAnimation.SCALE_Y)
    }
    val force: SpringForce by lazy {
        SpringForce()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scale)

        force.stiffness = SpringForce.STIFFNESS_VERY_LOW //刚度 刚度越小弹性越好
        force.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY //阻尼系数 越小弹性越好
        force.finalPosition = 1.0f //最终缩放的比例
        scaleAnimationX.spring = force
        scaleAnimationX.setStartVelocity(10f)//初速度
        scaleAnimationY.spring = force
        scaleAnimationY.setStartVelocity(10f)//初速度
        buttom.setOnClickListener {
            scaleAnimationX.cancel()
            scaleAnimationY.cancel()
            if (scaleAnimationX.canSkipToEnd()) {
                scaleAnimationX.skipToEnd()
            }
            scaleAnimationX.start()
            if (scaleAnimationY.canSkipToEnd()) {
                scaleAnimationY.skipToEnd()
            }
            scaleAnimationY.start()
        }
    }
}
