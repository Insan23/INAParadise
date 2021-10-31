package id.ac.unej.inaparadise.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import id.ac.unej.inaparadise.R
import android.widget.TextView
import id.ac.unej.inaparadise.model.Chat
import id.ac.unej.inaparadise.model.DaftarFeed

class ChatAdapter     /*this.listener = listener;*/(private val listChat: List<Chat> /*, OnItemClickListener listener*/) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    private val listener: OnItemClickListener? = null
    override fun getItemViewType(position: Int): Int {
        return if (listChat[position].senderLevel == "pengirim") {
            1
        } else if (listChat[position].senderLevel == "penerima") {
            0
        } else {
            -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View? = null
        return if (viewType == 1) {
            view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pesan_diterima, parent, false)
            ViewHolder(view, viewType)
        } else if (viewType == 0) {
            view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pesan_dikirim, parent, false)
            ViewHolder(view, viewType)
        } else {
            view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_pesan_awal, parent, false)
            ViewHolder(view, viewType)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listChat[position])
    }

    override fun getItemCount(): Int {
        return listChat.size
    }

    interface OnItemClickListener {
        fun onItemClick(model: Chat?)
    }

    inner class ViewHolder(itemView: View, private val viewType: Int) :
        RecyclerView.ViewHolder(itemView) {
        private var pesan: TextView? = null
        fun bind(model: Chat /*, final OnItemClickListener listener*/) {
            pesan!!.text = model.chat
        }

        init {
            pesan = if (viewType == 1) {
                itemView.findViewById<View>(R.id.teks_chat_diterima) as TextView
            } else if (viewType == 0) {
                itemView.findViewById<View>(R.id.teks_chat_dikirim) as TextView
            } else {
                itemView.findViewById<View>(R.id.teks_chat_awal) as TextView
            }
        }
    }
}