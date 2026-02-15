package com.mahameet.apps.saiaarti.feature.prayers.domain.model

enum class Language(
    val code: String,
    val nativeName: String,
    val englishName: String,
    val badge: String
) {
    TELUGU("te", "తెలుగు", "Telugu", "తె"),
    HINDI("hi", "हिन्दी", "Hindi", "हि"),
    ENGLISH("en", "English", "English", "EN"),
    TAMIL("ta", "தமிழ்", "Tamil", "த"),
    MARATHI("mr", "मराठी", "Marathi", "म"),
    MALAYALAM("ml", "മലയാളം", "Malayalam", "മ"),
    BENGALI("bn", "বাংলা", "Bengali", "বা"),

    ODIA("od", "ଓଡ଼ିଆ", "Odia", "ଓ"),
    GUJARATI("gj", "ગુજરાતી", "Gujarati", "ગુ"),
    KANNADA("ka", "ಕನ್ನಡ", "Kannada", "ಕ");
}
