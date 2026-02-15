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

    fun timeLabel(time: PrayerTime): String = when (this) {
        Language.ENGLISH -> when (time) {
            PrayerTime.MORNING -> "Morning"
            PrayerTime.AFTERNOON -> "Noon"
            PrayerTime.EVENING -> "Evening"
            PrayerTime.NIGHT -> "Night"
        }
        Language.TELUGU -> when (time) {
            PrayerTime.MORNING -> "ఉదయం"
            PrayerTime.AFTERNOON -> "మధ్యాహ్నం"
            PrayerTime.EVENING -> "సాయంత్రం"
            PrayerTime.NIGHT -> "రాత్రి"
        }
        Language.HINDI -> when (time) {
            PrayerTime.MORNING -> "सुबह"
            PrayerTime.AFTERNOON -> "दोपहर"
            PrayerTime.EVENING -> "शाम"
            PrayerTime.NIGHT -> "रात"
        }
        Language.TAMIL -> when (time) {
            PrayerTime.MORNING -> "காலை"
            PrayerTime.AFTERNOON -> "மதியம்"
            PrayerTime.EVENING -> "மாலை"
            PrayerTime.NIGHT -> "இரவு"
        }
        Language.MARATHI -> when (time) {
            PrayerTime.MORNING -> "सकाळ"
            PrayerTime.AFTERNOON -> "दुपार"
            PrayerTime.EVENING -> "संध्याकाळ"
            PrayerTime.NIGHT -> "रात्र"
        }
        Language.MALAYALAM -> when (time) {
            PrayerTime.MORNING -> "രാവിലെ"
            PrayerTime.AFTERNOON -> "ഉച്ച"
            PrayerTime.EVENING -> "വൈകുന്നേരം"
            PrayerTime.NIGHT -> "രാത്രി"
        }
        Language.BENGALI -> when (time) {
            PrayerTime.MORNING -> "সকাল"
            PrayerTime.AFTERNOON -> "দুপুর"
            PrayerTime.EVENING -> "সন্ধ্যা"
            PrayerTime.NIGHT -> "রাত"
        }
        Language.ODIA -> when (time) {
            PrayerTime.MORNING -> "ସକାଳ"
            PrayerTime.AFTERNOON -> "ଦୁପର"
            PrayerTime.EVENING -> "ସନ୍ଧ୍ୟା"
            PrayerTime.NIGHT -> "ରାତି"
        }
        Language.GUJARATI -> when (time) {
            PrayerTime.MORNING -> "સવાર"
            PrayerTime.AFTERNOON -> "બપોર"
            PrayerTime.EVENING -> "સાંજ"
            PrayerTime.NIGHT -> "રાત"
        }
        Language.KANNADA -> when (time) {
            PrayerTime.MORNING -> "ಬೆಳಿಗ್ಗೆ"
            PrayerTime.AFTERNOON -> "ಮಧ್ಯಾಹ್ನ"
            PrayerTime.EVENING -> "ಸಂಜೆ"
            PrayerTime.NIGHT -> "ರಾತ್ರಿ"
        }
    }

    fun ritualLabel(time: PrayerTime): String = when (this) {
        Language.ENGLISH -> when (time) {
            PrayerTime.MORNING -> "Kakad"
            PrayerTime.AFTERNOON -> "Madhyan"
            PrayerTime.EVENING -> "Dhoop"
            PrayerTime.NIGHT -> "Shej"
        }
        Language.TELUGU -> when (time) {
            PrayerTime.MORNING -> "కాకడ్"
            PrayerTime.AFTERNOON -> "మధ్యాన్"
            PrayerTime.EVENING -> "ధూప్"
            PrayerTime.NIGHT -> "శేజ్"
        }
        Language.HINDI -> when (time) {
            PrayerTime.MORNING -> "काकड़"
            PrayerTime.AFTERNOON -> "मध्याह्न"
            PrayerTime.EVENING -> "धूप"
            PrayerTime.NIGHT -> "शेज"
        }
        Language.TAMIL -> when (time) {
            PrayerTime.MORNING -> "காகட்"
            PrayerTime.AFTERNOON -> "மத்யான்"
            PrayerTime.EVENING -> "தூப்"
            PrayerTime.NIGHT -> "ஷேஜ்"
        }
        Language.MARATHI -> when (time) {
            PrayerTime.MORNING -> "काकड"
            PrayerTime.AFTERNOON -> "मध्याण"
            PrayerTime.EVENING -> "धूप"
            PrayerTime.NIGHT -> "शेज"
        }
        Language.MALAYALAM -> when (time) {
            PrayerTime.MORNING -> "കാകഡ്"
            PrayerTime.AFTERNOON -> "മധ്യാൻ"
            PrayerTime.EVENING -> "ധൂപ്"
            PrayerTime.NIGHT -> "ഷേജ്"
        }
        Language.BENGALI -> when (time) {
            PrayerTime.MORNING -> "কাকড়"
            PrayerTime.AFTERNOON -> "মধ্যান"
            PrayerTime.EVENING -> "ধূপ"
            PrayerTime.NIGHT -> "শেজ"
        }
        Language.ODIA -> when (time) {
            PrayerTime.MORNING -> "କାକଡ଼"
            PrayerTime.AFTERNOON -> "ମଧ୍ୟାନ"
            PrayerTime.EVENING -> "ଧୂପ"
            PrayerTime.NIGHT -> "ଶେଜ"
        }
        Language.GUJARATI -> when (time) {
            PrayerTime.MORNING -> "કાકડ"
            PrayerTime.AFTERNOON -> "મધ્યાન"
            PrayerTime.EVENING -> "ધૂપ"
            PrayerTime.NIGHT -> "શેજ"
        }
        Language.KANNADA -> when (time) {
            PrayerTime.MORNING -> "ಕಾಕಡ್"
            PrayerTime.AFTERNOON -> "ಮಧ್ಯಾನ್"
            PrayerTime.EVENING -> "ಧೂಪ್"
            PrayerTime.NIGHT -> "ಶೇಜ್"
        }
    }
}
