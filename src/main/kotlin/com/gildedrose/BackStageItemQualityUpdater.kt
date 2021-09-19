package com.gildedrose


class BackStageItemQualityUpdater : ItemQualityUpdater() {

    override fun update(item: Item) {
        item.sellIn -= 1

        when {
            item.sellIn < 0 -> item.quality = 0
            item.sellIn < 5 -> item.quality = increase(item.quality, 3)
            item.sellIn < 10 -> item.quality = increase(item.quality, 2)
            else -> item.quality = increase(item.quality)
        }
    }
}