package uz.jahongir.roomdatabase.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MyContact {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var name:String? = null
    var number:String? = null

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }

    constructor()

}