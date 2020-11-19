package com.example.zpfmodules

import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var openmainButton = findViewById<Button>(R.id.btn_openmain)
        openmainButton.setOnClickListener{
            ARouter.getInstance().build(Contance.ACTIVITY_MAIN).navigation()
        }
        var openoneButton = findViewById<Button>(R.id.btn_openone)
        openoneButton.setOnClickListener{
            ARouter.getInstance().build(Contance.ACTIVITY_ONE).withString(Contance.ACTIVITY_ONE+"test","我是带参").navigation()
        }
        var opentwoButton = findViewById<Button>(R.id.btn_opentwo)
        opentwoButton.setOnClickListener{
            ARouter.getInstance().build(Contance.ACTIVITY_TWO).navigation()
        }
    }

}
