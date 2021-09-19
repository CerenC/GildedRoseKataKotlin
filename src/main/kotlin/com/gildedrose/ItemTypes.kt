package com.gildedrose

enum class ItemTypes(val itemName: String, val updater: ItemQualityUpdater) {
    NORMAL("Normal", NormalItemQualityUpdater()),
    AGED_BRIE("Aged Brie", AgedBrieItemQualityUpdater()),
    BACK_STAGE("Backstage passes to a TAFKAL80ETC concert", BackStageItemQualityUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", SulfurasItemQualityUpdater()),
    CONJURED("Conjured Mana Cake", ConjuredItemQualityUpdater());

    companion object {
        fun getUpdater(itemName: String): ItemQualityUpdater =
            values().find { it.itemName == itemName }?.updater ?: NORMAL.updater
    }
}