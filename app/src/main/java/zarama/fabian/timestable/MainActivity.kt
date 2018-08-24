package zarama.fabian.timestable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var myViewList : ListView? = null

    //Create table method
    fun createTable(progress: Int){

        val timesTableContent = arrayListOf<String>()

        for (i in 0..10){
            timesTableContent.add((i*progress).toString())
        }

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent)

        myViewList!!.adapter = arrayAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Giving names to views
        val myTimesBar = findViewById<SeekBar>(R.id.timesBar)
         myViewList = findViewById<ListView>(R.id.timesListView)

        createTable(0)

        // Maximum location number
        myTimesBar.max = 10

        // Start location number
        myTimesBar.progress = 0

        var result = arrayListOf<Int>()



        // aqui toy, tratando de poner los 3 metodos q aparecen en el video
        myTimesBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                // Calling method to create table
                createTable(progress)

                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, seekBar.progress.toString(), duration)
                toast.show()

                //Log.i("myTimesBar", progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {


            }
        })


    }
}
