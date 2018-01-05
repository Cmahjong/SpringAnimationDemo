package taotao.haoxiong.com.springanimationdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import kotlinx.android.synthetic.main.activity_rotation.*

class RotationActivity : AppCompatActivity() {
    val rotationSpringAnimation: SpringAnimation by lazy {
//        SpringAnimation(img, DynamicAnimation.ROTATION_X)
//        SpringAnimation(img, DynamicAnimation.ROTATION_Y)
        SpringAnimation(img, DynamicAnimation.ROTATION)
    }
    val force: SpringForce by lazy {
        SpringForce()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotation)
        force.stiffness=SpringForce.STIFFNESS_VERY_LOW //刚度 刚度越小弹性越好
        force.dampingRatio=SpringForce.DAMPING_RATIO_HIGH_BOUNCY //阻尼系数 越小弹性越好
        force.finalPosition = 90f //最终旋转的角度
        rotationSpringAnimation.spring=force
        rotationSpringAnimation.setStartVelocity(10000F)
        rotationSpringAnimation.addEndListener { animation, canceled, value, velocity ->
            //            img.alpha=value
        }
        rotationSpringAnimation.addEndListener { animation, canceled, value, velocity ->
            //            img.alpha=1.0F
        }
        buttom.setOnClickListener {
            rotationSpringAnimation.cancel()
            rotationSpringAnimation.start()
        }
    }
}
