package uz.jahongir.roomdatabase

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread
import uz.jahongir.roomdatabase.adapters.MyRvAdapter
import uz.jahongir.roomdatabase.databinding.ActivityMainBinding
import uz.jahongir.roomdatabase.db.AppDataBase
import uz.jahongir.roomdatabase.db.MyContact

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDataBase: AppDataBase
    private lateinit var myRvAdapter: MyRvAdapter
    private lateinit var list: ArrayList<MyContact>

    @UiThread
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDataBase = AppDataBase.getInstance(this)
        list = ArrayList()

        myRvAdapter = MyRvAdapter(list)
        binding.myRv.adapter = myRvAdapter
        list.addAll(appDataBase.myContactDao().getContact())

        binding.btnSave.setOnClickListener {
            val myContact = MyContact(
                binding.edtName.text.toString(),
                binding.edtNumber.text.toString()
            )
            appDataBase.myContactDao().addContact(myContact)
            list.addAll(appDataBase.myContactDao().getContact())
            myRvAdapter.notifyDataSetChanged()
            binding.edtName.text.clear()
            binding.edtNumber.text.clear()

            Log.d(ContentValues.TAG, "onCreateView:$list")
            Toast.makeText(this@MainActivity, "Saved", Toast.LENGTH_SHORT).show()
        }
    }
}