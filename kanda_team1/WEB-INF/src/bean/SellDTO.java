package bean;

public class SellDTO {

	private int sellId;
	private int sellerMemberId;
	private int purchaserMemberId;
	private int productName;
	private int productTypeId;
	private int price;
	private int prefecturesId;
	private int remarks;
	private int deliveryDays;
	private int productCondition;
	private String imageId;
	private int sellStatus;
	private String  sellDate;
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public int getSellerMemberId() {
		return sellerMemberId;
	}
	public void setSellerMemberId(int sellerMemberId) {
		this.sellerMemberId = sellerMemberId;
	}
	public int getPurchaserMemberId() {
		return purchaserMemberId;
	}
	public void setPurchaserMemberId(int purchaserMemberId) {
		this.purchaserMemberId = purchaserMemberId;
	}
	public int getProductName() {
		return productName;
	}
	public void setProductName(int productName) {
		this.productName = productName;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrefecturesId() {
		return prefecturesId;
	}
	public void setPrefecturesId(int prefecturesId) {
		this.prefecturesId = prefecturesId;
	}
	public int getRemarks() {
		return remarks;
	}
	public void setRemarks(int remarks) {
		this.remarks = remarks;
	}
	public int getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	public int getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(int productCondition) {
		this.productCondition = productCondition;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public int getSellStatus() {
		return sellStatus;
	}
	public void setSellStatus(int sellStatus) {
		this.sellStatus = sellStatus;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public String getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	private String purchaseDate;
	private String transferDate;
	private String shipmentDate;
	private String completionDate;

}
