package com.yonasoft.areader.model

data class MUser(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val quote: String,
    val profession: String
){
    fun toMap():MutableMap<String, Any>{
        return mutableMapOf(
            "user_id" to this.userId,
            "display" to this. displayName,
            "quote" to this.quote,
            "profession" to this.profession,
            "avatar_url" to this.avatarUrl
        )
    }
}
