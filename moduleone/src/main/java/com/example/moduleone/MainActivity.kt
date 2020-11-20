package com.example.moduleone

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance
import com.example.modulelibs.util.EventUtils
import com.example.moduleone.databinding.ActivityOneMainBinding

@Route(path = Contance.ACTIVITY_ONE)
class MainActivity : BaseActivity() {
    @Autowired(name = Contance.ACTIVITY_ONE+"test")
    lateinit var key:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_one_main)
        var binding = DataBindingUtil.setContentView<ActivityOneMainBinding>(this,R.layout.activity_one_main)
        binding.param = key

        binding.btnAnnotation.setOnClickListener{
            EventUtils.getInstance().post("testMyEventMsg","测试自定义注解!")
        }
    }

}
