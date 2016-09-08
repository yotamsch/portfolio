public class IPAddressString implements IPAddress {

	private String address;

	IPAddressString(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return address;
	}

	@Override
	public boolean equals(IPAddress other) {
		return (this.toString().equals(other.toString()));
	}

	@Override
	public int getOctet(int index) {
		return Integer.parseInt(this.toString().split(".")[index]);
	}

	@Override
	public boolean isPrivateNetwork(){
		// 10.0.0.0 - 10.255.255.255
		if (getOctet(0) == 10) {
			return true;
		}

		// 172.16.0.0 - 172.31.255.255
		if (getOctet(0) == 172 && getOctet(1) >= 16 && getOctet(1) <= 31) {
			return true;
		}

		// 192.168.0.0 - 192.168.255.255
		if (getOctet(0) == 192 && getOctet(1) == 168) {
			return true;
		}

		// 169.254.0.0 - 169.254.255.255
		if (getOctet(0) == 169 && getOctet(1) == 254) {
			return true;
		}

		return false;
	}

}
