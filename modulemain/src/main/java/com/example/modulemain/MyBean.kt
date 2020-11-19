package com.example.modulemain

/**
 *
 * @ProjectName: ZPFModules
 * @Package: com.example.modulemain
 * @ClassName: MyBean
 * @Description: java类作用描述
 * @Author: 左鹏飞
 * @CreateDate: 20-11-16 下午4:45
 * @UpdateUser: 左鹏飞
 * @UpdateDate: 20-11-16 下午4:45
 * @UpdateRemark: 更新说明
 */
data class MyBean (
    val id: Long = System.currentTimeMillis(),
    var type:Int = 1
){
}