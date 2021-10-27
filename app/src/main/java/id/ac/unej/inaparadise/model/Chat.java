package id.ac.unej.inaparadise.model;

import android.support.annotation.NonNull;

public class Chat /*implements Comparable<Chat>*/ {

    private String idChat;
    private String chat;
    private String senderLevel;
    private String uidSender;
    private String uidRecipient;
//    private Long time;

    public Chat() {
    }

    public Chat(String chat, String senderLevel, String uidSender, String uidRecipient/*, Long time*/) {
        this.chat = chat;
        this.senderLevel = senderLevel;
        this.uidSender = uidSender;
        this.uidRecipient = uidRecipient;
//        this.time = time;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getSenderLevel() {
        return senderLevel;
    }

    public void setSenderLevel(String senderLevel) {
        this.senderLevel = senderLevel;
    }

    public String getUidSender() {
        return uidSender;
    }

    public void setUidSender(String uidSender) {
        this.uidSender = uidSender;
    }

    public String getUidRecipient() {
        return uidRecipient;
    }

    public void setUidRecipient(String uidRecipient) {
        this.uidRecipient = uidRecipient;
    }

//    public Long getTime() {
//        return time;
//    }
//
//    public void setTime(Long time) {
//        this.time = time;
//    }
//
//    @Override
//    public int compareTo(@NonNull Chat o) {
//        return o.getTime().compareTo(this.time);
//    }
}
