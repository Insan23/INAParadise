package id.ac.unej.inaparadise.model

class Chat /*implements Comparable<Chat>*/ {
    var idChat: String? = null
    var chat: String? = null
    var senderLevel: String? = null
    var uidSender: String? = null

    //    public Long getTime() {
    var uidRecipient: String? = null

    //    private Long time;
    constructor() {}
    constructor(
        chat: String?,
        senderLevel: String?,
        uidSender: String?,
        uidRecipient: String? /*, Long time*/
    ) {
        this.chat = chat
        this.senderLevel = senderLevel
        this.uidSender = uidSender
        this.uidRecipient = uidRecipient
        //        this.time = time;
    }
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