package id.ac.unej.inaparadise.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ac.unej.inaparadise.R;
import id.ac.unej.inaparadise.model.Chat;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Chat> listChat;
    private OnItemClickListener listener;

    public ChatAdapter(List<Chat> listChat /*, OnItemClickListener listener*/) {
        this.listChat = listChat;
        /*this.listener = listener;*/
    }

    @Override
    public int getItemViewType(int position) {
        if (listChat.get(position).getSenderLevel().equals("pengirim")) {
            return 1;
        } else if (listChat.get(position).getSenderLevel().equals("penerima")) {
            return 0;
        } else {
            return -1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan_diterima, parent, false);
            return new ViewHolder(view, viewType);
        } else if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan_dikirim, parent, false);
            return new ViewHolder(view, viewType);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesan_awal, parent, false);
            return new ViewHolder(view, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listChat.get(position));
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Chat model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private int viewType;
        private TextView pesan;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            if (viewType == 1) {
                pesan = (TextView) itemView.findViewById(R.id.teks_chat_diterima);
            } else if (viewType == 0) {
                pesan = (TextView) itemView.findViewById(R.id.teks_chat_dikirim);
            } else {
                pesan = (TextView) itemView.findViewById(R.id.teks_chat_awal);
            }
        }

        public void bind(final Chat model /*, final OnItemClickListener listener*/) {
            pesan.setText(model.getChat());
        }
    }
}

