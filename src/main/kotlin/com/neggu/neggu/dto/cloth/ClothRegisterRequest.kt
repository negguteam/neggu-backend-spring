package com.neggu.neggu.dto.cloth

import com.neggu.neggu.model.cloth.*
import io.swagger.v3.oas.annotations.media.Schema
import org.bson.types.ObjectId

@Schema(
    name = "ClothRegisterRequest",
    description = "옷 저장 요청",
)
data class ClothRegisterRequest(
    @Schema(description = "Color code of the clothing", example = "#FFFFFF")
    val colorCode: String,
    @Schema(description = "Name of the clothing", example = "아디다스 회색 후드")
    val name: String,
    @Schema(description = "Main category of the clothing", example = "TOP")
    val category: Category,
    @Schema(description = "Sub-category of the clothing", example = "SHIRT_BLOUSE")
    val subCategory: SubCategory,
    @Schema(description = "Mood tags associated with the clothing", example = "[\"FEMININE\", \"CASUAL\"]")
    val mood: List<Mood>,
    @Schema(description = "Brand of the clothing", example = "Adidas (nullable)")
    val brand: String?,
    @Schema(description = "Price range of the clothing", example = "UNDER_3K")
    val priceRange: PriceRange,
    @Schema(description = "Additional notes or memo", example = "Limited edition item (글자수 제한 X)")
    val memo: String = "",
    @Schema(description = "Purchase status of the clothing", example = "true")
    val isPurchase: Boolean = false,
    @Schema(description = "Link to purchase the clothing item", example = "https://example.com/item/12345 (nullable)")
    val link: String?,
) {

    fun toCloth(accountId : ObjectId, imageUrl: String?, clothColor: ClothColor): Cloth {
        return Cloth(
            accountId = accountId,
            imageUrl = imageUrl,
            category = category,
            subCategory = subCategory,
            mood = mood,
            brand = brand,
            priceRange = priceRange,
            memo = memo,
            isPurchase = isPurchase,
            link = link,
            name = name,
            colorCode = colorCode,
            color = clothColor,
        )
    }
}