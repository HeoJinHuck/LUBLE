package vo;

public class ShoseInfo {
	private String shonum;
	private String userid;
	private String Brand;
	private String Model;
	private int price;
	private String size;
	private String packag;
	private String pass;
	private int checkprice;
	private String shoImage;
	private String count;
	private String sell;
	private String ispurchase;
	private String address;
	private String point;
	private String kind; // kind 추가 
	private int shoedelete;
	
	public int getShoedelete() {
		return shoedelete;
	}
	public void setShoedelete(int shoedelete) {
		this.shoedelete = shoedelete;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getIspurchase() {
		return ispurchase;
	}
	public void setIspurchase(String ispurchase) {
		this.ispurchase = ispurchase;
	}
	public String getSell() {
		return sell;
	}
	public void setSell(String sell) {
		this.sell = sell;
	}
	public String getCount() {
		return count;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getShoImage() {
		return shoImage;
	}
	public void setShoImage(String shoImage) {
		this.shoImage = shoImage;
	}
	public String getShonum() {
		return shonum;
	}
	public void setShonum(String shonum) {
		this.shonum = shonum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPackag() {
		return packag;
	}
	public void setPackag(String packag) {
		this.packag = packag;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getCheckprice() {
		return checkprice;
	}
	public void setCheckprice(int checkprice) {
		this.checkprice = checkprice;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
