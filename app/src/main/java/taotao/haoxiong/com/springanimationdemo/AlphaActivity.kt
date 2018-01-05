package taotao.haoxiong.com.springanimationdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import kotlinx.android.synthetic.main.activity_alpha.*

class AlphaActivity : AppCompatActivity() {
    val alphaSpringAnimation:SpringAnimation by lazy {
        SpringAnimation(img,DynamicAnimation.ROTATION)
    }
    val force:SpringForce by lazy {
        SpringForce()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alpha)
        force.stiffness=SpringForce.STIFFNESS_VERY_LOW //刚度 刚度越小弹性越好
        force.dampingRatio=SpringForce.DAMPING_RATIO_HIGH_BOUNCY //阻尼系数 越小弹性越好
        force.finalPosition = 1.0f //最终透明的比例
        alphaSpringAnimation.spring=force
        alphaSpringAnimation.setStartVelocity(100F)
        alphaSpringAnimation.addEndListener { animation, canceled, value, velocity ->
//            img.alpha=value
        }
        alphaSpringAnimation.addEndListener { animation, canceled, value, velocity ->
//            img.alpha=1.0F
        }
        buttom.setOnClickListener {
            alphaSpringAnimation.cancel()
            alphaSpringAnimation.start()
        }
    }
}
