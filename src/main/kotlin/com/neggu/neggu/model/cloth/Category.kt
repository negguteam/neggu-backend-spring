package com.neggu.neggu.model.cloth

enum class Category(val displayName: String, val subCategories: List<SubCategory>) {
    TOP(
        "상의",
        listOf(
            SubCategory.SWEATSHIRT,
            SubCategory.SHIRT_BLOUSE,
            SubCategory.HOODIE,
            SubCategory.KNIT,
            SubCategory.T_SHIRT,
            SubCategory.SLEEVELESS
        )
    ),

    OUTER(
        "아우터",
        listOf(
            SubCategory.JACKET,
            SubCategory.ZIP_UP_HOODIE,
            SubCategory.CARDIGAN,
            SubCategory.FLEECE,
            SubCategory.COAT,
            SubCategory.PUFFER,
            SubCategory.VEST
        )
    ),

    BOTTOM(
        "하의",
        listOf(
            SubCategory.JEANS,
            SubCategory.SLACKS,
            SubCategory.SHORTS,
            SubCategory.JUMPSUIT,
            SubCategory.SKIRT
        )
    ),


        DRESS(
            "원피스",
           listOf(
                SubCategory.DRESS
            )
        ),

       ACCESSORY(
           "악세서리",
           listOf(
               SubCategory.NECKLACE,
               SubCategory.EARRINGS,
               SubCategory.BRACELET,
               SubCategory.RING,
               SubCategory.HAIR_ACCESSORY,
               SubCategory.BELT,
               SubCategory.WATCH
           )
       ),

       BAG(
           "가방",
           listOf(
               SubCategory.BACKPACK,
               SubCategory.TOTE_BAG,
               SubCategory.CLUTCH,
               SubCategory.CROSSBODY_BAG,
               SubCategory.SHOULDER_BAG,
               SubCategory.LUGGAGE
           )
       ),

       SHOES(
           "신발",
           listOf(
               SubCategory.SNEAKERS,
               SubCategory.DRESS_SHOES,
               SubCategory.BOOTS,
               SubCategory.SANDALS,
               SubCategory.SLIPPERS,
               SubCategory.FLATS
           )
       );
}

enum class SubCategory(val displayName: String) {
    // 상의
    SWEATSHIRT("맨투맨"),
    SHIRT_BLOUSE("셔츠/블라우스"),
    HOODIE("후드"),
    KNIT("니트"),
    T_SHIRT("티셔츠"),
    SLEEVELESS("민소매"),

    // 아우터
    JACKET("자켓"),
    ZIP_UP_HOODIE("후드집업"),
    CARDIGAN("가디건"),
    FLEECE("플리스"),
    COAT("코트"),
    PUFFER("패팅"),
    VEST("베스트"),

    // 하의
    JEANS("데님팬츠"),
    SLACKS("슬랙스"),
    SHORTS("숏팬츠"),
    JUMPSUIT("점프슈트"),
    SKIRT("스커트"),

    // 원피스
    DRESS("원피스"),

    // 악세서리
    NECKLACE("목걸이"),
    EARRINGS("귀걸이"),
    BRACELET("팔찌"),
    RING("반지"),
    HAIR_ACCESSORY("헤어 악세서리"),
    BELT("벨트"),
    WATCH("시계"),

    // 가방
    BACKPACK("백팩"),
    TOTE_BAG("토트백"),
    CLUTCH("클러치"),
    CROSSBODY_BAG("크로스바디백"),
    SHOULDER_BAG("숄더백"),
    LUGGAGE("러기지"),

    // 신발
    SNEAKERS("운동화"),
    DRESS_SHOES("구두"),
    BOOTS("부츠"),
    SANDALS("샌들"),
    SLIPPERS("슬리퍼"),
    FLATS("플랫슈즈");
}