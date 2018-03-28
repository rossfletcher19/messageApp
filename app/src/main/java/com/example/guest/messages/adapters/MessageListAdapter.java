package com.example.guest.messages.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.messages.R;
import com.example.guest.messages.models.Chat;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ChatViewHolder> {
    private ArrayList<Chat> mChats = new ArrayList<>();
    private Context mContext;

    public MessageListAdapter(Context context, ArrayList<Chat> chats) {
        mContext = context;
        mChats = chats;
    }

    @Override
    public MessageListAdapter.ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
        ChatViewHolder viewHolder = new ChatViewHolder(view);
        return viewHolder;
    }

    @Override
    public  void onBindViewHolder(MessageListAdapter.ChatViewHolder holder, int position) {
        holder.bindChat(mChats.get(position));
    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUserName) TextView tvUserLabel;
        @BindView(R.id.tvMessage) TextView tvMessageLabel;

        private Context mContext;

        public ChatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindChat(Chat chat) {
            tvUserLabel.setText(chat.getSender());
            tvMessageLabel.setText(chat.getMessage());
        }

    }


}
