package com.example.moduleone

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance
import com.example.modulelibs.util.EventUtils
import com.example.modulelibs.util.ToastUtil
import com.example.moduleone.databinding.ActivityOneMainBinding

@Route(path = Contance.ACTIVITY_ONE)
class OneMainActivity : BaseActivity() {
    @Autowired(name = Contance.ACTIVITY_ONE+"test")
    lateinit var key:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_one_main)
        var binding = DataBindingUtil.setContentView<ActivityOneMainBinding>(this,R.layout.activity_one_main)
        var viewmodel = OneMainViewModel()
        binding.param = key
        binding.viewmodle = viewmodel

        binding.btnNumber1.setOnClickListener{
            if(viewmodel.number1.value == null){
                viewmodel.number1.value = 0
            }
            viewmodel.number1.value = viewmodel.number1.value?.let {
                it+1
            }
            //ToastUtil.showToast(this@OneMainActivity,"number="+viewmodel.number.value)
            binding.viewmodle = viewmodel
        }

        binding.btnNumber2.setOnClickListener{
            if(viewmodel.number2.value == null){
                viewmodel.number2.value = 0
            }
            viewmodel.number2.value = viewmodel.number2.value?.let {
                it+1
            }
        }

        //用观察者刷新
        viewmodel.number2.observe(this, Observer {
            binding.btnNumber2.setText("方式二：observer监听执行刷新："+viewmodel.number2.value)
        })

        //用自定义注解刷新
        binding.btnNumber3.setOnClickListener{
            if(viewmodel.number3.value == null){
                viewmodel.number3.value = 0
            }
            viewmodel.number3.value = EventUtils.getInstance().post(Contance.ADD_NUMBER,viewmodel.number3.value) as Int?
            binding.btnNumber3.setText("方式三：用自定义注解执行刷新："+viewmodel.number3.value)
        }

        binding.btnAnnotation.setOnClickListener{
            EventUtils.getInstance().post(Contance.TEST_MY_EVENTMSG,"测试自定义注解!")
        }
    }

}
