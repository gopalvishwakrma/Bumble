package com.example.bumble

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

data class ModelsData(
    val image: Int,
    val name: String,
    val age: Int,
    val profession: String,
    val description: String,
    val distance: String
)

fun generateRandomData(): ModelsData {
    val femaleNames = listOf(
        "Alice",
        "Eva",
        "Grace",
        "Ivy",
        "Olivia",
        "Sophia",
        "Emma",
        "Chloe",
        "Isabella",
        "Ava",
        "Lily",
        "Zoe",
        "Amelia",
        "Harper",
        "Ella",
        "Scarlett",
        "Madison",
        "Sofia",
        "Abigail",
        "Emily",
        "Elizabeth",
        "Mila"
    )
    val randomProfessions = listOf(
        "Software Developer", "Graphic Designer", "Teacher", "Fashion Photographer", "Chef",
        "Doctor", "Engineer", "Journalist", "Architect", "Lawyer",
        "Musician", "Artist", "Writer", "Dancer", "Actor",
        "Photographer", "Designer", "Marketer", "Researcher", "Psychologist",
        "Fitness Trainer", "Chef"
    )
    val randomBios = listOf(
        "Hey there! I'm into various interests. Let's grab some coffee and see where things go!",
        "Hi! I enjoy exploring new places and trying out different cuisines. Looking for someone with a sense of adventure.",
        "Hello! I have a love for art and creativity. Let's create some beautiful memories together!",
        "Nice to meet you! I believe in the power of education. I also enjoy outdoor activities and meeting new people.",
        "Greetings! I have a keen interest in technology. Let's build something amazing!",
        "Hi! I am a professional cook. I love experimenting with different recipes and experimenting with different cuisines.",
        "Hello! I am a nature lover and enjoy hiking and camping. Looking for someone who shares the same passion.",
        "Hi! I am a bookworm and love to spend my free time reading. Would love to find someone who enjoys a good book.",
        "Hey! I am a fitness enthusiast and believe in leading a healthy lifestyle. Looking for a workout partner.",
        "Hello! I am a music lover and enjoy playing the guitar. Would love to jam with someone who shares the same interest.",
        "Hi! I am a movie buff and enjoy watching all kinds of movies. Looking for someone to share popcorn with.",
        "Hey! I am a foodie and love trying out new cuisines. Looking for someone to share a meal with.",
        "Hello! I am a travel enthusiast and love exploring new places. Looking for a travel buddy.",
        "Hi! I am a sports enthusiast and enjoy playing tennis. Looking for a tennis partner.",
        "Hey! I am a fashion enthusiast and love keeping up with the latest trends. Looking for someone who shares the same interest.",
        "Hello! I am a pet lover and have a cute dog. Looking for someone who loves pets.",
        "Hi! I am a photographer and love capturing beautiful moments. Looking for someone to share these moments with.",
        "Hey! I am a gamer and love playing video games. Looking for someone to join me in the virtual world.",
        "Hello! I am a history buff and love learning about different cultures. Looking for someone who shares the same interest.",
        "Hi! I am a science enthusiast and love learning about the universe. Looking for someone to explore the cosmos with.",
        "Hey! I am a yoga enthusiast and believe in leading a balanced life. Looking for a yoga partner.",
        "Hello! I am a coffee lover and enjoy visiting different coffee shops. Looking for someone to share a cup of coffee with."
    )
    val randomDistances = listOf(
        "1 mile away", "2 miles away", "3 miles away", "4 miles away", "5 miles away",
        "6 miles away", "7 miles away", "8 miles away", "9 miles away", "10 miles away",
        "11 miles away", "12 miles away", "13 miles away", "14 miles away", "15 miles away",
        "16 miles away", "17 miles away", "18 miles away", "19 miles away", "20 miles away",
        "21 miles away", "22 miles away"
    )

    val imageResources = intArrayOf(
        R.drawable.model_1,
        R.drawable.model_2,
        R.drawable.model_3,
        R.drawable.model_4,
        R.drawable.model_5,
        R.drawable.model_6,
        R.drawable.model_7,
        R.drawable.model_8,
        R.drawable.model_9,
        R.drawable.model_10,
        R.drawable.model_11,
        R.drawable.model_12,
        R.drawable.model_13,
        R.drawable.model_14,
        R.drawable.model_15,
        R.drawable.model_16,
        R.drawable.model_17,
        R.drawable.model_18,
        R.drawable.model_19,
        R.drawable.model_20,
        R.drawable.model_21,
        R.drawable.model_22
    )

    val randomAges = (25..46).toList().shuffled()

    return ModelsData(
        image = imageResources.random(),
        name = femaleNames.random(),
        age = randomAges.random(),
        profession = randomProfessions.random(),
        description = randomBios.random(),
        distance = randomDistances.random()
    )
}

val randomModelDataList = generateRandomData()


val notosansjpfonts = FontFamily(
    Font(R.font.notosansjp_thin, FontWeight.Light),
    Font(R.font.notosansjp_regular, FontWeight.Normal),
    Font(R.font.notosansjp_medium, FontWeight.Medium),
    Font(R.font.notosansjp_bold, FontWeight.Bold),
    Font(R.font.notosansjp_black, FontWeight.Black),
    Font(R.font.notosansjp_extrabold, FontWeight.ExtraBold),
    Font(R.font.notosansjp_extralight, FontWeight.ExtraLight),
    Font(R.font.notosansjp_light, FontWeight.Light),
    Font(R.font.notosansjp_extralight, FontWeight.Thin),
)