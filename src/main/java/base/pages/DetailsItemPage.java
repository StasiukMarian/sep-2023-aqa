package base.pages;

import base.config.PageTools;

public class DetailsItemPage extends PageTools {
    private final String itemHeader = "//div[contains(@class, 'inventory_details_name')]";
    private final String itemDescription = "(//div[contains(@class, 'inventory_details_desc')])[2]";
    private final String itemPrice = "//div[contains(@class, 'inventory_details_price')]";

    public Item getDetailedItem() {
        Item item = new Item();

        item.setName(getElementTextByXPath(itemHeader));
        item.setDescription(getElementTextByXPath(itemDescription));
        item.setPrice(getElementTextByXPath(itemPrice));
        return item;
    }
}
