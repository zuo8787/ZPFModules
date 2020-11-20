package com.example.moduleone

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * @ProjectName: ZPFModules
 * @Package: com.example.moduleone
 * @ClassName: OneMainViewModel
 * @Description: java类作用描述
 * @Author: 左鹏飞
 * @CreateDate: 20-11-20 下午4:18
 * @UpdateUser: 左鹏飞
 * @UpdateDate: 20-11-20 下午4:18
 * @UpdateRemark: 更新说明
 */
class OneMainViewModel: ViewModel() {
    var number1:MutableLiveData<Int> = MutableLiveData()
    var number2:MutableLiveData<Int> = MutableLiveData()
    var number3:MutableLiveData<Int> = MutableLiveData()
}