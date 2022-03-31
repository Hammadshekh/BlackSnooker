package com.example.messenger.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.black8snooker.R
import com.example.messenger.Message
import com.google.firebase.auth.FirebaseAuth

class MessageAdapter(val context: Context, val messageList: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM_RECEIVE = 1
    val ITEM_SENT = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            //inflate sent
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.sent_message, parent, false)
            return SentViewHolder(view)
        } else {
            //inflate receieve
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.receive_message, parent, false)
            return ReceiveViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentMessage = messageList[position]

        if (holder.javaClass == SentViewHolder::class.java) {
            //do stuff for sent view holder

            val viewHolder = holder as SentViewHolder
            holder.sentMessage.text = currentMessage.message

        } else {
            //do stuff for receive view holder

            val viewHolder = holder as ReceiveViewHolder
            holder.receiveMessage.text = currentMessage.message


        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messageList[position]
        return if (FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.senderId)) {
            ITEM_RECEIVE
        } else {
            ITEM_SENT
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class SentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sentMessage = itemView.findViewById<TextView>(R.id.txt_sent_message)
    }

    class ReceiveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val receiveMessage = itemView.findViewById<TextView>(R.id.txt_receive_message)
    }
}