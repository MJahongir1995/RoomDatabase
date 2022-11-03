package uz.jahongir.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.jahongir.roomdatabase.databinding.RvItemBinding
import uz.jahongir.roomdatabase.db.MyContact

class MyRvAdapter(var list: List<MyContact>):RecyclerView.Adapter<MyRvAdapter.VH>() {
    inner class VH(private var rvItemBinding: RvItemBinding): RecyclerView.ViewHolder(rvItemBinding.root) {
        fun onBind(myContact: MyContact, position: Int) {
            rvItemBinding.name.text = myContact.name
            rvItemBinding.number.text = myContact.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position], position)

    }
    override fun getItemCount(): Int = list.size
}
