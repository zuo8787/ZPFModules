package com.example.zpfmodules

import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance
import com.example.modulelibs.util.EventUtils
import com.example.modulelibs.util.MyEventMsg
import com.example.modulelibs.util.ToastUtil

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EventUtils.getInstance().init(this)

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

    override fun onDestroy() {
        super.onDestroy()
        EventUtils.getInstance().destroy(this)
    }

    @MyEventMsg(functionName = Contance.TEST_MY_EVENTMSG)
    fun testMyEventMsg(msg:String):String{
        ToastUtil.showToast(this,msg)
        return msg
    }

    @MyEventMsg(functionName = Contance.ADD_NUMBER)
    fun addNumber(number:Int):Int{
        var number = number
        return ++number
    }

}
