package com.example.marathon.dtos;

import com.example.marathon.entities.Cart;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ItemDTO {

  @JsonProperty("item_id")
  private int itemId;

  @JsonProperty("item_name")
  private  String itemName;

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public LocalDateTime getMfgDate() {
    return mfgDate;
  }

  public void setMfgDate(LocalDateTime mfgDate) {
    this.mfgDate = mfgDate;
  }

  @JsonProperty("item_description")
  private  String itemDescription;

  @Override
  public String toString() {
    return "ItemDTO{" +
            "itemId=" + itemId +
            ", itemName='" + itemName + '\'' +
            ", itemDescription='" + itemDescription + '\'' +
            ", category='" + category + '\'' +
            ", cost=" + cost +
            ", mfgDate=" + mfgDate +
            ", cartDTO=" + cartDTO +
            '}';
  }

  private  String category;
  private  double cost;
  @JsonProperty("mfg_date")
  private LocalDateTime mfgDate;

  public CartDTO getCartDTO() {
    return cartDTO;
  }

  public void setCartDTO(CartDTO cartDTO) {
    this.cartDTO = cartDTO;
  }

  private CartDTO cartDTO;

}
