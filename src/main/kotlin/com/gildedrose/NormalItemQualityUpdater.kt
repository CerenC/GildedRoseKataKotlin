package com.gildedrose

class NormalItemQualityUpdater : ItemQualityUpdater() {

    override fun update(item: Item) {
        item.sellIn -= 1

        item.quality = decrease(item.quality)
        if (item.sellIn < 0) {
            item.quality = decrease(item.quality)
        }
    }
}