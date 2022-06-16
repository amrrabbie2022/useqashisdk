package io.qashi.useqashisdk

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.qashi.sdkdemo.ToastActivity
import io.qashi.sdkdemo.CustomToast


class MainActivity : AppCompatActivity() {

    lateinit var ettitle:EditText
    lateinit var etbody:EditText
    lateinit var btnsend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ettitle=findViewById(R.id.ettitle)
        etbody=findViewById(R.id.etbody)
        btnsend=findViewById(R.id.btnsend)

        btnsend.setOnClickListener {
            var title:String=ettitle.text.toString()
            var body:String=etbody.text.toString()

            if(title.isEmpty()){
                Toast.makeText(this,"must enter title",Toast.LENGTH_SHORT).show()
            }else if(body.isEmpty()){
                Toast.makeText(this,"must enter body",Toast.LENGTH_SHORT).show()
            }else{
               // showMyDialog()
                //CustomToast.showCustomDialog(this,title,body)

                var c:CustomToast= CustomToast()
                c.showCustomDialog(this,title,body)

            }

        }


    }

    private fun showMyDialog() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.component = ComponentName(
            "io.qashi.useqashisdk",
            "io.qashi.sdkdemo.ToastActivity"
        )
        startActivity(intent)
    }
}