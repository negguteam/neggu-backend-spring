package com.neggu.neggu.model.cloth

enum class ClothColor(
    val displayName: String,
    val groups: List<ColorGroup>,
    val englishName: String,
    val hex: String?,
) {
    WHITE("화이트", listOf(ColorGroup.WHITE), "White", "#FFFFFF"),
    LIGHT_GRAY("라이트 그레이", listOf(ColorGroup.GRAY), "Light Gray", "#CECECC"),
    GRAY("그레이", listOf(ColorGroup.GRAY), "Gray", "#838383"),
    DARK_GRAY("다크 그레이", listOf(ColorGroup.GRAY), "Dark Gray", "#414346"),
    BLACK("블랙", listOf(ColorGroup.BLACK), "Black", "#000000"),
    DEEP_RED("딥레드", listOf(ColorGroup.RED), "Deep Red", "#6D2A2E"),
    RED("레드", listOf(ColorGroup.RED), "Red", "#FF0000"),
    PINK("핑크", listOf(ColorGroup.PINK), "Pink", "#C43B86"),
    LIGHT_PINK("라이트 핑크", listOf(ColorGroup.PINK), "Light Pink", "#DE98A5"),
    PALE_PINK("페일 핑크", listOf(ColorGroup.PINK), "Pale Pink", "#BE978A"),
    ORANGE("오렌지", listOf(ColorGroup.ORANGE), "Orange", "#FF6200"),
    IVORY("아이보리", listOf(ColorGroup.BROWN, ColorGroup.YELLOW), "Ivory", "#FEFFED"),
    LIGHT_YELLOW("라이트 옐로우", listOf(ColorGroup.BROWN, ColorGroup.YELLOW), "Light Yellow", "#FFF4BD"),
    YELLOW("옐로우", listOf(ColorGroup.YELLOW), "Yellow", "#FFEA00"),
    LIGHT_GREEN("라이트 그린", listOf(ColorGroup.GREEN), "Light Green", "#82FA4A"),
    MINT("민트", listOf(ColorGroup.GREEN), "Mint", "#6BAB97"),
    GREEN("그린", listOf(ColorGroup.GREEN), "Green", "#4EA02A"),
    OLIVE_GREEN("올리브 그린", listOf(ColorGroup.GREEN), "Olive Green", "#686F3A"),
    KHAKI("카키", listOf(ColorGroup.GREEN), "Khaki", "#464630"),
    DARK_GREEN("다크 그린", listOf(ColorGroup.GREEN), "Dark Green", "#24311F"),
    SKY_BLUE("스카이 블루", listOf(ColorGroup.BLUE), "Sky Blue", "#BAE0FF"),
    BLUE("블루", listOf(ColorGroup.BLUE), "Blue", "#1C17E9"),
    NAVY("네이비", listOf(ColorGroup.BLUE), "Navy", "#111A49"),
    LAVENDER("라벤더", listOf(ColorGroup.PURPLE), "Lavender", "#8467B3"),
    PURPLE("퍼플", listOf(ColorGroup.PURPLE), "Purple", "#351554"),
    BURGUNDY("버건디", listOf(ColorGroup.RED, ColorGroup.BROWN), "Burgundy", "#D6E2FB"),
    BROWN("브라운", listOf(ColorGroup.RED), "Brown", "#452B15"),
    KHAKI_BEIGE("카키 베이지", listOf(ColorGroup.GREEN, ColorGroup.BROWN), "Khaki Beige", "#7E7725"),
    CAMEL("브라운", listOf(ColorGroup.BROWN), "Camel", "#B58B3E"),
    BEIGE("베이지", listOf(ColorGroup.BROWN, ColorGroup.YELLOW), "Beige", "#D0B577"),
    OTHERS("그 외", listOf(ColorGroup.NONE), "Others",  null);
}