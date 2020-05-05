package com.example.shiviMittal.ChatList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.R

class ChatListAdapter: RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {


    var chatList: MutableList<ChatList> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.chat_list_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name_user.text = chatList[position].name
        holder.unseen_msg.text = chatList[position].lastmsg
        //create for time
        holder.profile_image.setImageResource(R.mipmap.ic_launcher)//to be modified when setting perfect profile pictures

        /* holder.itemView.setOnClickListener (object : View.OnClickListener {
            override fun onClick(view: View?) {

                val intent= Intent(,ChatList::class.java)
                intent.putExtra("ReceiverId","20190383")
                context.startActivity(intent)
            }
        }
        )*/
    }



       fun setData( chatList:MutableList<ChatList>){
           this.chatList = chatList
           notifyDataSetChanged()
       }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name_user: TextView = itemView.findViewById(R.id.username)
        val unseen_msg: TextView =itemView.findViewById(R.id.message)
        //create for time
        val profile_image= itemView.findViewById<ImageView>(R.id.profile_image)
    }
    }

