package com.example.moduletwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.modulelibs.base.BaseActivity
import com.example.modulelibs.util.Contance

@Route(path = Contance.ACTIVITY_TWO)
class TwoMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_two_main
    }
}
