package ch14;

public class Address { // 個々の住所データ
	private String name;
	private String address;
	private String tel;
	private String email;

	public Address(String name, String address, String tel, 
		String email) {
			this.name = name;
			this.address = address;
			this.tel = tel;
			this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		String str = "anAddress(" + name + "," + address + "," 
			+ tel + "," + email + ")";
		return str;
	}
	public boolean equals(Address anAddress) {
		boolean ans = getName().equals(anAddress.getName()) 
			&&  getAddress().equals(anAddress.getAddress())
			&&  getTel().equals(anAddress.getTel())
			&&  getEmail().equals(anAddress.getEmail());
		return ans;
	}

	public static void main(String[] args) {
		Address myAddress = new Address("電大太郎", "東京都千代田区", 
			"03-5280-XXXX", "taro@dendai.ac.jp");
		System.out.println(myAddress);
		myAddress.setAddress("東京都足立区");
		System.out.println(myAddress);
	}
}