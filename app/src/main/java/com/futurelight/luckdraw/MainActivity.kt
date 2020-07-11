package com.futurelight.luckdraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var names = listOf<String>("张三","李四","老王")

    lateinit var timer : Timer
    //记录当前索引
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){

        NametextView.text = names[0]
        //点击按钮事件
        StartButton.setOnClickListener{
            //判读是Star还是Stop

            if(StartButton.text.toString() == "START"){
                StartButton.text = "STOP"

                timer = Timer()
                timer.schedule(object:TimerTask(){
                    override fun run() {
                     index =  if(index + 1 > names.size -1) 0 else index+1
                        NametextView.text = names[index]
                    }
                },0,100)
            }else{
                StartButton.text = "START"
                timer.cancel()
            }
        }


    }
}
